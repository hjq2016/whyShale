package com.hjq.whyshare.user.service;

import com.hjq.whyshare.user.pojo.query.LoginQuery;
import com.hjq.whyshare.user.pojo.vo.LoginVo;

/**
 * @author hjq
 * @description
 * @date 2021/6/15
 */
public interface ILoginService {

    LoginVo.LoginMethodVo login(LoginQuery.LoginMethodQuery query);
}
