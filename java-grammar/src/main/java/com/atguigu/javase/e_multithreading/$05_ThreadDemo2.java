package com.atguigu.javase.e_multithreading;

/**
 * Demo2:友谊赛
 * 案例:编写龟兔赛跑多线程程序,设赛跑长度为30米
 * 兔子的速度为10米每秒,兔子每跑完10米休眠的时间是10秒
 * 乌龟的速度是1米每秒,乌龟每跑完10米的休眠时间是1s
 * 要求:要等兔子和乌龟的线程结束,主线程(裁判)才能公布最后的结果
 */
public class $05_ThreadDemo2 {
    public static void main(String[] args) {

    }
}


class Racer extends Thread{
    private String name;//运动员名字
    private long runTime;//每米需要时间,单位毫秒
    private long restTime;//每10米的休息时间,单位毫秒
    private long distance;//全程距离单位米
    private long totalTime;//跑完全程的总时间



    @Override
    public void run() {
        super.run();
    }
}
