package com.ljw4dakeai.mybatis.test;

import com.ljw4dakeai.mybatis.mapper.BrandMapper;
import com.ljw4dakeai.mybatis.pojo.Brand;
import com.ljw4dakeai.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author ljw4dakeai
 * @description: BrandSQL查询测试
 * @title: BrandMapperTest
 * @package com.ljw4dakeai.mybatis.test
 * @date 2022/8/19 15:54
 */
public class BrandMapperTest {

    @Test
    public void testShow(){
        System.out.println("test success");
    }

    @Test
    public void testSelectAll(){
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        BrandMapper mapper = autoCommitSqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();
        brands.forEach(System.out::println);
        autoCommitSqlSession.close();
    }

    @Test
    public void testGetBrandByID(){
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        BrandMapper mapper = autoCommitSqlSession.getMapper(BrandMapper.class);
        Brand brand = mapper.getBrandById(3);
        System.out.println(brand);
        autoCommitSqlSession.close();
    }

    @Test
    public void testGetBrandByCondition(){
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        BrandMapper mapper = autoCommitSqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectByCondition(null, "小米", null);
        brands.forEach(System.out::println);
        autoCommitSqlSession.close();
    }

    @Test
    public void testInsertBrand(){
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        BrandMapper mapper = autoCommitSqlSession.getMapper(BrandMapper.class);
        Brand brand = new Brand(null, "娃哈哈", "杭州娃哈哈有限公司", 1000, "娃哈哈 哈哈哈哈~", 1);
        int result = mapper.insertBrand(brand);
        System.out.println(brand.getId());
        System.out.println(result + "行受到影响!");
        autoCommitSqlSession.close();
    }

    @Test
    public void testUpdateBrandByID(){
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        BrandMapper mapper = autoCommitSqlSession.getMapper(BrandMapper.class);
        int result = mapper.updateBrandById(4, "哈哈哈", "天上哈哈哈无限公司", 10086, "哈~哈~哈~哈~ 哈哈哈~  快乐每一天", 1);
        System.out.println(result + "行受到影响!");
        autoCommitSqlSession.close();
    }

    @Test
    public void TestDeleteByIds(){
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        BrandMapper mapper = autoCommitSqlSession.getMapper(BrandMapper.class);
        int result = mapper.deleteBrandById("1, 2");
        System.out.println(result + "行受到影响!");
        autoCommitSqlSession.close();
    }

}
