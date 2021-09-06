package com.hjq.whyshare.commons.util;

import com.hjq.whyshare.commons.constant.Constants;

import java.nio.charset.Charset;

/**
 * @author hjq
 * @description
 * @date 2021/6/16
 */
public class StringUtils {

    public static final String EMPTY = "";

    public static String newStringForUtf8(byte[] bytes) {
        return new String(bytes, Charset.forName(Constants.ENCODE));
    }
}
