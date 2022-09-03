package com.ljw4dakeai.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljw4dakeai.mapper.BrandMapper;
import com.ljw4dakeai.pojo.Brand;
import com.ljw4dakeai.service.BrandService;
import com.ljw4dakeai.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author ljw4dakeai
 * @description: BrandService实现类
 * @title: BrandServiceImpl
 * @package com.ljw4dakeai.service.impl
 * @date 2022/9/1 10:16 上午
 */


public class BrandServiceImpl implements BrandService {
    /**
     * 业务层分页查询实现
     * @param currentPage 当前页
     * @param pageSize 页面大小
     * @return 查询到的pageInfo
     */
    @Override
    public PageInfo<Brand> selectBrandByPage(Integer currentPage, Integer pageSize, Brand brand) {
            SqlSession notCommitSqlSession = SqlSessionUtil.getNotCommitSqlSession();
            BrandMapper mapper = notCommitSqlSession.getMapper(BrandMapper.class);
            PageHelper.startPage(currentPage, pageSize);
            List<Brand> brands = mapper.selectAllBrand(brand);
            return new PageInfo<>(brands);
    }

    /**
     * 业务层添加商品实现
     * @param brand 添加的商品信息
     * @return 是否添加成功
     */
    @Override
    public boolean addBrand(Brand brand) {
        SqlSession autoCommitSqlSession = SqlSessionUtil.getAutoCommitSqlSession();
        BrandMapper mapper = autoCommitSqlSession.getMapper(BrandMapper.class);
        return mapper.addBrand(brand) == 1;
    }

    /**
     * 根据id删除多个商品接口
     * @param ints 要删除的id数组
     * @return 是否删除成功
     */
    @Override
    public boolean deleteByIds(int[] ints) {
        SqlSession autoCommitSqlSession = SqlSessionUtil.getAutoCommitSqlSession();
        BrandMapper mapper = autoCommitSqlSession.getMapper(BrandMapper.class);
        return mapper.deleteByIds(ints) != 0;
    }
}
