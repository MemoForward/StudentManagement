package com.memoforward.domain;

import java.util.Date;

public class Student {
    private String sid; //学生id
    private String snum; //学生学号
    private String sname; //学生姓名
    private int sage; //学生年龄
    private String sgender; //学生性别
    private Date birthday; //学生生日

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSnum() {
        return snum;
    }

    public void setSnum(String snum) {
        this.snum = snum;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public String getSgender() {
        return sgender;
    }

    public void setSgender(String sgender) {
        this.sgender = sgender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", snum='" + snum + '\'' +
                ", sname='" + sname + '\'' +
                ", sage=" + sage +
                ", sgender='" + sgender + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
