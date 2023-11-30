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
 * 三.线程控制常见方法
 *  · public void start():导致此线程开始执行,Java虚拟机调用此线程的run()方法
 *  · public static void sleep(long millis):线程睡眠,使当前正在执行的线程以指定的毫秒数暂停(暂时停止执行)
 *  · public static void yield():线程礼让,yield只是让当前线程暂时失去执行权,让系统的线程调度器重新调度一次,希望优先级与当前线程相同
 *  或更高的其他线程能够获得执行机会,但是这个不能保证,完全有可能的情况是,当某个线程调用了yield方法暂停之后,线程调度器又将其调度出来重新执行
 *  · void join():加入线程,当前线程中加入一个新线程,等待加入的线程终止后再继续执行当前线程
 *    void join(long millis):等待该线程终止的时间最长为millis毫秒,如果millis时间到,将不再等待
 *    void join(long millis, int nanos):等待该线程终止的时间最长为millis毫秒+nanos纳秒
 *  · public final void stop():强迫线程终止执行,该方法具有不安全性,已被弃用,最好不要使用
 *      ① 调用stop()方法会立刻终止run()方法中剩余的全部工作,包括在catch或finally语句中的,并抛出ThreadDeach异常(通常情况下此异常不需要显示的捕获),
 *      因此会导致一些清理性的工作得不到完成,如文件,数据库的关闭等
 *      ② 调用stop() 方法会立即释放该线程所持有的所有的锁,导致数据得不到同步,出现数据不一致的问题
 *  · public void interrupt():中断线程,实际上是给线程打上一个中断的标记,并不会真正使线程停止执行
 *  · public boolean isInterrupted():检查线程是否中断,实际上检查线程是否有中断标记,如果有自己编写代码使此线程停止
 *  · public void setDaemon(boolean on):将线程设置为守护线程或用户线程,必须在线程启动之前设置,否则会报IllegalThreadStateException异常
 *      ①守护线程:主要为其他线程服务,当程序中没有非守护线程执行时,守护线程也将终止执行,JVM垃圾回收器也是守护线程
 *  · public boolean isDaemon():检查当前线程是否为守护线程
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
        System.out.println("-----倒计时-------");
        for (int i = 0;i<10;i++){
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("新年快乐!");



    }
}
