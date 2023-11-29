package com.atguigu.javase.e_multithreading;

/**
 * Thread类
 * 一.构造方法:
 *  · public Thread():分配一个新的线程对象
 *  · public Thread(String name):分配一个指定名字的新的线程对象
 *  · public Thread(Runnable target): 分配带有一个指定目标新的线程对象
 *  · public Thread(Runnable target,String name): 分配带有一个指定目标新的线程对象,并指定名字
 * 二.线程使用基础方法
 *  · public void run():此线程要执行的任务在此处定义代码
 *  · public String getName():获取当前线程名称
 *  · public static Thread currentThread():返回对当前正在执行的线程对象的引用
 *  · public final boolean isAlive():测试线程是否属于活动状态,如果线程已经启动且尚未终止,则为活动状态
 *  · public final int getPriority():返回线程优先级
 *  · public final int setPriority(int newPriority):改变线程优先级
 *      ①每个线程都有一定的优先级,优先级高的线程将获得较高的执行机会,每个线程默认的优先级都与创建它的父线程具有相同的优先级,Thread类
 *      提供了setPriority(int newPriority)和getPriority()方法来设置和获取线程的优先级,其中setPriority方法需要一个整数,并且范围在
 *      [1,10]之间,通常推荐设置Thread类的三个优先级常量
 *      ②MAX_PRIORITY(10):最高优先级
 *      ②MIN_PRIORITY(1):最低优先级
 *      ②NORM_PRIORITY(5):普通优先级,默认情况下main线程具有普通优先级
 *
 */
public class $03_Thread {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                //super.run();
                System.out.println(getName() + "的优先级:" + getPriority());
            }
        };
        t.setPriority(Thread.MAX_PRIORITY);
        t.start();
        System.out.println(Thread.currentThread().getName() +"的优先级: "+ Thread.currentThread().getPriority());
    }
}
