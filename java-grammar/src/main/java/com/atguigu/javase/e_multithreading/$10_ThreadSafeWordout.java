package com.atguigu.javase.e_multithreading;

/**
 * 1.线程安全解决问题
 * 通过上个示例总结线程安全的问题因为具备了以下条件
 *  ①多线程执行
 *  ②共享数据
 *  ③多条语句操作共享数据
 *  线程安全问题的必备条件①和②是我们需要的,要解决只能从第三个点上想办法,要解决上述多线程并发访问一个资源的安全性问题:也就是解决重复票与不存在票
 *  问题,Java提供了线程同步机制来解决
 * 同步,异步的简单理解:同步即一步一步完成操作,第一步未完成不能进行下一步,相当于单线程执行任务,异步即几步操作可以互不干扰的执行,你做你的事,
 * 我做我的事,相当于多线程执行任务,多线程中的同步机制,可以理解为把线程安全问题代码,变成同步执行的代码,或者看成一个不能拆分的整体,一个线程执行完这
 * 整块的代码后,下个线程才能再来执行
 * 2.如何编写多线程的程序呢?
 *  ·原则:
 *      ①线程操作资源类
 *      ②高内聚,低耦合
 *  ·步骤:
 *      ①编写资源类
 *      ②考虑线程安全问题,在资源类中使用同步代码块或同步方法
 */
public class $10_ThreadSafeWordout {
    /**
     * 1.Java中常使用关键字synchronized来实现同步机制
     * 同步方法:synchronized关键字直接修饰方法,表示同一时刻只有一个线程能进入该方法,其他线程在外面等着
     *  public synchronized void method(){
     *      可能会产生线程安全问题的代码
     *  }
     * 同步代码块:synchronized 关键字可以用于某个区块前面,表示只对这个区块的资源实行互斥访问
     *  synchronized(同步锁){
     *      需要同步操作的代码
     *  }
     */

    /**
     * 2.锁对象选择(同步锁对象)
     *  ·锁对象可以是任意类型
     *  ·多个线程对象 要使用同一把锁
     */

    /**
     * 3.锁的范围太小:不能解决安全问题,要同步所有操作共享资源的语句
     *   锁的范围太大:因为一旦某个线程抢到锁,其他线程就只能等待,所以范围太大,效率会降低,不能合理利用CPU资源
     */
    public static void main(String[] args) {
        /*
        ①同步代码块的锁对象
         */
        SaleTicket st = new SaleTicket();//创建线程任务对象
        new Thread(st).start();
        new Thread(st).start();//创建售票线程对象,并启动线程
        /*
        ②同步方法的锁对象
         */
        Ticket ticket = new Ticket();//创建共享资源
        SaleTicket2 st2 = new SaleTicket2(ticket);//创建资源操作线程对象
        new Thread(st2).start();
        new Thread(st2).start();
    }
}
/**
 * ①同步代码块的锁对象(同步锁对象):
 *  ·锁对象可以是任意类型
 *  ·多个线程对象要使用同一把锁
 *  ·习惯上先考虑this,但是要注意是否是同一个this
 */
//售票线程任务类
class SaleTicket implements Runnable{
    //票数
    private int total = 10;//共享资源
    @Override
    //售票线程任务
    public void run() {
        while (true){
            //同步代码块,this为锁对象
            synchronized (this){
//                if(total > 0){
//                    System.out.println(Thread.currentThread().getName() + "--" + total);
//                    total--;
//                }
                sell();//调用售票方法
            }
        }
    }
    //提取出售票方法
    private void sell(){
        if(total > 0){
            System.out.println(Thread.currentThread().getName() + "--" + total);
            total--;
        }
    }


}

/**
 * ②同步方法的锁对象
 *  ·静态方法:当前类的class对象
 *  ·非静态方法:this
 */
//共享资源类(将共享数据与同步方法封装到一个类中)
class Ticket{
    int total = 10;
    //同步方法,非静态同步方法的锁对象默认为this
    public synchronized void sell(){
        if(total > 0){
            System.out.println(Thread.currentThread().getName() + "--" + total);
            total--;
        }
    }
}
//线程任务类
class SaleTicket2 implements Runnable{
    private Ticket ticket;//共享的资源
    public SaleTicket2(Ticket ticket){
        this.ticket = ticket;
    }
    //线程任务
    @Override
    public void run() {
        while(true){
            ticket.sell();
        }
    }
}
