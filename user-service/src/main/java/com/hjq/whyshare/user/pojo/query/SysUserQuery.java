package com.hjq.whyshare.user.pojo.query;

import lombok.Data;

/**
 * @author hjq
 * @description
 * @date 2021/6/11
 */
public class SysUserQuery {
    @Data
    public static class UpdatePasswordQuery {
        private String username;
        private String password;
        private String oldPassword;
    }
}
