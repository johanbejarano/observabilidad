package com.vortexbird.observability.microa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vortexbird.observability.microa.feign.ChainClient;

import brave.ScopedSpan;
import brave.Tracer;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
@Slf4j
public class MyController {

  @Autowired
  private ChainClient chainClient;

  @Autowired
  private Tracer tracer;

  @GetMapping(path = "/sayhi/{name}")
  public ResponseEntity<?> sayhi(@PathVariable("name") String name) throws Exception {

    log.debug("MyController sayHi executed.");
    return ResponseEntity.ok().body("Hi " + name);

  }

  @GetMapping(path = "/error")
  public ResponseEntity<?> error() throws Exception {

    log.debug("MyController error executed.");

    log.error("An error has ocurred...");

    return ResponseEntity.badRequest().body("My Error");

  }

  @GetMapping(path = "/chain/{name}")
  public ResponseEntity<?> chain(@PathVariable("name") String name) throws Exception {

    ScopedSpan span = tracer
        .startScopedSpan("[microA]-chain")
        .tag("name", name);

    try {

      log.debug("MyController chain executed.");

      span.annotate("Inicia consumo");

      String chain = chainClient.chain(name);

      span.annotate("Finaliza el consumo");

      return ResponseEntity.ok().body(chain);

    } catch (Exception e) {
      span.error(e);

      return ResponseEntity.badRequest().body(e.getMessage());

    } finally {
      span.finish();
    }

  }

}
