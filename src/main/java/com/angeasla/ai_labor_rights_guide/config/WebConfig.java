package com.angeasla.ai_labor_rights_guide.config;

import com.angeasla.ai_labor_rights_guide.ratelimit.RateLimitInterceptor;
import com.angeasla.ai_labor_rights_guide.ratelimit.RateLimitProperties;
import com.angeasla.ai_labor_rights_guide.ratelimit.RateLimitingService;
import tools.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * CORS for the Angular frontend, driven by the {@code app.cors.allowed-origins} property
 * (comma-separated, overridable via the CORS_ALLOWED_ORIGINS env var). Replaces the per-controller
 * {@code @CrossOrigin} annotations. Empty in production, where nginx serves frontend + API same-origin.
 *
 * <p>Also registers the per-IP {@link RateLimitInterceptor} on the expensive endpoints
 * ({@code /api/chat}, {@code /api/search}); calculators and the wiki are left unthrottled.
 */
@Configuration
@EnableConfigurationProperties(RateLimitProperties.class)
public class WebConfig implements WebMvcConfigurer {

    private final String[] allowedOrigins;
    private final RateLimitingService rateLimiter;
    private final ObjectMapper objectMapper;

    public WebConfig(@Value("${app.cors.allowed-origins:}") String[] allowedOrigins,
                     RateLimitingService rateLimiter,
                     ObjectMapper objectMapper) {
        this.allowedOrigins = allowedOrigins;
        this.rateLimiter = rateLimiter;
        this.objectMapper = objectMapper;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        boolean hasOrigins = allowedOrigins != null && allowedOrigins.length > 0
                && !(allowedOrigins.length == 1 && allowedOrigins[0].isBlank());
        if (hasOrigins) {
            registry.addMapping("/api/**")
                    .allowedOrigins(allowedOrigins)
                    .allowedMethods("GET", "POST", "OPTIONS")
                    .allowedHeaders("*");
        }
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RateLimitInterceptor(rateLimiter, objectMapper))
                .addPathPatterns("/api/chat", "/api/chat/**", "/api/search", "/api/search/**");
    }
}
