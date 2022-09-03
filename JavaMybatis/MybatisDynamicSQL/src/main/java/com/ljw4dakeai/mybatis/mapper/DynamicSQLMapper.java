package com.ljw4dakeai.mybatis.mapper;

import com.ljw4dakeai.mybatis.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ljw4dakeai
 * @description: 动态SQL接口文件
 * @title: DynamicSQLMapper
 * @package com.ljw4dakeai.mybatis.com.ljw4dakeai.com.ljw4dakeai.mapper
 * @date 2022/8/22 21:48
 */
public interface DynamicSQLMapper {
    /**
     * 根据员工信息查询员工
     * @param empName 员工姓名
     * @param gender 员工性别
     * @param age 员工年龄
     * @return 查询的员工列表
     */
    List<Employee> getEmpByCondition(
            @Param("empName") String empName,
            @Param("gender") String gender,
            @Param("age") Integer age
    );



//    根据员工信息查询员工将参数封装为对象
//    List<Employee> getEmpByCondition(Employee employee);

}
