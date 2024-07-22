package org.hzz.sql.command;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hzz.sql.entity.Employees;
import org.hzz.sql.mapper.EmployeesMapper;
import org.hzz.sql.mapper.dynamic.EmployeesDynamicMapper;
import org.hzz.sql.utils.TimeUtil;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.hzz.sql.mapper.dynamic.EmployeesDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.select;

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
//        basicTest();
        testPerformance();
    }


    /**
     * 基础测试
     */
    public void basicTest() {
        int i = employeesMapper.count();
        log.info("一共查询到{}条数据", i);

        testDynamicSQl();
        updateEmployeeSalariesByWhenCase();
        updateEmployeeSalariesByForIterator();
        updateEmployeeSalariesByInsertUpdate();
        updateEmployeeSalariesByReplaceInto();
        testDynamicSQl();
    }

    public void testPerformance(){
        // 测试100
        System.out.println("========测试100========");
        doTest(100);
        System.out.println("========测试500========");
        doTest(500);
        System.out.println("========测试1000========");
        doTest(1000);
        System.out.println("========测试5000========");
        doTest(5000);
        System.out.println("========测试10000========");
        doTest(10000);
    }


    public void doTest(Integer count){
        System.out.println("测试 case when");
        TimeUtil.testTime(count, this::updateEmployeeSalariesByWhenCase);
        System.out.println("测试 for 循环");
        TimeUtil.testTime(count, this::updateEmployeeSalariesByForIterator);
        System.out.println("测试 insert update");
        TimeUtil.testTime(count, this::updateEmployeeSalariesByInsertUpdate);
    }


    /**
     * 测试CASE语句
     */
    public void updateEmployeeSalariesByWhenCase() {
        Employees employees1 = new Employees();
        employees1.setEmployeeId(1);
        employees1.setSalary(BigDecimal.valueOf(1122.00));
        Employees employees2 = new Employees();
        employees2.setEmployeeId(2);
        employees2.setSalary(BigDecimal.valueOf(2233.01));
        Employees employees3 = new Employees();
        employees3.setEmployeeId(3);
        employees3.setSalary(BigDecimal.valueOf(3333.31));

        int i = employeesMapper.updateEmployeeSalariesByWhenCase(List.of(employees1, employees2, employees3));
//        log.info("case语句更新{}条数据", i);

    }

    /**
     * 批量更新
     */
    public void updateEmployeeSalariesByForIterator() {
        Employees employees1 = new Employees();
        employees1.setEmployeeId(1);
        employees1.setSalary(BigDecimal.valueOf(2244.00));
        Employees employees2 = new Employees();
        employees2.setEmployeeId(2);
        employees2.setSalary(BigDecimal.valueOf(4466.01));
        Employees employees3 = new Employees();
        employees3.setEmployeeId(3);
        employees3.setSalary(BigDecimal.valueOf(6666.31));
        int i = employeesMapper.updateEmployeeSalariesByForIterator(List.of(employees1, employees2, employees3));
//        log.info("for批量更新{}条数据", i);
    }


    /**
     * insert update
     */
    public void updateEmployeeSalariesByInsertUpdate() {
        Employees employees1 = new Employees();
        employees1.setEmployeeId(1);
        employees1.setSalary(BigDecimal.valueOf(4488.00));
        Employees employees2 = new Employees();
        employees2.setEmployeeId(2);
        employees2.setSalary(BigDecimal.valueOf(8822.01));
        Employees employees3 = new Employees();
        employees3.setEmployeeId(3);
        employees3.setSalary(BigDecimal.valueOf(2222.31));
        int i = employeesMapper.updateEmployeeSalariesByInsertUpdate(List.of(employees1, employees2, employees3));
//        log.info("insert update 成功更新{}条数据", i);
    }


    /**
     * replace into
     */
    public void updateEmployeeSalariesByReplaceInto() {
        Employees employees1 = new Employees();
        employees1.setEmployeeId(1);
        employees1.setSalary(BigDecimal.valueOf(4489.00));
        Employees employees2 = new Employees();
        employees2.setEmployeeId(2);
        employees2.setSalary(BigDecimal.valueOf(8823.01));
        Employees employees3 = new Employees();
        employees3.setEmployeeId(3);
        employees3.setSalary(BigDecimal.valueOf(2223.31));
        int i = employeesMapper.replaceEmployees(List.of(employees1, employees2, employees3));
        log.info("replace into 成功更新{}条数据", i);
    }

    /**
     * 打印数据
     */
    public void testDynamicSQl() {
        String name = employeeId.name();
        System.out.println(name);

        SelectStatementProvider selectStatement = select(employeeId, firstName, salary)
                .from(employees)
                .build()
                .render(RenderingStrategies.MYBATIS3);
        // 能够将sql语句字符串化
        // select employee_id, first_name, salary from employees
        System.out.println(selectStatement.getSelectStatement());

        List<Employees> employeesList = employeesDynamicMapper.selectMany(selectStatement);

        for (Employees e : employeesList) {
            System.out.format("%d -> %s \n", e.getEmployeeId(), e.getSalary());
        }
        System.out.println("======================================");
    }


    public void getOptionalValue() {
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
