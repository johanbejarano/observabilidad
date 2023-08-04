package com.vortexbird.observability.microa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroaApplication.class, args);
	}

}
