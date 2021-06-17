package com.hjq.whyshare.common.feign;

import com.hjq.whyshare.common.constant.Constants;
import com.hjq.whyshare.common.pojo.dto.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author hjq
 * @description
 * @date 2021/6/16
 */
@FeignClient(name = Constants.USER_SERVICE, path = "/userService")
@Component
public interface UserServiceFeign {

    @GetMapping(value = "/users/accessToken")
    Result getUserByToken(@RequestParam("accessToken") String accessToken);
}
