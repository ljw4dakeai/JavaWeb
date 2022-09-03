package com.ljw4dakeai.mybatis.mapper;

import com.ljw4dakeai.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * @author ljw4dakeai
 * @description: Dept表查询
 * @title: DeptMapper
 * @package com.ljw4dakeai.mybatis.com.ljw4dakeai.com.ljw4dakeai.mapper
 * @date 2022/8/20 16:22
 */
public interface DeptMapper {

    /**
     * 根据员工id查询员工信息和部门信息(分步查询)
     * 第二步: 查询员工对应的部门信息
     * @param deptId 要查询的部门id
     * @return (员工信息 + 部门信息)
     */
    Dept selectEmpDeptByStepTwo(@Param("deptId") Integer deptId);

    /**
     * 查询某个部门下的所有员工信息
     * @param deptId 部门ID
     * @return 部门+员工信息
     */
    Dept getDeptEmpByDeptId(@Param("deptId") Integer deptId);

    /**
     * 分布查询部门的所有员工信息
     * @param deptId 部门ID
     * @return 根据部门ID查询到的部门信息
     */
    Dept getDeptEmpByStepOne(@Param("deptId") Integer deptId);
}
