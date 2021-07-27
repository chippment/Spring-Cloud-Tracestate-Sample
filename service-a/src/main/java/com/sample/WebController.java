package com.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    private final BClient feignClient;

    @Autowired
    public WebController(BClient feignClient) {
        this.feignClient = feignClient;
    }

    @PostMapping(value = "/notify", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void notifyAllocation() {
        feignClient.outgoingRequest();
    }
}
