package com.evan.study.entity;

import java.io.Serializable;

/**
 * @Auther: Administrator
 * @Date: 2018/6/20 22:15
 * @Description:
 */
public class User  implements Serializable {
    private static final long serialVersionUID = -6419163797311508424L;
    private Long id;

    private String userName;

    private String gender;

    private String age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
