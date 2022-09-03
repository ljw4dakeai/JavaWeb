package com.ljw4dakeai.mybatis.mapper;

import com.ljw4dakeai.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author ljw4dakeai
 * @description: 查询的接口
 * @title: SelectMapper
 * @package com.ljw4dakeai.mybatis.com.ljw4dakeai.com.ljw4dakeai.mapper
 * @date 2022/8/19 11:24
 */
public interface SelectMapper {
    /**
     *  通过id查询用户
     * @param id 需要查询的id
     * @return 返回查询的
     */
    User selectByUserId(@Param("id")  Integer id);

    /**
     *查询所有用户
     * @return 所有用户的集合
     */
    List<User> selectAllUser();


    /**
     * 查询用户数量
     * @return 用户数量
     */
    Integer selectCountUser();

    /**
     * 查询一条数据位map集合
     *通过ID 获取用户数据信息为一个map集合
     * @param id  要查询用户的的id
     * @return  用户的map集合
     */
    Map<String, Object> getUserByIDToMap(@Param("id") Integer id);

    /**
     * 获取所有用户集合为一个List<Map>
     * @return 返回所用用户的List<Map>
     */
    List<Map<String, Object>> getAllUserToMapOne();

    /**
     * MapKey("id") 查询结果的id作为Map的键
     * 获取所有用户集合为一个Map<id, Map>
     * @return 返回所用用户的Map<id, Map>
     * @throws Exception  id没有查询到异常
     */
    @MapKey("id")
    Map<String, Object> getAllUserToMapTwo();

}
