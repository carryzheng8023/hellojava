package com.zhengxin.pattern.command.example;

/**
 * Created by 136931 on 2016/2/25.
 */
public class PlayCommand implements Command {

    private AudioPlayer audioPlayer;

    public PlayCommand(AudioPlayer audioPlayer){
        this.audioPlayer = audioPlayer;
    }
    /**
     * 执行方法
     */
    @Override
    public void execute() {
        this.audioPlayer.play();
    }
}
