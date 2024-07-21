package org.hzz.sql.mapper.dynamic;

import jakarta.annotation.Generated;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.hzz.sql.entity.Employees;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.hzz.sql.mapper.dynamic.EmployeesDynamicSqlSupport.*;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface EmployeesDynamicMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<Employees>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2644434+08:00", comments="Source Table: employees")
    BasicColumn[] selectList = BasicColumn.columnList(employeeId, firstName, lastName, email, phoneNumber, hireDate, jobId, salary, commissionPct, managerId, departmentId);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2504875+08:00", comments="Source Table: employees")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="EmployeesResult", value = {
        @Result(column="employee_id", property="employeeId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="first_name", property="firstName", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_name", property="lastName", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone_number", property="phoneNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="hire_date", property="hireDate", jdbcType=JdbcType.DATE),
        @Result(column="job_id", property="jobId", jdbcType=JdbcType.VARCHAR),
        @Result(column="salary", property="salary", jdbcType=JdbcType.DECIMAL),
        @Result(column="commission_pct", property="commissionPct", jdbcType=JdbcType.DECIMAL),
        @Result(column="manager_id", property="managerId", jdbcType=JdbcType.INTEGER),
        @Result(column="department_id", property="departmentId", jdbcType=JdbcType.INTEGER)
    })
    List<Employees> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2534967+08:00", comments="Source Table: employees")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("EmployeesResult")
    Optional<Employees> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2534967+08:00", comments="Source Table: employees")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, employees, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2544842+08:00", comments="Source Table: employees")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, employees, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.255495+08:00", comments="Source Table: employees")
    default int deleteByPrimaryKey(Integer employeeId_) {
        return delete(c -> 
            c.where(employeeId, isEqualTo(employeeId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.255495+08:00", comments="Source Table: employees")
    default int insert(Employees row) {
        return MyBatis3Utils.insert(this::insert, row, employees, c ->
            c.map(employeeId).toProperty("employeeId")
            .map(firstName).toProperty("firstName")
            .map(lastName).toProperty("lastName")
            .map(email).toProperty("email")
            .map(phoneNumber).toProperty("phoneNumber")
            .map(hireDate).toProperty("hireDate")
            .map(jobId).toProperty("jobId")
            .map(salary).toProperty("salary")
            .map(commissionPct).toProperty("commissionPct")
            .map(managerId).toProperty("managerId")
            .map(departmentId).toProperty("departmentId")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2593826+08:00", comments="Source Table: employees")
    default int insertMultiple(Collection<Employees> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, employees, c ->
            c.map(employeeId).toProperty("employeeId")
            .map(firstName).toProperty("firstName")
            .map(lastName).toProperty("lastName")
            .map(email).toProperty("email")
            .map(phoneNumber).toProperty("phoneNumber")
            .map(hireDate).toProperty("hireDate")
            .map(jobId).toProperty("jobId")
            .map(salary).toProperty("salary")
            .map(commissionPct).toProperty("commissionPct")
            .map(managerId).toProperty("managerId")
            .map(departmentId).toProperty("departmentId")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2619104+08:00", comments="Source Table: employees")
    default int insertSelective(Employees row) {
        return MyBatis3Utils.insert(this::insert, row, employees, c ->
            c.map(employeeId).toPropertyWhenPresent("employeeId", row::getEmployeeId)
            .map(firstName).toPropertyWhenPresent("firstName", row::getFirstName)
            .map(lastName).toPropertyWhenPresent("lastName", row::getLastName)
            .map(email).toPropertyWhenPresent("email", row::getEmail)
            .map(phoneNumber).toPropertyWhenPresent("phoneNumber", row::getPhoneNumber)
            .map(hireDate).toPropertyWhenPresent("hireDate", row::getHireDate)
            .map(jobId).toPropertyWhenPresent("jobId", row::getJobId)
            .map(salary).toPropertyWhenPresent("salary", row::getSalary)
            .map(commissionPct).toPropertyWhenPresent("commissionPct", row::getCommissionPct)
            .map(managerId).toPropertyWhenPresent("managerId", row::getManagerId)
            .map(departmentId).toPropertyWhenPresent("departmentId", row::getDepartmentId)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2676119+08:00", comments="Source Table: employees")
    default Optional<Employees> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, employees, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2676119+08:00", comments="Source Table: employees")
    default List<Employees> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, employees, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2701763+08:00", comments="Source Table: employees")
    default List<Employees> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, employees, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2701763+08:00", comments="Source Table: employees")
    default Optional<Employees> selectByPrimaryKey(Integer employeeId_) {
        return selectOne(c ->
            c.where(employeeId, isEqualTo(employeeId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2711292+08:00", comments="Source Table: employees")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, employees, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2721432+08:00", comments="Source Table: employees")
    static UpdateDSL<UpdateModel> updateAllColumns(Employees row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(employeeId).equalTo(row::getEmployeeId)
                .set(firstName).equalTo(row::getFirstName)
                .set(lastName).equalTo(row::getLastName)
                .set(email).equalTo(row::getEmail)
                .set(phoneNumber).equalTo(row::getPhoneNumber)
                .set(hireDate).equalTo(row::getHireDate)
                .set(jobId).equalTo(row::getJobId)
                .set(salary).equalTo(row::getSalary)
                .set(commissionPct).equalTo(row::getCommissionPct)
                .set(managerId).equalTo(row::getManagerId)
                .set(departmentId).equalTo(row::getDepartmentId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2731295+08:00", comments="Source Table: employees")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Employees row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(employeeId).equalToWhenPresent(row::getEmployeeId)
                .set(firstName).equalToWhenPresent(row::getFirstName)
                .set(lastName).equalToWhenPresent(row::getLastName)
                .set(email).equalToWhenPresent(row::getEmail)
                .set(phoneNumber).equalToWhenPresent(row::getPhoneNumber)
                .set(hireDate).equalToWhenPresent(row::getHireDate)
                .set(jobId).equalToWhenPresent(row::getJobId)
                .set(salary).equalToWhenPresent(row::getSalary)
                .set(commissionPct).equalToWhenPresent(row::getCommissionPct)
                .set(managerId).equalToWhenPresent(row::getManagerId)
                .set(departmentId).equalToWhenPresent(row::getDepartmentId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2731295+08:00", comments="Source Table: employees")
    default int updateByPrimaryKey(Employees row) {
        return update(c ->
            c.set(firstName).equalTo(row::getFirstName)
            .set(lastName).equalTo(row::getLastName)
            .set(email).equalTo(row::getEmail)
            .set(phoneNumber).equalTo(row::getPhoneNumber)
            .set(hireDate).equalTo(row::getHireDate)
            .set(jobId).equalTo(row::getJobId)
            .set(salary).equalTo(row::getSalary)
            .set(commissionPct).equalTo(row::getCommissionPct)
            .set(managerId).equalTo(row::getManagerId)
            .set(departmentId).equalTo(row::getDepartmentId)
            .where(employeeId, isEqualTo(row::getEmployeeId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2746371+08:00", comments="Source Table: employees")
    default int updateByPrimaryKeySelective(Employees row) {
        return update(c ->
            c.set(firstName).equalToWhenPresent(row::getFirstName)
            .set(lastName).equalToWhenPresent(row::getLastName)
            .set(email).equalToWhenPresent(row::getEmail)
            .set(phoneNumber).equalToWhenPresent(row::getPhoneNumber)
            .set(hireDate).equalToWhenPresent(row::getHireDate)
            .set(jobId).equalToWhenPresent(row::getJobId)
            .set(salary).equalToWhenPresent(row::getSalary)
            .set(commissionPct).equalToWhenPresent(row::getCommissionPct)
            .set(managerId).equalToWhenPresent(row::getManagerId)
            .set(departmentId).equalToWhenPresent(row::getDepartmentId)
            .where(employeeId, isEqualTo(row::getEmployeeId))
        );
    }
}