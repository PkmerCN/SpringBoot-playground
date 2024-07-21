package org.hzz.sql.mapper.dynamic;

import jakarta.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

import java.math.BigDecimal;
import java.sql.JDBCType;
import java.time.LocalDate;

public final class EmployeesDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.24737+08:00", comments="Source Table: employees")
    public static final Employees employees = new Employees();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2479569+08:00", comments="Source field: employees.employee_id")
    public static final SqlColumn<Integer> employeeId = employees.employeeId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2479569+08:00", comments="Source field: employees.first_name")
    public static final SqlColumn<String> firstName = employees.firstName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2479569+08:00", comments="Source field: employees.last_name")
    public static final SqlColumn<String> lastName = employees.lastName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2479569+08:00", comments="Source field: employees.email")
    public static final SqlColumn<String> email = employees.email;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2479569+08:00", comments="Source field: employees.phone_number")
    public static final SqlColumn<String> phoneNumber = employees.phoneNumber;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2479569+08:00", comments="Source field: employees.hire_date")
    public static final SqlColumn<LocalDate> hireDate = employees.hireDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2479569+08:00", comments="Source field: employees.job_id")
    public static final SqlColumn<String> jobId = employees.jobId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2479569+08:00", comments="Source field: employees.salary")
    public static final SqlColumn<BigDecimal> salary = employees.salary;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2494736+08:00", comments="Source field: employees.commission_pct")
    public static final SqlColumn<BigDecimal> commissionPct = employees.commissionPct;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2495485+08:00", comments="Source field: employees.manager_id")
    public static final SqlColumn<Integer> managerId = employees.managerId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2495485+08:00", comments="Source field: employees.department_id")
    public static final SqlColumn<Integer> departmentId = employees.departmentId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.24737+08:00", comments="Source Table: employees")
    public static final class Employees extends AliasableSqlTable<Employees> {
        public final SqlColumn<Integer> employeeId = column("employee_id", JDBCType.INTEGER);

        public final SqlColumn<String> firstName = column("first_name", JDBCType.VARCHAR);

        public final SqlColumn<String> lastName = column("last_name", JDBCType.VARCHAR);

        public final SqlColumn<String> email = column("email", JDBCType.VARCHAR);

        public final SqlColumn<String> phoneNumber = column("phone_number", JDBCType.VARCHAR);

        public final SqlColumn<LocalDate> hireDate = column("hire_date", JDBCType.DATE);

        public final SqlColumn<String> jobId = column("job_id", JDBCType.VARCHAR);

        public final SqlColumn<BigDecimal> salary = column("salary", JDBCType.DECIMAL);

        public final SqlColumn<BigDecimal> commissionPct = column("commission_pct", JDBCType.DECIMAL);

        public final SqlColumn<Integer> managerId = column("manager_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> departmentId = column("department_id", JDBCType.INTEGER);

        public Employees() {
            super("employees", Employees::new);
        }
    }
}