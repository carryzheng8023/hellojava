package com.zhengxin;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 136931 on 2016/6/22.
 */
public class JsonBean implements Serializable{

    private String name;
    private LinkedList<String> hobbies;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(LinkedList<String> hobbies) {
        this.hobbies = hobbies;
    }
}
