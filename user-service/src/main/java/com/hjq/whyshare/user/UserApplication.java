package com.hjq.whyshare.user;

import com.hjq.whyshare.commons.annotation.EnableRedissonUse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com.hjq.whyshare")
@EnableRedissonUse
@EnableFeignClients(basePackages = "com.hjq.whyshare")
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
}
