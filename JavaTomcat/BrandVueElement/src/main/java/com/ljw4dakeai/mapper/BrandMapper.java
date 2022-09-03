package com.ljw4dakeai.mapper;

import org.apache.ibatis.annotations.*;
import com.ljw4dakeai.pojo.Brand;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author ljw4dakeai
 * @description: brand mapper接口
 * @title: BrandMapper
 * @package com.ljw4dakeai.mapper
 * @date 2022/9/1 8:47 上午
 */


public interface BrandMapper {

    /**
     * c查询所有, 分页查询交给分页查询来实现
     * @return 查询到所有的商品集合
     */
    List<Brand> selectAllBrand(Brand brand);

    /**
     * 插入品牌方法
     * @param brand
     * @return 受影响的行
     */
    @Insert("insert into tb_brand values (null, #{brandName} ,#{companyName} ,#{ordered} ,#{description} ,#{status} )")
    Integer addBrand(Brand brand);

    /**
     * 根据IDs删除多个商品
     * @param ints 要删除的id数组
     * @return 受影响的行
     */
    Integer deleteByIds(@Param("ids") int[] ints);
}
