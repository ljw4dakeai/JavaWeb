package com.ljw4dakeai.service;

import com.ljw4dakeai.mapper.BrandMapper;
import com.ljw4dakeai.pojo.Brand;
import com.ljw4dakeai.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author ljw4dakeai
 * @description: BrandService服务层
 * @title: BrandService
 * @package com.ljw4dakeai.com.ljw4dakeai.service
 * @date 2022/8/27 3:50 下午
 */
public class BrandService {
    /**
     * 服务层 组合业务逻辑 查询所有
     * @return 返回所有Brand
     */
    public List<Brand> SelectAllBrand(){
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        BrandMapper mapper = autoCommitSqlSession.getMapper(BrandMapper.class);
        return mapper.SelectAllBrand();
    }

    public void add(Brand brand) {
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        BrandMapper mapper = autoCommitSqlSession.getMapper(BrandMapper.class);
        Integer integer = mapper.AddBrand(brand);
        System.out.println(integer + "行受影响");
    }

    public Brand selectBrandById(Integer id){
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        BrandMapper mapper = autoCommitSqlSession.getMapper(BrandMapper.class);
        return mapper.selectBrandById(id);
    }

    public Integer updateBrandById(Brand brand) {
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        BrandMapper mapper = autoCommitSqlSession.getMapper(BrandMapper.class);
        return mapper.updateBrandById(brand);
    }

    public Integer deleteBrandById(Integer id) {
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        BrandMapper mapper = autoCommitSqlSession.getMapper(BrandMapper.class);
        return mapper.deleteBrandById(id);
    }
}
