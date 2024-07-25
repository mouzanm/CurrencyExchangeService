package com.api.CurrencyExchangeService;

import io.jsonwebtoken.Claims;

import io.jsonwebtoken.Jwts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@Component
public class JwtFilter extends GenericFilterBean {

    private static final Logger logger = LoggerFactory.getLogger(JwtFilter.class);

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        final String authHeader = request.getHeader("Authorization");
        logger.debug("Authorization header: {}", authHeader);
        // Allow OPTIONS requests to proceed without further processing
        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(request, response);
            return;
        }

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            // Send a 401 Unauthorized response when JWT token is missing or invalid
            logger.warn("Missing or invalid JWT token");
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Missing or invalid JWT token");
            return;
        }

        final String token = authHeader.substring(7);
        logger.debug("JWT token: {}", token);
        try {
            // Parse and validate the JWT token
        	Claims claims = Jwts.parser().setSigningKey("secret").parseClaimsJws(token).getBody();

            // Log the parsed claims
            logger.debug("JWT claims: {}", claims);

            // Set claims and proceed with the filter chain
            request.setAttribute("claims", claims);
            request.setAttribute("blog", servletRequest.getParameter("id"));
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            // Send a 401 Unauthorized response when JWT token is invalid
            logger.warn("Invalid JWT token", e);
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid JWT token");
        }
    }
}
