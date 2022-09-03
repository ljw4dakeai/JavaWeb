package com.ljw4dakeai.service;

import com.ljw4dakeai.mapper.BrandMapper;
import com.ljw4dakeai.pojo.Brand;
import com.ljw4dakeai.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author ljw4dakeai
 * @description: 商品业务层
 * @title: BrandService
 * @package com.ljw4dakeai.com.ljw4dakeai.service
 * @date 2022/8/29 6:04 下午
 * @info
 *对商品的增删改查的业务成
 */
public class BrandService {
    //添加商品
    public boolean insertBrand(Brand brand){
        SqlSession autoCommitSqlSession = SqlSessionUtil.getAutoCommitSqlSession();
        BrandMapper mapper = autoCommitSqlSession.getMapper(BrandMapper.class);
        Integer insert = mapper.insertBrand(brand);
        return  insert == 1;
    }

    //删除商品
    public boolean deleteBrandById(Integer id){
        SqlSession autoCommitSqlSession = SqlSessionUtil.getAutoCommitSqlSession();
        BrandMapper mapper = autoCommitSqlSession.getMapper(BrandMapper.class);
        Integer delete = mapper.deleteBrandById(id);
        return  delete == 1;
    }

    public boolean updataBrand(Brand brand){
        SqlSession autoCommitSqlSession = SqlSessionUtil.getAutoCommitSqlSession();
        BrandMapper mapper = autoCommitSqlSession.getMapper(BrandMapper.class);
        Integer upData = mapper.updateByBrandId(brand);
        return upData == 1;
    }


    //查询所有商品
    public List<Brand> selectAllBrand(){
        SqlSession autoCommitSqlSession = SqlSessionUtil.getAutoCommitSqlSession();
        BrandMapper mapper = autoCommitSqlSession.getMapper(BrandMapper.class);
        List<Brand> brands= mapper.selectAllBrand();
        return brands;
    }


    public Brand selectBrandById(Integer id){
        SqlSession autoCommitSqlSession = SqlSessionUtil.getAutoCommitSqlSession();
        BrandMapper mapper = autoCommitSqlSession.getMapper(BrandMapper.class);
        Brand brand= mapper.selectBrandById(id);
        return brand;
    }

}
