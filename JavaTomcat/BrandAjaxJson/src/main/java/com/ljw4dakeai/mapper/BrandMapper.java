package com.ljw4dakeai.mapper;

import com.ljw4dakeai.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author ljw4dakeai
 * @description: BrandMapper接口
 * @title: BrandMapper
 * @package com.ljw4dakeai.com.ljw4dakeai.mapper
 * @date 2022/8/29 6:01 下午
 */
public interface BrandMapper {

    /**
     * 插叙所有
     * @return 查询的商品集合
     */
    @Select("select * from servlet_mybatis.tb_brand;")
    List<Brand> selectAllBrand();

    /**
     * 根据ID查询
     * @param id 要查询商品的id
     * @return 查询到的商品 查询不到返回null
     */
    @Select("select * from servlet_mybatis.tb_brand;")
    Brand selectBrandById(@Param("id") Integer id);

    /**
     * 插入商品
     * @param brand 插入商品的详细信息
     * @return 受影响的行数
     */
    @Insert("insert into servlet_mybatis.tb_brand values (null, #{brandName} ,#{companyName} ,#{ordered} ,#{description} ,#{status} )")
    Integer insertBrand(Brand brand);

    /**
     * 更新商品
     * @param brand 需要更新商品的详细信息
     * @return 受影响的行数
     */
    @Update("update servlet_mybatis.tb_brand " +
                "set brand_name = #{brandName} ," +
                "company_name = #{companyName} , " +
                "ordered = #{ordered} , " +
                "description = #{description}, " +
                "status = #{status}  " +
                "where id = #{id} ")
    Integer updateByBrandId(Brand brand);


    /**
     * 根据ID删除
     * @param id 要删除的id
     * @return 受影响的行数
     */
    @Delete("delete from servlet_mybatis.tb_brand where id = #{id};")
    Integer deleteBrandById(@Param("id") Integer id);

}
