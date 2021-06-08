package com.hjq.whyshare.ask.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description
 * @Author hjq
 * @Date 2021/6/8
 */
@FeignClient(name = "home-service")
@Component
public interface HomeService {
    @RequestMapping(value = "/echo", method = RequestMethod.GET)
    String name();
}
