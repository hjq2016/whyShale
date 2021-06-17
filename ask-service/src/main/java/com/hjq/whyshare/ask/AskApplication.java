package com.hjq.whyshare.ask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = "com.hjq.whyshare")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.hjq.whyshare")
public class AskApplication {

	public static void main(String[] args) {
		SpringApplication.run(AskApplication.class, args);
	}

}
