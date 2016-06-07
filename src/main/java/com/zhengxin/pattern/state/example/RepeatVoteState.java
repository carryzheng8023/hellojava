package com.zhengxin.pattern.state.example;

/**
 * Created by 136931 on 2016/2/24.
 */
public class RepeatVoteState implements VoteState {
    @Override
    public void vote(String user, String voteItem, VoteManager voteManager) {
        //重复投票，暂时不做处理
        System.out.println("请不要重复投票");
    }
}
