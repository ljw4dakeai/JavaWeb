package com.ljw4dakeai.mybatis.mapper;

import com.ljw4dakeai.mybatis.pojo.Brand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ljw4dakeai
 * @description: Brand查询接口
 * @title: BrandMapper
 * @package com.ljw4dakeai.mybatis.com.ljw4dakeai.com.ljw4dakeai.mapper
 * @date 2022/8/19 15:36
 */
public interface BrandMapper {

    /**
     * 查询所有商品
     *
     * @return 商品集合
     */
    List<Brand> selectAll();

    /**
     * 根据id查询
     *
     * @param id 查询商品的id
     * @return 查询到的商品
     */
    @Select("select * from tb_brand where id = #{id,jdbcType=INTEGER}")
    @ResultMap("brandResultMap")
    Brand getBrandById(@Param("id") Integer id);

    /**
     * 多条件查询
     *
     * @param status      商品状态
     * @param companyName 公司名称
     * @param brandName   商品名称
     * @return 查询到的商品
     */
    List<Brand> selectByCondition(
            @Param("status") Integer status,
            @Param("companyName") String companyName,
            @Param("brandName") String brandName
    );

    /**
     * 添加方法
     *
     * @param brand 添加商品的队形
     * @return 受影响的行数
     */
    int insertBrand(Brand brand);

    /**
     * 修改商品信息
     *
     * @param id          要修改商品的id
     * @param brandName   修改后的商品名
     * @param companyName 修改后的商品公司名
     * @param ordered     修改后的商品订单数
     * @param desc        修改后商品的描述
     * @param status      修改后商品的状态
     * @return 受影响的行数
     */
    int updateBrandById(
            @Param("id") Integer id,
            @Param("brandName") String brandName,
            @Param("companyName") String companyName,
            @Param("ordered") Integer ordered,
            @Param("desc") String desc,
            @Param("status") Integer status
    );

    /**
     * 批量删除方法
     *
     * @param ids 删除的id 以逗号分割的字符串
     * @return 受影响的行数
     */
    int deleteBrandById(@Param("ids") String ids);
}
