package com.customer.user.request;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
//@EnableEurekaClient


public class CustomerUserRequestsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerUserRequestsApplication.class, args);
	}

}
