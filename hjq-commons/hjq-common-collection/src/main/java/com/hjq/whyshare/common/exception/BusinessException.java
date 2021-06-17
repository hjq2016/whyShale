package com.hjq.whyshare.common.exception;

import com.hjq.whyshare.common.enums.AliErrorCodeEnum;

import java.lang.reflect.Type;

/**
 * 业务异常
 *
 * @author zlt
 */
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 6610083281801529147L;

    public static final String ERROR_MESSAGE_FORMAT = "errCode: %s, errMsg: %s ";

    private static final String MSG_FOR_SPECIFIED_CLASS = "whyshare serialize or deserialize class [%s] failed. ";

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(AliErrorCodeEnum message) {
        super(String.format(ERROR_MESSAGE_FORMAT, message.getCode(), message.getDescription()));
    }

    public BusinessException(Throwable throwable) {
        super(throwable);
    }

    public BusinessException(Class<?> serializedClass, Throwable throwable) {
        super(String.format(MSG_FOR_SPECIFIED_CLASS, serializedClass.getName()), throwable);
    }

    public BusinessException(Type targetType, Throwable throwable) {
        super(String.format(MSG_FOR_SPECIFIED_CLASS, targetType.toString()), throwable);
    }
}
