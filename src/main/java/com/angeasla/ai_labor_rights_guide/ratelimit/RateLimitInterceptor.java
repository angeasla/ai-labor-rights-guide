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

    /**
     * Real client IP. Behind nginx, {@code getRemoteAddr()} is the proxy, so prefer {@code X-Real-IP}
     * (set by nginx to the true peer). Trustworthy because in production the backend is reachable only
     * through nginx (internal network). Falls back to the last {@code X-Forwarded-For} hop (the peer
     * nginx appended — earlier entries are client-spoofable), then to the socket address (dev/no-proxy).
     */
    private static String clientIp(HttpServletRequest request) {
        String realIp = request.getHeader("X-Real-IP");
        if (realIp != null && !realIp.isBlank()) {
            return realIp.trim();
        }
        String forwarded = request.getHeader("X-Forwarded-For");
        if (forwarded != null && !forwarded.isBlank()) {
            String[] hops = forwarded.split(",");
            return hops[hops.length - 1].trim();
        }
        return request.getRemoteAddr();
    }
}
