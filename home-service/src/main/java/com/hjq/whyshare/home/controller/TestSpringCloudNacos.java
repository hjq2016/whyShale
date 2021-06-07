package com.hjq.whyshare.home.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author hjq
 * @Date 2021/6/7
 */
@RestController
public class TestSpringCloudNacos {
    @RequestMapping(value = "/echo")
    public String doSome() {
        return "hello,hjq";
    }
}
