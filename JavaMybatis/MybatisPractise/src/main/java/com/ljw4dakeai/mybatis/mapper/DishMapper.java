package com.ljw4dakeai.mybatis.mapper;

import com.ljw4dakeai.mybatis.pojo.Dish;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ljw4dakeai
 * @description: 菜品接口
 * @title: DishMapper
 * @package com.ljw4dakeai.mybatis.mapper
 * @date 2022/8/23 20:07
 */
public interface DishMapper {

    /**
     * 查询所有菜品
     * @return 所有菜品的列表
     */
    List<Dish> selectAll();

    /**
     * 根据ID查询菜品
     * @param id 查询的id
     * @return 查询到的ID
     */
    Dish selectByDishId(@Param("id") Integer id);

    /**
     * 根据ID查询更新
     * @param  id 更新的dishID
     * @param dish 更新的Dish
     * @return 受影响的行数
     */
    Integer updateByDishId(@Param("id") Integer id, @Param("dish") Dish dish);

    /**
     * 根据ID删除
     * @param id 要删除的ID
     * @return 受影响的行数
     */
    Integer deleteByDishId(@Param("id") Integer id);

    /**
     * 根据ID添加
     * @param dish 添加的信息
     * @return 受影响的行数
     */
    Integer insertByDishId(@Param("id") Integer id, @Param("dish") Dish dish);


    /**
     * 动态SQl查询菜品
     * @param code 菜品码
     * @param name 菜品名
     * @return 查询到的菜
     */
    List<Dish> selectByCondition(@Param("code") Integer code, @Param("name") String  name);

    /**
     * 根据ID批量删除
     * @param ids 删除的ID
     * @return 受影响的行
     */
    Integer deleteByDishIds(Integer... ids);


}
