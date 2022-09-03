package com.ljw4dakeai.mybatis.pojo;

import java.util.List;

/**
 * @author ljw4dakeai
 * @description: 部门表
 * @title: Dept
 * @package com.ljw4dakeai.mybatis.com.ljw4dakeai.com.ljw4dakeai.pojo
 * @date 2022/8/19 20:16
 */
public class Dept {
    private Integer deptId;
    private String deptName;
    private List<Employee> employees;

    public Dept(Integer deptId, String deptName, List<Employee> employees) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.employees = employees;
    }

    public Dept(Integer deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public Dept() {
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", employees=" + employees +
                '}';
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
