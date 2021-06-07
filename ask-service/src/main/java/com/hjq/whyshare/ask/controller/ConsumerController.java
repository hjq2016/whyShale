package com.hjq.whyshare.ask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Author hjq
 * @Date 2021/6/7
 */

@RestController
public class ConsumerController {

    @Autowired
    public RestTemplate restTemplate;

    @RequestMapping("/echo/hjq")
    public String echo() {
        return restTemplate.getForObject("http://home-service/echo", String.class);
    }
}
