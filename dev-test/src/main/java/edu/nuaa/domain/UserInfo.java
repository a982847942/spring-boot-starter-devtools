package edu.nuaa.domain;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/19 10:38
 */
public class UserInfo {
    private String code;
    private String name;
    private Integer userId;
    private String info;
    private String address;

    public UserInfo() {
    }

    public UserInfo(String name, Integer userId, String address) {
        this.name = name;
        this.userId = userId;
        this.address = address;
    }

    public UserInfo(String code, String name, Integer userId, String info, String address) {
        this.code = code;
        this.name = name;
        this.userId = userId;
        this.info = info;
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
