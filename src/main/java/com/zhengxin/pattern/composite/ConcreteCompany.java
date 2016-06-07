package com.zhengxin.pattern.composite;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by 136931 on 2016/2/25.
 */
public class ConcreteCompany extends Company {
    private List<Company> cList;

    public ConcreteCompany() {
        cList = new ArrayList<Company>();
    }

    public ConcreteCompany(String name) {
        super(name);
        cList = new ArrayList<Company>() ;
    }

    @Override
    protected void add(Company company) {
        cList.add(company);
    }

    @Override
    protected void display(int depth) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < depth; i++) {
            sb.append("-");
        }
        System.out.println(new String(sb) + this.getName());
        for (Company c : cList) {
            c.display(depth + 2);
        }
    }

    @Override
    protected void remove(Company company) {
        cList.remove(company);
    }
}
