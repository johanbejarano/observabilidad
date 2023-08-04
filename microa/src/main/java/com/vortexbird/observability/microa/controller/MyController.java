package com.vortexbird.observability.microa.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
@Slf4j
public class MyController {
    
   @GetMapping(path = "/sayhi/{name}") 
   public ResponseEntity<?> sayhi(@PathVariable("name") String name) throws Exception {
                
		log.debug("MyController sayHi executed.");
		return ResponseEntity.ok().body("Hi " + name);
        
	}

    @GetMapping(path = "/error") 
    public ResponseEntity<?> error(@PathVariable("name") String name) throws Exception {
                
		log.debug("MyController error executed.");
		
        log.error("An error has ocurred...");

        return ResponseEntity.badRequest().body("My Error");
        
	}

}
