package com.dyhczh.chat_zone.entity;

public class User {
    int userId;
    String account;
    String password;
    String username;
    String email;
    String phone;
    int isNew;

    public User() {
    }

    public User(int userId, String account, String password, String username, String email, String phone, int isNew) {
        this.userId = userId;
        this.account = account;
        this.password = password;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.isNew = isNew;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getIsNew() {
        return isNew;
    }

    public void setIsNew(int isNew) {
        this.isNew = isNew;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", isNew=" + isNew +
                '}';
    }
}
