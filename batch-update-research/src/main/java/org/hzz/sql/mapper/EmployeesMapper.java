package org.hzz.sql.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hzz.sql.entity.Employees;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/22
 */
@Mapper
public interface EmployeesMapper {

//    @Select("select count(1) from employees;")
    int count();

    int updateEmployeeSalariesByWhenCase(@Param("list") List<Employees> employees);

}
