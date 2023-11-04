package com.backend.app.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class SpringbootServiceStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiceStoreApplication.class, args);
	}

}
