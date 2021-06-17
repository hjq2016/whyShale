package com.hjq.whyshare.ask.pojo.vo;

import lombok.Data;

/**
 * @author hjq
 * @description
 * @date 2021/6/17
 */
public class QuestionVo {

    @Data
    public static class CreateQuestionVo {
        private String title;
        private String content;
    }
}
