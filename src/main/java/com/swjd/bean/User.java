package com.swjd.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "user")
public class User {
    @TableId(value = "uid",type = IdType.AUTO)
    private int uid;
    @TableField(value = "uname")
    private String uName;
    @TableField(value = "realname")
    private String realName;
    @TableField(value = "password")
    private String password;
    @TableField(value = "flag")
    private String flag;

    public User() {
    }

    public User(String uName, String realName, String password, String flag) {
        this.uName = uName;
        this.realName = realName;
        this.password = password;
        this.flag = flag;
    }

    public User(int uid, String uName, String realName, String password, String flag) {
        this.uid = uid;
        this.uName = uName;
        this.realName = realName;
        this.password = password;
        this.flag = flag;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uName='" + uName + '\'' +
                ", realName='" + realName + '\'' +
                ", password='" + password + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}
