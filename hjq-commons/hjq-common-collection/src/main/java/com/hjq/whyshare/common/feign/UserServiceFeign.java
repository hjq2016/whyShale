package com.hjq.whyshare.common.feign;

import com.hjq.whyshare.common.constant.Constants;
import com.hjq.whyshare.common.pojo.dto.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author hjq
 * @description
 * @date 2021/6/16
 */
@FeignClient(name = Constants.USER_SERVICE)
@Component
public interface UserServiceFeign {

    @GetMapping(value = "accessToken")
    Result getUserByToken(String accessToken);
}
