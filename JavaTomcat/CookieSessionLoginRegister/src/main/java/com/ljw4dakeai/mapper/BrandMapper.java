package com.ljw4dakeai.mapper;

import com.ljw4dakeai.pojo.Brand;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author ljw4dakeai
 * @description: Brand CURD 基本方法
 * @title: BrandMapper
 * @package com.ljw4dakeai.com.ljw4dakeai.mapper
 * @date 2022/8/27 3:47 下午
 */
public interface BrandMapper {
    /**
     *  查询所有商品信息
     * @return 查询到的所有Brand
     */
    @Select("select * from tb_brand;")
    List<Brand> SelectAllBrand();

    /**
     * 插入方法
     * @param brand 插入的对象
     * @return 返回受影响的行
     */
    @Insert("insert into tb_brand value (null, #{brandName}, #{companyName}, #{ordered} ,#{description} ,#{status} )")
     Integer AddBrand(Brand brand);

    /**
     * 通过ID查询用户信息, 数据回显到页面上
     * @param id 查询用户的id
     * @return 查询到的用户
     */
    @Select("select * from tb_brand where  id=#{id} ;")
    Brand selectBrandById(Integer id);

    /**
     * 通过通过ID修改商品信息
     * @param brand 被修改商品的详细信息
     * @return 受影响该的行数
     */
    @Update("update tb_brand set brand_name = #{brandName} ,company_name = #{companyName} , ordered = #{ordered} , description = #{description} , status = #{status} where id = #{id}")
    Integer updateBrandById(Brand brand);

    @Delete("delete from tb_brand where id =#{id} ")
    Integer deleteBrandById(Integer id);
}
