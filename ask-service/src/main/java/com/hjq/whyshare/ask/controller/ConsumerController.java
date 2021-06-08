package com.hjq.whyshare.ask.controller;

import com.hjq.whyshare.ask.config.NacosPropertiesTest;
import com.hjq.whyshare.ask.feign.HomeService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class ConsumerController {

    @Autowired
    public RestTemplate restTemplate;
    @Autowired
    private NacosPropertiesTest test;
    @Autowired
    private HomeService homeService;

    @RequestMapping("/echo/hjq")
    public String echo() {
        log.info(test.getName());
        return homeService.name();
//        return restTemplate.getForObject("http://home-service/echo", String.class);
    }
}
