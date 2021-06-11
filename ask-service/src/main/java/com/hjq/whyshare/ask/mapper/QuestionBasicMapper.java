package com.hjq.whyshare.ask.mapper;

import com.hjq.whyshare.ask.pojo.dto.QuestionBasic;
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
 * @date 2021-06-11 17:51:29
 */
@Mapper
public interface QuestionBasicMapper extends SuperMapper<QuestionBasic> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<QuestionBasic> findList(Page<QuestionBasic> page, @Param("p") Map<String, Object> params);
}
