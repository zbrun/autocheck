package com.itaz.pojo;

public class User {
    private String name;
    private String pwd;
    private int dotimes;
    private int isvip;

    public User(String name, String pwd, int dotimes, int isvip) {
        this.name = name;
        this.pwd = pwd;
        this.dotimes = dotimes;
        this.isvip = isvip;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getDotimes() {
        return dotimes;
    }

    public void setDotimes(int dotimes) {
        this.dotimes = dotimes;
    }

    public int getIsvip() {
        return isvip;
    }

    public void setIsvip(int isvip) {
        this.isvip = isvip;
    }
}
