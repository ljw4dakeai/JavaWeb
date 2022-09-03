package com.ljw4dakeai.mybatis.mapper;

import com.ljw4dakeai.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ljw4dakeai
 * @description: 特殊的SQLMapper
 * @title: SpecialSqlMapper
 * @package com.ljw4dakeai.mybatis.com.ljw4dakeai.com.ljw4dakeai.mapper
 * @date 2022/8/19 17:40
 */
public interface SpecialSqlMapper {

    /**
     * 模糊查询
     * @param likeString 模糊查询的条件
     * @return 模糊查询后返回的结果
     */
    List<User> getUserByLike(@Param("likeString") String likeString);

    /**
     * 通过id批量删除学生
     * @return 是否删除
     */
    int deleteMoreUserById(@Param("ids") String ids);

    /**
     * 动态设置表名
     * @param tableName 表明
     * @return 查询到的数据
     */
    List<User> selectUserByTableName(@Param("tableName") String tableName);

    /**
     * 获取自增主键
     * @param user 插入的用户
     * @return 插入用户的主键
     */
    int insertUserReturnAutoIncrementId(User user);
}
