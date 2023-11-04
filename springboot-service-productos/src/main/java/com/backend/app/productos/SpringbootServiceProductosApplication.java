package com.backend.app.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringbootServiceProductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiceProductosApplication.class, args);
	}

}
