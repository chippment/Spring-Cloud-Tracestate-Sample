package com.sample;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "feign-client", url = "http://localhost:8001")
public interface BClient {

    @PostMapping(path = "/serviceb", produces = "application/json", consumes = "application/json")
    void outgoingRequest();
}
