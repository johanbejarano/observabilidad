package com.vortexbird.observability.microc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicrocApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicrocApplication.class, args);
	}

}
