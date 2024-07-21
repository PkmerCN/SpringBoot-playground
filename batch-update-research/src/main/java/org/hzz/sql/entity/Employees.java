package org.hzz.sql.entity;

import jakarta.annotation.Generated;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employees {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2349292+08:00", comments="Source field: employees.employee_id")
    private Integer employeeId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2369405+08:00", comments="Source field: employees.first_name")
    private String firstName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2377823+08:00", comments="Source field: employees.last_name")
    private String lastName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2377823+08:00", comments="Source field: employees.email")
    private String email;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2377823+08:00", comments="Source field: employees.phone_number")
    private String phoneNumber;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2382874+08:00", comments="Source field: employees.hire_date")
    private LocalDate hireDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2382874+08:00", comments="Source field: employees.job_id")
    private String jobId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2382874+08:00", comments="Source field: employees.salary")
    private BigDecimal salary;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2388396+08:00", comments="Source field: employees.commission_pct")
    private BigDecimal commissionPct;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2388396+08:00", comments="Source field: employees.manager_id")
    private Integer managerId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2388396+08:00", comments="Source field: employees.department_id")
    private Integer departmentId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2369405+08:00", comments="Source field: employees.employee_id")
    public Integer getEmployeeId() {
        return employeeId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2369405+08:00", comments="Source field: employees.employee_id")
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2369405+08:00", comments="Source field: employees.first_name")
    public String getFirstName() {
        return firstName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2369405+08:00", comments="Source field: employees.first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2377823+08:00", comments="Source field: employees.last_name")
    public String getLastName() {
        return lastName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2377823+08:00", comments="Source field: employees.last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2377823+08:00", comments="Source field: employees.email")
    public String getEmail() {
        return email;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2377823+08:00", comments="Source field: employees.email")
    public void setEmail(String email) {
        this.email = email;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2377823+08:00", comments="Source field: employees.phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2382874+08:00", comments="Source field: employees.phone_number")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2382874+08:00", comments="Source field: employees.hire_date")
    public LocalDate getHireDate() {
        return hireDate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2382874+08:00", comments="Source field: employees.hire_date")
    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2382874+08:00", comments="Source field: employees.job_id")
    public String getJobId() {
        return jobId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2382874+08:00", comments="Source field: employees.job_id")
    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2382874+08:00", comments="Source field: employees.salary")
    public BigDecimal getSalary() {
        return salary;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2388396+08:00", comments="Source field: employees.salary")
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2388396+08:00", comments="Source field: employees.commission_pct")
    public BigDecimal getCommissionPct() {
        return commissionPct;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2388396+08:00", comments="Source field: employees.commission_pct")
    public void setCommissionPct(BigDecimal commissionPct) {
        this.commissionPct = commissionPct;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2388396+08:00", comments="Source field: employees.manager_id")
    public Integer getManagerId() {
        return managerId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2388396+08:00", comments="Source field: employees.manager_id")
    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2388396+08:00", comments="Source field: employees.department_id")
    public Integer getDepartmentId() {
        return departmentId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-07-22T00:36:28.2388396+08:00", comments="Source field: employees.department_id")
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}