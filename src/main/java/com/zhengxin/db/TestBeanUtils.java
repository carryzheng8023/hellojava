package com.zhengxin.db;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

/**
 * @author zhengxin
 * @date 2018-06-22 14:52:12
 */
public class TestBeanUtils {


    @Test
    public void test() throws Exception{
        Object o = new Student();
        System.out.println(o);

        BeanUtils.setProperty(o, "stuId", 123);
        System.out.println(o);


    }

}
