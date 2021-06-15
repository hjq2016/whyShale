package com.hjq.whyshare.common.exception;

import com.hjq.whyshare.common.enums.AliErrorCodeEnum;

/**
 * 业务异常
 *
 * @author zlt
 */
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 6610083281801529147L;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(AliErrorCodeEnum message) {
        super(message.getDescription());
    }
}
