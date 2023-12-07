package com.atguigu.javase.e_multithreading;

/**
 * 多个厨师多个服务员问题
 * 案例:有家餐馆的取餐口比较小,只能放10份快餐,厨师做完快餐放到取餐口的工作台上,服务员从这个工作台取出快餐给顾客,现在有多个厨师和多个服务员
 */
public class $13_Communicate2 {
    public static void main(String[] args) {
        //2.定义资源类对象
        WindowBoard windowBoard = new WindowBoard();
        //3.创建和启动厨师线程
        Cook c1 = new Cook("张三", windowBoard);
        Cook c2 = new Cook("李四", windowBoard);
        Waiter w1 = new Waiter("王五", windowBoard);
        Waiter w2 = new Waiter("赵六", windowBoard);
        c1.start();
        c2.start();
        w1.start();
        w2.start();
    }
}
//1.定义资源类
class WindowBoard{
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
        this.notifyAll();
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
        this.notifyAll();
    }

}
//2.定义厨师类
class Cook extends Thread{
    private WindowBoard windowBoard;
    public Cook(String name,WindowBoard windowBoard){
        super(name);
        this.windowBoard = windowBoard;
    }

    @Override
    public void run() {
        //super.run();
        while(true){
            windowBoard.put();
        }
    }
}
//3.定义服务员类
class Waiter extends Thread{
    private WindowBoard windowBoard;
    public Waiter(String name,WindowBoard windowBoard){
        super(name);
        this.windowBoard = windowBoard;
    }

    @Override
    public void run() {
        //super.run();
        while(true){
            windowBoard.take();
        }
    }
}

