package com.hjq.whyshare.page.enums;

import lombok.val;

/**
 * @Description
 * @Author hjq
 * @Date 2021/7/27
 */
public enum PageAgree {
    NULL(0),
    AGREE(1),
    OPPOSED(2),
    RESET(3),

    ;
    private int v;
    private PageAgree(int v) {
        this.v = v;
    }
}
