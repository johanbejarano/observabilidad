package com.vortexbird.observability.microa.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:9534/api/v1", value = "chain-service")
public interface ChainClient {
    
    @GetMapping(path = "/chain/{name}") 
    public String chain(@PathVariable("name") String name);

}
