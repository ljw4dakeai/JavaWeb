package com.ljw4dakeai.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljw4dakeai.mapper.BrandMapper;
import org.apache.ibatis.session.SqlSession;
import com.ljw4dakeai.pojo.Brand;
import com.ljw4dakeai.utils.SqlSessionUtil;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author ljw4dakeai
 * @description: Brand业务层
 * @title: BrandService
 * @package com.ljw4dakeai.service
 * @date 2022/9/1 8:50 上午
 *
 * @info 业务层接口
 */


public interface BrandService {
    /**
     * 业务层分页查询接口
     * @param currentPage 当前页
     * @param pageSize 页面大小
     * @return 查询到的pageInfo
     */
    PageInfo<Brand> selectBrandByPage(Integer currentPage, Integer pageSize, Brand brand);

    /**
     * 业务层添加商品接口
     * @param brand 添加的商品信息
     * @return 是否添加成功
     */
    boolean addBrand(Brand brand);

    /**
     * 根据id删除多个商品接口
     * @param ints 要删除的id数组
     * @return 是否删除成功
     */
    boolean deleteByIds(int[] ints);
}
