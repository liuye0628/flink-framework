package com.atguigu.javase.h_java8newfeature;
/*
冗余的匿名内部类
 */
public class $01_Runnable {
    public static void main(String[] args) {
        //匿名内部类
        Runnable task = new Runnable() {
            @Override
            public void run() {//覆盖重写抽象方法
                System.out.println("多线程任务执行");

            }
        };
        new Thread(task).start();
    }
}
