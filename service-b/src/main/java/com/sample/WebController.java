package com.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebController.class);

    @PostMapping(value = "/serviceb", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void preference(@RequestHeader("traceparent") String traceparent, @RequestHeader("tracestate") String tracestate) {
        LOGGER.info("traceparent: {}", traceparent);
        LOGGER.info("tracestate: {}", tracestate);
    }
}
