package com.atguigu.javase.e_multithreading;

/**
 * 一个厨师一个服务员问题
 * 案例:有家餐馆的取餐口比较小,只能放10份快餐,厨师做完快餐放到取餐口的工作台上,服务员从这个工作台取出快餐给顾客,现在有一个厨师和一个服务员
 */
public class $13_Communicate1 {
    public static void main(String[] args) {
        //2.定义资源类对象
        WorkBench bench = new WorkBench();
        //3.创建和启动厨师线程
        new Thread("厨师"){
            @Override
            public void run() {
                //super.run();
                while(true){
                    bench.put();
                }
            }
        }.start();
        //4.创建和启动服务员线程
        new Thread("服务员"){
            @Override
            public void run() {
                //super.run();
                while(true){
                    bench.take();
                }
            }
        }.start();
    }
}
//1.定义资源类
class WorkBench{
    private static final int MAX_VALUE = 10;
    private int num;

    //厨师放快餐
    public synchronized void put(){
        if(num>=MAX_VALUE){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num++;
        System.out.println(Thread.currentThread().getName()+"制作了一份快餐,现在工作台上有: "+num +"份快餐");
        this.notify();
    }
    //服务员取快餐
    public synchronized void take(){
        if(num <= 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num--;
        System.out.println(Thread.currentThread().getName()+"取走了一份快餐,现在工作台上有: "+num+"份快餐");
        this.notify();
    }

}
