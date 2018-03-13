package com.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@ImportResource({"classpath:META-INF/applicationContext.xml"})
public class FeignConsumerApplication {

    //zipkin跟踪策略，全部跟踪 -- 412
    @Bean
    public AlwaysSampler defaultSampler(){
        return new AlwaysSampler();
    }

	public static void main(String[] args) {
		SpringApplication.run(FeignConsumerApplication.class, args);
	}
}
