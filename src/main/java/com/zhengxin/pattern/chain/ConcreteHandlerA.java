package com.zhengxin.pattern.chain;

/**
 * Created by 136931 on 2016/2/26.
 */
public class ConcreteHandlerA extends Handler {

    /**
     * 处理方法，调用此方法处理请求
     */
    @Override
    public void handleRequest() {
        /**
         * 判断是否有后继的责任对象
         * 如果有，就转发请求给后继的责任对象
         * 如果没有，则处理请求
         */

        /**
         * 说明：判断是否放过的依据：
         * 1.是否自己有能力处理
         *  1.1是：处理
         *  1.2否：是否有后继者
         *    1.2.1是：让后继者处理
         *    1.2.2否：抛异常
         * */

        if(getSuccessor() != null)
        {
            System.out.println("ConcreteHandlerA放过请求");
            getSuccessor().handleRequest();
        }else
        {
            System.out.println("ConcreteHandlerA处理请求");
        }
    }

}
