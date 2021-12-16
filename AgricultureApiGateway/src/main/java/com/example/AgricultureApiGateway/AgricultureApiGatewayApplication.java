package com.example.AgricultureApiGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@EnableEurekaClient
public class AgricultureApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgricultureApiGatewayApplication.class, args);
	}
	@GetMapping("/userServiceFallback")
	public String userServiceFallback()
	{
		return "User Service is down at this time";
	}

	@GetMapping("/contactFallback")
	public  String  contactFallback()
	{
		return "Contact Service is down at this time";
	}

}
