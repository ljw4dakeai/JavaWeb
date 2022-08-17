package com.ljw4dakeai.druid;


import com.ljw4dakeai.pojo.Brand;
import com.ljw4dakeai.utils.DruidConnectUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * @author ZJH
 */
public class Test02TestDruidConnectTest {
    public static void main(String[] args) throws Exception {
        selectAll();
        deleteBrand();
        selectAll();
    }

    /**
     * 添加品牌
     */
    public static void addBrand() throws Exception {
        //模拟要添加的数据
        //1.定义SQL
        String sql = "insert into db5.tb_brand values (NULL, ?, ?, ?, ?,?)";
        //2.预编译SQL
        Connection connection = DruidConnectUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        Scanner scanner = new Scanner(System.in);
        //设置值
        System.out.println("请输入你要添加商品的名称!");
        preparedStatement.setString(1, scanner.nextLine());
        System.out.println("请输入你要添加商品的公司名称!");
        preparedStatement.setString(2, scanner.nextLine());
        System.out.println("请输入你要添加商品的顺序!");
        preparedStatement.setInt(3, Integer.parseInt(scanner.nextLine()));
        System.out.println("请输入你要添加商品的描述!");
        preparedStatement.setString(4, scanner.nextLine());
        System.out.println("请输入你要添加商品的状态!");
        preparedStatement.setInt(5, Integer.parseInt(scanner.nextLine()) );
        //4.执行SQL
        int i = preparedStatement.executeUpdate();
        //5.处理结果
        System.out.println(i);
        //6.释放资源
        preparedStatement.close();
        DruidConnectUtil.breakConnection(connection);
    }

    /**
     * 查询所有品牌信息
     */
    public  static void selectAll() throws Exception {
        //1.定义SQL
        String sql = "select  * from  db5.tb_brand";
        //2.预编译SQL
        Connection connection = DruidConnectUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //4.执行SQL
        ResultSet resultSet = preparedStatement.executeQuery();
        //5.遍历结果集
        ArrayList<Brand> brands = new ArrayList<>();
        while (resultSet.next()) {
            brands.add(new Brand(
                    resultSet.getInt("id"),
                    resultSet.getString("brand_name"),
                    resultSet.getString("company_name"),
                    resultSet.getInt("ordered"),
                    resultSet.getString("description"),
                    resultSet.getInt("status")
            ));
        }

        brands.forEach(System.out::println);
        //6.释放资源
        preparedStatement.close();
        DruidConnectUtil.breakConnection(connection);
    }

    /**
     * 修改品牌
     * Brand{id=4, brandName='娃哈哈', companyName='杭州娃哈哈', ordered=100, description='哈哈哈哈......', status=1}
     */
    public static void updateBrand() throws Exception{
        //1.获取连接
        Connection connection = DruidConnectUtil.getConnection();
        //2.编写sql
        String sql = "update db5.tb_brand set brand_name = ?, company_name = ? , ordered = ? , description = ? , status = ? " +
                "where id = ?";

        //3.预编译sql
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        Scanner scanner = new Scanner(System.in);
        //设置值
        System.out.println("请输入你要修改商品的名称!");
        preparedStatement.setString(1, scanner.nextLine());
        System.out.println("请输入你要修改商品的公司名称!");
        preparedStatement.setString(2, scanner.nextLine());
        System.out.println("请输入你要修改商品的顺序!");
        preparedStatement.setInt(3, Integer.parseInt(scanner.nextLine()));
        System.out.println("请输入你要修改商品的描述!");
        preparedStatement.setString(4, scanner.nextLine());
        System.out.println("请输入你要修改商品的状态!");
        preparedStatement.setInt(5, Integer.parseInt(scanner.nextLine()) );
        System.out.println("请输入你要修改商品的id!");
        preparedStatement.setInt(6, Integer.parseInt(scanner.nextLine()) );

        int i = preparedStatement.executeUpdate();
        System.out.println(i);
        preparedStatement.close();
        DruidConnectUtil.breakConnection(connection);
    }



    public static void deleteBrand() throws Exception{
        //1.获取连接
        Connection connection = DruidConnectUtil.getConnection();
        //2.编写sql
        String sql = "delete from  db5.tb_brand where id = ?";

        //3.预编译sql
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        Scanner scanner = new Scanner(System.in);
        //设置值
        System.out.println("请输入你要删除商品的id!");
        preparedStatement.setInt(1, Integer.parseInt(scanner.nextLine()));

        int i = preparedStatement.executeUpdate();
        System.out.println(i);
        preparedStatement.close();
        DruidConnectUtil.breakConnection(connection);
    }

}
