package com.atguigu.javase.e_multithreading;

/**
 * 守护线程:主要为其他线程服务,当程序中没有非守护线程执行时,守护线程也将终止执行,JVM垃圾回收器也是守护线程
 */
public class $07_DaemonThread {
    public static void main(String[] args) {
        MyDaemon myDaemon = new MyDaemon();
        myDaemon.setDaemon(true);
        myDaemon.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("main:" + i);
        }
    }
}

class MyDaemon extends Thread{
    @Override
    public void run() {
        //super.run();
        while(true){
            System.out.println("我一直在守护着你...");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
