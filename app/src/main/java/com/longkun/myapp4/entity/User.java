package com.longkun.myapp4.entity;

public class User {

    private String username;

    private String password;

    private String sex;

    private String birthday;

    private String instant;

    public User(String username, String password, String sex, String birthday, String instant) {
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.birthday = birthday;
        this.instant = instant;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getInstant() {
        return instant;
    }

    public void setInstant(String instant) {
        this.instant = instant;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", instant='" + instant + '\'' +
                '}';
    }
}
