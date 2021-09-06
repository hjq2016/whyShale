package com.hjq.whyshare.ask.pojo.query;

import lombok.Data;

/**
 * @author hjq
 * @description
 * @date 2021/6/17
 */
public class QuestionQuery {
    @Data
    public static class CreateQuestionQuery {
        private String title;
        private String content;
    }
}
