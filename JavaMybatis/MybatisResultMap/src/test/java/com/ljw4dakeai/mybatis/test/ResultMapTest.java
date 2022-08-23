package com.ljw4dakeai.mybatis.test;

import com.ljw4dakeai.mybatis.mapper.DeptMapper;
import com.ljw4dakeai.mybatis.mapper.EmpMapper;
import com.ljw4dakeai.mybatis.pojo.Dept;
import com.ljw4dakeai.mybatis.pojo.Employee;
import com.ljw4dakeai.mybatis.utils.SqlSessionUtils;
import javafx.scene.DepthTest;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


import java.util.List;


/**
 * @author ljw4dakeai
 * @description: ResultMap测试
 * @title: ResultMapTest
 * @package com.ljw4dakeai.mybatis.test
 * @date 2022/8/19 21:34
 */
public class ResultMapTest {
/*    @Test
    public void testComparator() {
        TreeSet<Employee> employees = new TreeSet<>((o1, o2) -> {
                    int order = o1.getAge() - o2.getAge();
                    if (order == 0) {
                        return o1.getEmpName().compareTo(o2.getEmpName());
                    } else {
                        return order;
                    }
                }
        );
        Collections.addAll(
                employees,
                new Employee(1, "A张三", "男", 20, "1", new Dept(1, "A")),
                new Employee(1, "A李四", "男", 20, "1", new Dept(1, "A")),
                new Employee(1, "C王五", "男", 21, "1", new Dept(1, "A")),
                new Employee(1, "B赵六", "男", 19, "1", new Dept(1, "A"))
        );

        employees.forEach(System.out::println);

    }*/
    @Test
    public void testSelectAllEmp() {
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        EmpMapper mapper = autoCommitSqlSession.getMapper(EmpMapper.class);
        List<Employee> employees = mapper.selectAllEmp();
        employees.forEach(System.out::println);
        autoCommitSqlSession.close();
    }

    @Test
    public void testSelectEmpById() {
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        EmpMapper mapper = autoCommitSqlSession.getMapper(EmpMapper.class);
        Employee employee = mapper.selectEmpByEmpId(1);
        System.out.println(employee);
        autoCommitSqlSession.close();
    }


    @Test
    public void testGetEmpDept() {
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        EmpMapper mapper = autoCommitSqlSession.getMapper(EmpMapper.class);
        Employee employee = mapper.selectEmpDeptByEmpId(1);
        System.out.println(employee);
        autoCommitSqlSession.close();
    }

    @Test
    public void testGetEmpDeptByStep(){
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        EmpMapper mapper = autoCommitSqlSession.getMapper(EmpMapper.class);
        Employee employee = mapper.selectEmpDeptByStepOne(1);
        System.out.println(employee);
        autoCommitSqlSession.close();
    }


    @Test
    public void testGetDeptEmpByDeptId(){
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        DeptMapper mapper = autoCommitSqlSession.getMapper(DeptMapper.class);
        Dept deptEmpByDeptId = mapper.getDeptEmpByDeptId(1);
        System.out.println(deptEmpByDeptId);
        autoCommitSqlSession.close();
    }

    @Test
    public void testGetDeptEmpByStep(){
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        DeptMapper mapper = autoCommitSqlSession.getMapper(DeptMapper.class);
        Dept deptEmpByDeptId = mapper.getDeptEmpByStepOne(1);
        System.out.println(deptEmpByDeptId);
        autoCommitSqlSession.close();
    }
}
