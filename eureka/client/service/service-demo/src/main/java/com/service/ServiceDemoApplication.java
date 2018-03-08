package com.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication
public class ServiceDemoApplication {

    //zipkin跟踪策略，全部跟踪 -- 412
    @Bean
    public AlwaysSampler defaultSampler(){
        return new AlwaysSampler();
    }

	public static void main(String[] args) {
		SpringApplication.run(ServiceDemoApplication.class, args);
	}
}
