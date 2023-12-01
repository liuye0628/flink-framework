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
        Racer rabbit = new Racer("兔子", 100, 10000, 30);
        Racer turtoise = new Racer("乌龟", 1000, 1000, 30);
        rabbit.start();
        turtoise.start();
        //因为要兔子和乌龟都跑完,才能公布结果
        try {
            rabbit.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            turtoise.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("比赛结束");
        if(rabbit.getTotalTime()==turtoise.getTotalTime()){
            System.out.println("平局");
        }else if(rabbit.getTotalTime()< turtoise.getTotalTime()){
            System.out.println("兔子赢");
        }else{
            System.out.println("乌龟赢");
        }


    }
}


class Racer extends Thread{
    private String name;//运动员名字
    private long runTime;//每米需要时间,单位毫秒
    private long restTime;//每10米的休息时间,单位毫秒
    private long distance;//全程距离单位米
    private long totalTime;//跑完全程的总时间

    public Racer(String name,long runTime,long restTime, long distance){
        super();
        this.name=name;
        this.runTime = runTime;
        this.restTime = restTime;
        this.distance = distance;

    }

    public long getTotalTime(){
        return totalTime;
    }



    @Override
    public void run() {
        //super.run();
        long sum = 0;
        long start = System.currentTimeMillis();
        while(sum < distance){
            System.out.println(name + "正在跑");
            try {
                Thread.sleep(runTime);//每米距离,该运动员需要的时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sum ++;
            try {
                if(sum % 10 == 0 && sum < distance){
                    System.out.println(name + "已经跑了"+sum +"米正在休息......");
                    Thread.sleep(restTime);//每10米休息一下
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        totalTime = end - start;
        System.out.println(name + "跑了" + sum +"米,已到达终点,共用时" + totalTime/1000.0+"秒");
    }
}
