package com.ljw4dakeai.mybatis.pojo;

/**
 * @author ljw4dakeai
 * @description: 员工表
 * @title: Employee
 * @package com.ljw4dakeai.mybatis.com.ljw4dakeai.com.ljw4dakeai.pojo
 * @date 2022/8/19 20:16
 */
public class Employee {
    private Integer empId;
    private String empName;
    private String gender;
    private Integer age;
    private String deptId;
    private Dept dept;

    public Employee(Integer empId, String empName, String gender, Integer age, String deptId, Dept dept) {
        this.empId = empId;
        this.empName = empName;
        this.gender = gender;
        this.age = age;
        this.deptId = deptId;
        this.dept = dept;
    }

    public Employee(Integer empId, String empName, String gender, Integer age) {
        this.empId = empId;
        this.empName = empName;
        this.gender = gender;
        this.age = age;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", deptId='" + deptId + '\'' +
                ", dept=" + dept +
                '}';
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
}
