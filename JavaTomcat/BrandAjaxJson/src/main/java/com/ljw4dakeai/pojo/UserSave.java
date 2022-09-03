package com.ljw4dakeai.pojo;

/**
 * Created with IntelliJ IDEA.
 *
 * @author ljw4dakeai
 * @description: 是否保存User
 * @title: UserSave
 * @package com.ljw4dakeai.com.ljw4dakeai.pojo
 * @date 2022/8/31 3:42 下午
 */


public class UserSave {
    private String username;
    private String password;
    private String remember;

    public UserSave() {
    }


    public UserSave(String username, String password, String save) {
        this.username = username;
        this.password = password;
        this.remember = save;
    }

    @Override
    public String toString() {
        return "UserSave{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", remember=" + remember +
                '}';
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

    public String isRemember() {
        return remember;
    }

    public void setRemember(String remember) {
        this.remember = remember;
    }
}
