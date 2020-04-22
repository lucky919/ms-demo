package com.learn.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MsDiscoveryEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsDiscoveryEurekaApplication.class, args);
	}

}
