package com.zhengxin.pattern.state.example;

/**
 * Created by 136931 on 2016/2/24.
 * 状态模式
 */
public class Client {

    public static void main(String[] args) {

        VoteManager vm = new VoteManager();
        for (int i = 0; i < 11; i++) {
            vm.vote("u1", "A");
        }
//        vm.vote("u1", "A");
//        vm.vote("u2", "A");
    }
}
