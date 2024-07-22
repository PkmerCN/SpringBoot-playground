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

    /**
     * CASE语句
     * @param employees
     * @return 更新3条数据，返回的是3
     */
    int updateEmployeeSalariesByWhenCase(@Param("list") List<Employees> employees);

    /**
     * 批处理
     * @return 批量的执行，就算有再多的update语句，mybatis在处理的时候，只返回1
     */
    int updateEmployeeSalariesByForIterator(@Param("list") List<Employees> employees);

    /**
     * insert update
     * @return 更新3条数据，返回的是6
     */
    int updateEmployeeSalariesByInsertUpdate(@Param("list") List<Employees> employees);

    /**
     * replace into
     * @return 更新3条数据，返回的是6
     */
    int replaceEmployees(@Param("list") List<Employees> employees);


}
