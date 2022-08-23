package com.ljw4dakeai.mybatis.test;

import com.ljw4dakeai.mybatis.mapper.DynamicSQLMapper;
import com.ljw4dakeai.mybatis.pojo.Employee;
import com.ljw4dakeai.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author ljw4dakeai
 * @description: 动态SQL测试
 * @title: DynamicSQLTest
 * @package com.ljw4dakeai.mybatis.test
 * @date 2022/8/22 22:02
 */
public class DynamicSQLTest {
    @Test
    public void testDynamicSQLIf(){
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        DynamicSQLMapper mapper = autoCommitSqlSession.getMapper(DynamicSQLMapper.class);
        List<Employee> employees = mapper.getEmpByCondition("张三", null, null);
        employees.forEach(System.out::println);
        autoCommitSqlSession.close();
    }
}
