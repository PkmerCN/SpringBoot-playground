package org.hzz.sql.command;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hzz.sql.entity.Employees;
import org.hzz.sql.mapper.EmployeesMapper;
import org.hzz.sql.mapper.dynamic.EmployeesDynamicMapper;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.select;
import static org.hzz.sql.mapper.dynamic.EmployeesDynamicSqlSupport.*;
/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/22
 */
@Slf4j
@Component
public class TestEmployeeCommandLine implements CommandLineRunner {

    @Setter(onMethod_ = @Autowired)
    private EmployeesMapper employeesMapper;

    @Setter(onMethod_ = @Autowired)
    private EmployeesDynamicMapper employeesDynamicMapper;

    @Override
    public void run(String... args) throws Exception {
        int i = employeesMapper.count();
        log.info("一共查询到{}条数据",i);

        testDynamicSQl();
        updateEmployeeSalariesByWhenCase();
        testDynamicSQl();
    }


    public void updateEmployeeSalariesByWhenCase(){
        Employees employees1 = new Employees();
        employees1.setEmployeeId(1);
        employees1.setSalary(BigDecimal.valueOf(1122.00));
        Employees employees2 = new Employees();
        employees2.setEmployeeId(2);
        employees2.setSalary(BigDecimal.valueOf(2233.01));
        Employees employees3 = new Employees();
        employees3.setEmployeeId(3);
        employees3.setSalary(BigDecimal.valueOf(3333.31));


        employeesMapper.updateEmployeeSalariesByWhenCase(List.of(employees1,employees2,employees3));
    }

    public void testDynamicSQl(){
        String name = employeeId.name();
        System.out.println(name);

        SelectStatementProvider selectStatement = select(employeeId,firstName,salary)
                .from(employees)
                .build()
                .render(RenderingStrategies.MYBATIS3);

        System.out.println(selectStatement.getSelectStatement());

        List<Employees> employeesList = employeesDynamicMapper.selectMany(selectStatement);

        for(Employees e: employeesList){
            System.out.format("%d -> %s \n",e.getEmployeeId(),e.getSalary());
        }
        System.out.println("======================================");
    }


    public void getOptionalValue(){
        Optional<Employees> employeesOptional = employeesDynamicMapper.selectOne(c -> c.where(
                employeeId, isEqualTo(1)
        ));

        employeesOptional.ifPresent(
                e -> {
                    System.out.println(e.getFirstName());
                }
        );
    }
}
