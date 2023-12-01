package com.atguigu.javase.e_multithreading;

/**
 * /**
 *  * Demo3:冠军赛
 *  * 案例:编写龟兔赛跑多线程程序,设赛跑长度为30米
 *  * 兔子的速度为10米每秒,兔子每跑完10米休眠的时间是10秒
 *  * 乌龟的速度是1米每秒,乌龟每跑完10米的休眠时间是1s
 *  * 要求:只要兔子和乌龟中有人到达终点,就宣布比赛结束,没到达终点的也停下来
 *  */

public class $06_ThreadDemo3 {
    public static void main(String[] args) {

    }
}

class Player extends Thread{
    private String name;//运动员名字
    private long runTime;//每米需要时间,单位毫秒
    private long restTime;//每10米的休息时间,单位毫秒
    private long distance;//全程距离单位米
    //private long totalTime;//跑完全程的总时间
    private boolean flag = true;
    private volatile boolean ended = false;

    public Player(String name,long runTime,long restTime, long distance){
        super();
        this.name=name;
        this.runTime = runTime;
        this.restTime = restTime;
        this.distance = distance;

    }

//    public long getTotalTime(){
//        return totalTime;
//    }



    @Override
    public void run() {
        //super.run();
        long sum = 0;
        long start = System.currentTimeMillis();
        while(sum < distance && flag){
            System.out.println(name + "正在跑");
            try {
                Thread.sleep(runTime);//每米距离,该运动员需要的时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sum ++;
            try {
                if(sum % 10 == 0 && sum < distance && flag){
                    System.out.println(name + "已经跑了"+sum +"米正在休息......");
                    Thread.sleep(restTime);//每10米休息一下
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        long end = System.currentTimeMillis();
//        totalTime = end - start;
//        System.out.println(name + "跑了" + sum +"米,已到达终点,共用时" + totalTime/1000.0+"秒");
        ended = sum == distance ? true:false;
        System.out.println(name + "跑了" + sum + "米");



    }
    public void setFlag(boolean flag){
        this.flag = flag;
    }
    public boolean isEnded(){
        return ended;
    }
}
