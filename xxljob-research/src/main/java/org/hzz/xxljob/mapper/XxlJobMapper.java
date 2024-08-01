package org.hzz.xxljob.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/8/1
 */
@Mapper
public interface XxlJobMapper {

    @Select("select DATABASE();")
    String select();
}
