package bean;

import java.io.Serializable;

/**
 * @author kerwin
 * @title: User
 * @projectName ServletDemo
 * @date 2019/09/30 - 9:59
 */
public class User implements Serializable {
    /**
     id
     */
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsername() {
        return username;
    }

    public void setUsername(int username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username=" + username +
                ", password='" + password + '\'' +
                '}';
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(int id, int username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    /**
     用户名
     */
    private int username;
    /**
     密码
     */
    private String password;


}
