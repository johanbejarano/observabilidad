package com.vortexbird.observability.microb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicrobApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicrobApplication.class, args);
	}

}
