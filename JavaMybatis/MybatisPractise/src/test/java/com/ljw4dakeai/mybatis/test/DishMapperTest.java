package com.ljw4dakeai.mybatis.test;

import com.ljw4dakeai.mybatis.mapper.DishMapper;
import com.ljw4dakeai.mybatis.pojo.Dish;
import com.ljw4dakeai.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author ljw4dakeai
 * @description: DishMapper接口测试
 * @title: DishMapperTest
 * @package com.ljw4dakeai.mybatis.test
 * @date 2022/8/23 20:55
 */
public class DishMapperTest {
    @Test
    public void testDeleteByDishIds(){
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        DishMapper mapper = autoCommitSqlSession.getMapper(DishMapper.class);
        Integer integer = mapper.deleteByDishIds(1, 2, 3);
        System.out.println(integer  + "行受影响!");
        autoCommitSqlSession.close();
    }


    @Test
    public void testSelectByCondition(){
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        DishMapper mapper = autoCommitSqlSession.getMapper(DishMapper.class);
        List<Dish> dishes = mapper.selectByCondition(null, "鸡");
        dishes.forEach(System.out::println);
        autoCommitSqlSession.close();
    }

    @Test
    public void testInsertByDishId(){
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        DishMapper mapper = autoCommitSqlSession.getMapper(DishMapper.class);
        Integer integer = mapper.insertByDishId( 22,new Dish("小鸡炖蘑菇", 49.9, "10086", "嘿嘿嘿", "小鸡炖蘑菇, 嘎嘎好吃", 1));
        System.out.println(integer  + "行受影响!");
        autoCommitSqlSession.close();
    }

    @Test
    public void testUpdateByDishId(){
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        DishMapper mapper = autoCommitSqlSession.getMapper(DishMapper.class);
        Integer integer = mapper.updateByDishId( 26,new Dish("排骨炖土豆", 89.9, "10086", "嘿嘿嘿", "排骨炖的, 嘎嘎好吃", 1));
        System.out.println(integer  + "行受影响!");
        autoCommitSqlSession.close();
    }

    @Test
    public void testSelectAll(){
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        DishMapper mapper = autoCommitSqlSession.getMapper(DishMapper.class);
        List<Dish> dishes = mapper.selectAll();
        dishes.forEach(System.out::println);
        autoCommitSqlSession.close();
    }
}
