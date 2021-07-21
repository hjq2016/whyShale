package com.hjq.whyshare.page.mapper;

import com.hjq.whyshare.page.pojo.dto.PageBasic;
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
 * @date 2021-07-07 14:22:38
 */
@Mapper
public interface PageBasicMapper extends SuperMapper<PageBasic> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<PageBasic> findList(Page<PageBasic> page, @Param("p") Map<String, Object> params);
}
