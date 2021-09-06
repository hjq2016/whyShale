package com.hjq.whyshare.page.pojo.query;

import lombok.Data;

/**
 * @Description
 * @Author hjq
 * @Date 2021/7/8
 */
public class PageQuery {
    @Data
    public static class CreatePageQuery {
        private String title;
        private String content;
    }
    @Data
    public static class GetPagesQuery {
        private String title;
        private String content;
        private Long pageSize;
        private Long pageNo;
    }
    @Data
    public static class SetPageAgreeQuery {
        private long pageId;
        //1-赞同 2-反对 3-重置
        private int operator;
        private int increment;
    }
}
