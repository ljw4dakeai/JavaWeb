package com.ljw4dakeai.mapper;

import com.ljw4dakeai.pojo.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author ljw4dakeai
 * @description: 书本mapper接口
 * @title: BookMapper
 * @package com.ljw4dakeai.mapper
 * @date 2022/9/1 8:32 下午
 */


public interface BookMapper {
    /**
     * 查询所有
     * @return 返回查询到的书本集合
     */
    @Select("select * from db_exam.tb_book;")
    List<Book> selectAllBook();

    /**
     * 插入方法
     * @param type 书本的类型
     * @param name 书本的名称
     * @param description 书本的描述信息
     * @return   受影响的行
     */
    @Insert("insert into db_exam.tb_book values (null, #{type} , #{name}, #{description})")
    Integer insertBook(@Param("type") String type, @Param("name") String name, @Param("description") String description);

    /**
     * 根据id删除
     * @param id 要删除书本的id
     * @return 受影响的行
     */
    @Delete("delete from db_exam.tb_book where id =#{id} ")
    Integer deleteBookById(Integer id);

    /**
     * 根据id修改
     * @param id 要修改的id
     * @param type 类型
     * @param name 名称
     * @param description 描述
     * @return 搜影响的行
     */
    @Update("update db_exam.tb_book set type = #{type} ,name = #{name} , description= #{description}   where id = #{id} ")
    Integer updateBookById(@Param("id") Integer id, @Param("type") String type, @Param("name") String name, @Param("description") String description);

}
