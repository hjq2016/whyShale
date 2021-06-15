package com.hjq.whyshare.user.service;

import com.hjq.whyshare.user.pojo.query.LoginQuery;

/**
 * @author hjq
 * @description
 * @date 2021/6/15
 */
public interface ILoginService {

    boolean login(LoginQuery.LoginMethodQuery query);
}
