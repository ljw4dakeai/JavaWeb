package com.ljw4dakeai.service.impl;

import com.ljw4dakeai.mapper.BookMapper;
import com.ljw4dakeai.pojo.Book;
import com.ljw4dakeai.service.BookService;
import com.ljw4dakeai.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author ljw4dakeai
 * @description: 实现
 * @title: BookServiceImpl
 * @package com.ljw4dakeai.service.impl
 * @date 2022/9/1 8:34 下午
 */


public class BookServiceImpl implements BookService {
    @Override
    public List<Book> selectAllBook() {
        SqlSession notCommitSqlSession = SqlSessionUtil.getNotCommitSqlSession();
        BookMapper mapper = notCommitSqlSession.getMapper(BookMapper.class);
        return mapper.selectAllBook();
    }

    @Override
    public boolean insertBook(String type, String name, String description) {
        SqlSession autoCommitSqlSession = SqlSessionUtil.getAutoCommitSqlSession();
        BookMapper mapper = autoCommitSqlSession.getMapper(BookMapper.class);
        return mapper.insertBook(type, name, description) != 0;
    }

    @Override
    public boolean deleteBookById(Integer id) {
        SqlSession autoCommitSqlSession = SqlSessionUtil.getAutoCommitSqlSession();
        BookMapper mapper = autoCommitSqlSession.getMapper(BookMapper.class);
        return mapper.deleteBookById(id) != 0;
    }

    @Override
    public boolean updateBookById(Integer id, String type, String name, String description) {
        SqlSession autoCommitSqlSession = SqlSessionUtil.getAutoCommitSqlSession();
        BookMapper mapper = autoCommitSqlSession.getMapper(BookMapper.class);
        return mapper.updateBookById(id, type, name, description) != 0;
    }
}
