package com.zhengxin.pattern.command.example;

/**
 * Created by 136931 on 2016/2/25.
 */
public class StopCommand implements Command {

    private AudioPlayer audioPlayer;

    public StopCommand(AudioPlayer audioPlayer){
        this.audioPlayer = audioPlayer;
    }
    @Override
    public void execute() {
        this.audioPlayer.stop();
    }
}
