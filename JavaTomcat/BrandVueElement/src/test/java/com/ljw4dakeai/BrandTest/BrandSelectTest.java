package com.ljw4dakeai.BrandTest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljw4dakeai.mapper.BrandMapper;
import com.ljw4dakeai.pojo.Brand;
import com.ljw4dakeai.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author ljw4dakeai
 * @description: 分页查询测试
 * @title: BrandSelectTest
 * @package com.ljw4dakeai.BrandTest
 * @date 2022/9/1 9:21 上午
 */


public class BrandSelectTest {

    @Test
    public void selectAllByPageTest(){
        SqlSession autoCommitSqlSession =  SqlSessionUtil.getAutoCommitSqlSession();
        BrandMapper mapper = autoCommitSqlSession.getMapper(BrandMapper.class);
        PageHelper.startPage(2, 5);
        List<Brand> brands = mapper.selectAllBrand(new Brand());
        PageInfo<Brand> brandPageInfo = new PageInfo<>(brands);
        System.out.println(brandPageInfo);
    }
}
