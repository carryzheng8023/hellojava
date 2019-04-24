package com.zhengxin;

import java.io.Serializable;

/**
 * Created by 136931 on 2016/3/30.
 */
public class B implements Serializable, Cloneable{

    private String school;
    private String address;


    public B(){}

    public B(String school, String address) {
        this.school = school;
        this.address = address;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "B{" +
                "school='" + school + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    protected B clone() throws CloneNotSupportedException {
        return (B)super.clone();
    }


}
