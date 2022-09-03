package com.ljw4dakeai.mybatis.pojo;

/**
 * @description: 菜品类
 * @title: Dish
 * @package com.ljw4dakeai.mybatis.com.ljw4dakeai.com.ljw4dakeai.pojo
 * @date  2022-08-23 20:00:00
 *@author  ljw4dakeai
 */

public class Dish {
    private Integer id; //菜品id，
    private String name; //菜品名称
    private Double price; //菜品价格
    private String code; //商品码
    private String image; //菜品图片
    private String description; //描述信息
    private Integer status; //状态：0 停售 1 起售

    public Dish() {
    }
    public Dish(Integer id, String name, double price, String code, String image, String description, Integer status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.code = code;
        this.image = image;
        this.description = description;
        this.status = status;
    }
    public Dish(String name, double price, String code, String image, String description, Integer status) {
        this.name = name;
        this.price = price;
        this.code = code;
        this.image = image;
        this.description = description;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", code='" + code + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
