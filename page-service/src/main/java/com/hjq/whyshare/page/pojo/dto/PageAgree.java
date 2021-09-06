package com.hjq.whyshare.page.pojo.dto;

import com.hjq.whyshare.commons.pojo.dto.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author hjq
 * @date 2021-07-27 11:42:45
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("page_agree")
public class PageAgree extends SuperEntity {
    private static final long serialVersionUID = 1L;

    private String createdBy;
    private Date createdDate;
    private String updatedBy;
    private Date updatedDate;
    private String isDeleted;
    private Long uid;
    private Long pageId;
    private String agreeStatus;
}
