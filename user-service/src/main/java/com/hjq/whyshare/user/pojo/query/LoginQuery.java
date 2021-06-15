package com.hjq.whyshare.user.pojo.query;

import lombok.Data;

/**
 * @author hjq
 * @description
 * @date 2021/6/15
 */
public class LoginQuery {

    @Data
    public static class LoginMethodQuery {
        private String username;
        private String password;

    }
}
