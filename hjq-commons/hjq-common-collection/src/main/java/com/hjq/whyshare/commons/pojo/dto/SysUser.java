package com.hjq.whyshare.commons.pojo.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import java.util.Date;

/**
 * 
 *
 * @author hjq
 * @date 2021-06-10 18:24:05
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user")
public class SysUser extends SuperEntity {
    private static final long serialVersionUID=1L;

        private String createdBy;
        private Date createdDate;
        private String updatedBy;
        private Date updatedDate;
        private String isDeleted;
        private String username;
        private String password;
        private String nickname;
        private String phone;
        private String email;
        private String headImgUrl;
        private Integer sex;
    }
