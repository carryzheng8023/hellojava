package com.zhengxin.concurrency.t16;

/**
 * 按顺序执行方法
 * @author zhengxin
 * @date 2018-02-02 14:52:10
 */
public class InOrder {

    private int signal = 0;

    public synchronized void a(){

        while (signal != 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("a");
        signal = 1;
        notifyAll();
    }

    public synchronized void b(){
        while (signal != 1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("b");
        signal = 2;
        notifyAll();
    }

    public synchronized void c(){
        while (signal != 2){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("c");
        signal = 0;
        notifyAll();
    }

    public static void main(String[] args){

        InOrder inOrder = new InOrder();

//        A a = new A(inOrder);
//        B b = new B(inOrder);
//        C c = new C(inOrder);
//
//        new Thread(a).start();
//        new Thread(b).start();
//        new Thread(c).start();

    }

}


