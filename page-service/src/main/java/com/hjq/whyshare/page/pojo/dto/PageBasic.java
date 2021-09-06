package com.hjq.whyshare.page.pojo.dto;

import com.hjq.whyshare.commons.pojo.dto.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author hjq
 * @date 2021-07-07 14:22:38
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("page_basic")
public class PageBasic extends SuperEntity {
    private static final long serialVersionUID = 1L;

    private String createdBy;
    private Date createdDate;
    private String updatedBy;
    private Date updatedDate;
    private String isDeleted;
    private Long authorId;
    private String title;
    private String content;
    private Integer agree;
    private Integer collect;
}
