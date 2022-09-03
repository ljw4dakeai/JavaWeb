package com.ljw4dakeai.service;

import com.ljw4dakeai.pojo.Book;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author ljw4dakeai
 * @description: 书本业务层
 * @title: BookService
 * @package com.ljw4dakeai.service
 * @date 2022/9/1 8:34 下午
 */
public interface BookService {
    /**
     * 查询所有
     * @return 所有书集合
     */
    List<Book> selectAllBook();

    /**
     * 插入书本
     * @param type 书本类型
     * @param name 书本名
     * @param description 书本描述
     * @return 是否插入成功
     */
    boolean insertBook(String type, String name, String description);

    /**
     * 删除书本
     * @param id 书本编号
     * @return 是否删除成功
     */
    boolean deleteBookById(Integer id);

    /**
     * 修改书本
     * @param id 要修改的id
     * @param type 修改后的类型
     * @param name 修改后的书名
     * @param description 修改后的描述
     * @return 是否修改成功
     */
    boolean updateBookById(Integer id, String type, String name, String description);
}
