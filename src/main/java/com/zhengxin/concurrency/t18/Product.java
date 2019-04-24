package com.zhengxin.concurrency.t18;

/**
 * @author zhengxin
 * @date 2018-02-06 18:34:47
 */
public class Product {

    private int id;
    private String name;

    public Product(int id, String name) {

        try {
            System.out.println("开始生产 " + name);
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.id = id;
        this.name = name;

        System.out.println(name + " 生产完毕");
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
