package com.zhengxin.pattern.command.example;

/**
 * Created by 136931 on 2016/2/25.
 */
public class RewindCommand implements Command {
    private AudioPlayer audioPlayer;

    public RewindCommand(AudioPlayer audioPlayer){
        this.audioPlayer = audioPlayer;
    }
    @Override
    public void execute() {
        this.audioPlayer.rewind();
    }
}
