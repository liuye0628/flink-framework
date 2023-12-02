package com.atguigu.javase.e_multithreading;

/**
 * 线程安全:当我们使用多个线程访问同一资源(可以是同一个变量,同一个文件,同一个记录等的时候),如果多个线程中对资源有读和写的操作,就会出现前后数据不一致的问题,这就是线程安全问题
 * 案例:三个窗口售卖共100张火车票
 */
public class $09_ThreadSafe {
    public static void main(String[] args) {
        //①局部变量不能共享
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();
        w1.start();
        w2.start();//结果:卖出30张票
        w3.start();//原因:局部变量是每次调用方法都是独立的,那么每个线程的run()的total是独立的,不是共享数据
        //System.out.println("---------------------------------");
        //②不同对象的实例变量不共享
        TicketSaleThread t1 = new TicketSaleThread();
        TicketSaleThread t2 = new TicketSaleThread();
        TicketSaleThread t3 = new TicketSaleThread();
        t1.start();
        t2.start();//结果:卖出30张票
        t3.start();//问题:不同的实例对象的实例变量是独立的
        //③静态变量是共享的
        TicketThread tt1 = new TicketThread();
        TicketThread tt2 = new TicketThread();
        TicketThread tt3 = new TicketThread();
        /*
        问题:卖出近10张票,但是有重复票或负数票问题 原因:线程安全问题
         */
        tt1.start();
        tt2.start();
        tt3.start();
        //④同一个对象的实例变量共享
        TicketSaleRunnable tr = new TicketSaleRunnable();
        Thread ttr1 = new Thread(tr, "窗口一");
        Thread ttr2 = new Thread(tr, "窗口一");
        Thread ttr3 = new Thread(tr, "窗口一");
        /*
        问题:卖出近10张票,但是有重复票或负数票问题 原因:线程安全问题
         */
        ttr1.start();
        ttr2.start();
        ttr3.start();
    }
}

/**
 * ①局部变量不能共享
 */
class Window extends Thread{
    @Override
    public void run() {
        //super.run();
        int total = 10;
        while (total > 0){
            System.out.println(getName() +"卖出一张票,剩余:" + --total);
        }
    }
}

/**
 * ②不同对象的实例变量不共享
 */
class TicketSaleThread extends Thread{
    private int total = 10;
    @Override
    public void run() {
        //super.run();
        while (total > 0){
            System.out.println(getName() +"卖出一张票,剩余:" + --total);
        }
    }
}

/**
 * ③静态变量是共享的
 */
class TicketThread extends Thread{
    private static int total = 10;
    @Override
    public void run() {
        //super.run();
        while (total > 0){
            try {
                Thread.sleep(10);//加入这个,使得问题暴露的更明显
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() +"卖出一张票,剩余:" + --total);
        }
    }

}

/**
 * ④同一个对象的实例变量共享:多个Thread线程使用同一个Runnable对象
 */
class TicketSaleRunnable implements Runnable{
    private int total = 10;
    @Override
    public void run() {
        while (total > 0){
            try {
                Thread.sleep(10);//加入这个,使得问题暴露的更明显
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +"卖出一张票,剩余:" + --total);
        }
    }
}
