package com.zhengxin.concurrency.t18;

/**
 * @author zhengxin
 * @date 2018-02-06 18:37:00
 */
public class Future {

    private Product product;

    private boolean done;

    public synchronized void setProduct(Product product) {

        if(done)
            return;

        this.product = product;
        this.done = true;
        notifyAll();
    }

    public synchronized Product getProduct() {

        while (!done){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return product;
    }


}
