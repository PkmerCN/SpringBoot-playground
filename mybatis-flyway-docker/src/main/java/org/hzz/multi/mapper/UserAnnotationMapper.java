package org.hzz.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.hzz.domain.User;

/**
 * 注解方式获取
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/2
 */
@Mapper
public interface UserAnnotationMapper {
    @Select("SELECT * from user where cell_phone = #{phone}")
    User getUserByCellPhone(@Param("phone") String phone);
}
