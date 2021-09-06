package com.hjq.whyshare.page.mapper;

import com.hjq.whyshare.page.pojo.dto.PageAgree;
import com.hjq.whyshare.commons.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author hjq
 * @date 2021-07-27 11:42:45
 */
@Mapper
public interface PageAgreeMapper extends SuperMapper<PageAgree> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<PageAgree> findList(Page<PageAgree> page, @Param("p") Map<String, Object> params);
}
