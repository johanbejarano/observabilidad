package com.vortexbird.observability.microc.controller;

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

	@GetMapping(path = "/chain/{name}")
	public ResponseEntity<?> chain(@PathVariable("name") String name) throws Exception {

		log.debug("MyController chain executed.");

		if (name.length()>10){
			throw new Exception("Too long");
		}

		return ResponseEntity.ok().body("Hi " + name);

	}

}
