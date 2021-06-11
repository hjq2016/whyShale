package com.hjq.whyshare.ask.pojo.dto;

import com.hjq.whyshare.common.pojo.dto.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import java.util.Date;

/**
 * 
 *
 * @author hjq
 * @date 2021-06-11 17:51:29
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("question_basic")
public class QuestionBasic extends SuperEntity {
    private static final long serialVersionUID=1L;

        private String createdBy;
        private Date createdDate;
        private String updatedBy;
        private Date updatedDate;
        private String isDeleted;
        private Long authorId;
        private String title;
        private String content;
    }
