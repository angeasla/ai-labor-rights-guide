package com.angeasla.ai_labor_rights_guide.ratelimit;

import tools.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

/**
 * Applies {@link RateLimitingService} to {@code /api/chat} and {@code /api/search}. On rejection it
 * short-circuits with HTTP 429, a {@code Retry-After} header and a small JSON body. Registered for
 * those paths only (calculators and the wiki are unthrottled) in {@code WebConfig}.
 */
public class RateLimitInterceptor implements HandlerInterceptor {

    private final RateLimitingService rateLimiter;
    private final ObjectMapper objectMapper;

    public RateLimitInterceptor(RateLimitingService rateLimiter, ObjectMapper objectMapper) {
        this.rateLimiter = rateLimiter;
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (isPreflight(request)) {
            return true; // never throttle CORS preflight
        }

        String path = request.getRequestURI();
        RateLimitingService.Decision decision;
        if (path.startsWith("/api/chat")) {
            decision = rateLimiter.checkChat(clientIp(request));
        } else if (path.startsWith("/api/search")) {
            decision = rateLimiter.checkSearch(clientIp(request));
        } else {
            return true; // not a throttled path
        }

        if (decision.allowed()) {
            return true;
        }

        response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
        response.setHeader(HttpHeaders.RETRY_AFTER, Long.toString(decision.retryAfterSeconds()));
        response.setContentType(MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8");
        objectMapper.writeValue(response.getWriter(), Map.of(
                "error", decision.message(),
                "retryAfterSeconds", decision.retryAfterSeconds()));
        return false;
    }

    private static boolean isPreflight(HttpServletRequest request) {
        return "OPTIONS".equalsIgnoreCase(request.getMethod());
    }

    /** Delegates client-IP resolution (proxy-trust aware) to {@link RateLimitingService}. */
    private String clientIp(HttpServletRequest request) {
        return rateLimiter.resolveClientIp(
                request.getRemoteAddr(),
                request.getHeader("X-Real-IP"),
                request.getHeader("X-Forwarded-For"));
    }
}
