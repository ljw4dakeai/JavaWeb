package com.ljw4dakeai.mybatis.mapper;

import com.ljw4dakeai.mybatis.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ljw4dakeai
 * @description: 员工映射接口
 * @title: EmpMapper
 * @package com.ljw4dakeai.mybatis.mapper
 * @date 2022/8/19 21:15
 */
public interface EmpMapper {

    /**
     * 查询所有员工
     * @return 所有员工的集合
     */
    List<Employee> selectAllEmp();

    /**
     * 通过员工id查询员工信息
     * @param empId 查询的员工id
     * @return 查询的员工信息
     */
    Employee selectEmpByEmpId(@Param("empId") Integer empId);

    /**
     * 根据员工id查询员工信息和部门信息
     * @param empId 要查询的员工id
     * @return (员工信息 + 部门信息)
     */
    Employee selectEmpDeptByEmpId(@Param("empId") Integer empId);

    /**
     * 根据员工id查询员工信息和部门信息(分步查询)
     * 第一步: 查询员工信息
     * @param empId 要查询的员工id
     * @return (员工信息 + 部门信息)
     */
    Employee selectEmpDeptByStepOne(@Param("empId") Integer empId);

    /**
     * 分布查询部门下的所有员工第二部
     * @param deptId 部门id
     * @return 该部门下的所有员工
     */
    Employee selectDeptEmpByStepTwo(@Param("deptId") Integer deptId);

}
