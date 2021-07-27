package com.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * {@link HandlerInterceptor} that logs incoming request headers on debug level.
 */
@Component
public class HeaderLoggingRequestInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(HeaderLoggingRequestInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        var wrapper = new ContentCachingRequestWrapper(request);
        wrapper.getParameterMap();

        var headerNames = wrapper.getHeaderNames();
        if (headerNames != null) {
            LOGGER.info("Incoming headers for request {}:", request.getServletPath());

            headerNames.asIterator()
                    .forEachRemaining(
                            s -> LOGGER.info("Header name: {}; Header value: {}", s, wrapper.getHeader(s)));
        }

        return true;
    }
}