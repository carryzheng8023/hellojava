package com.zhengxin.thread;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

/**
 * Created by zhengxin on 18/1/23.
 */
class DaemonThread implements Runnable{

    @Override
    public void run() {

        System.out.println("进入守护线程" + Thread.currentThread().getName());

        try {
            writeFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("退出守护线程" + Thread.currentThread().getName());

    }

    private void writeFile() throws Exception{
        String baseDir = "/Users/zhengxin/Documents/GitProject/helloworld/src/main/java/com/zhengxin/thread";

        File file = new File(baseDir + "/daemon.txt");

        OutputStream os = new FileOutputStream(file, true);

        int count = 0;

        while (count < 999){
            os.write(("\r\nword" + count).getBytes());
            System.out.println("守护线程" + Thread.currentThread().getName() + "向文件中写入了word" + count++);
            Thread.sleep(1000);
        }

        os.close();


    }
}


public class DaemonThreadDemo {
    public static void main(String[] a){
        System.out.println("进入主线程" + Thread.currentThread().getName());

        DaemonThread daemonThread = new DaemonThread();
        Thread thread = new Thread(daemonThread);
        thread.setDaemon(true);
        thread.start();

        Scanner sc = new Scanner(System.in);
        sc.next();

        System.out.println("退出主线程" + Thread.currentThread().getName());
    }
}
