package com.ljw4dakeai.mybatis.pojo;

/**
 * @author ljw4dakeai
 * @description: User实体类
 * @title: User
 * @package com.ljw4dakeai.mybatis.com.ljw4dakeai.com.ljw4dakeai.pojo
 * @date 2022/8/24 19:41
 */
public class User {
    private Integer id;
    private String username;
    private String password;


    public User() {
    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
