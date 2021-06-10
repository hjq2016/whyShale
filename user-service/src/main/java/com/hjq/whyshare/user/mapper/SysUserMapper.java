package com.hjq.whyshare.user.mapper;

import com.hjq.whyshare.user.pojo.dto.SysUser;
import com.hjq.whyshare.common.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author hjq
 * @date 2021-06-10 18:24:05
 */
@Mapper
public interface SysUserMapper extends SuperMapper<SysUser> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<SysUser> findList(Page<SysUser> page, @Param("p") Map<String, Object> params);
}
