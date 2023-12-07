package com.atguigu.javase.e_multithreading;

/**
 * 锁相关:任何线程进入同步代码块,同步方法之前,必须先获得对同步监视器的锁定,那么,何时会释放对同步监视器的锁定呢?
 * 1.释放锁的操作:
 *  ·当前线程的同步方法,同步代码块执行结束
 *  ·当前线程在同步代码块,同步方法中出现了未处理的Error或Exception,导致当前线程异常结束
 *  ·当前线程在同步代码块,同步方法中执行了锁对象的wait()方法,当前线程被挂起,并释放锁
 * 2.不会释放锁的操作
 *  ·线程在执行同步代码块或同步方法时,程序调用Thread.sleep(),Thread.yield()方法暂停当前线程的执行
 *  ·线程在同步代码块时,其他线程调用了该线程的suspend()方法将该线程挂起,该线程不会释放锁(同步监视器),应尽量避免使用suspend()和resume()这样的过时来控制线程
 * 3.死锁
 *  ·不同的线程分别锁住对方需要的同步监视器对象不释放,都在等待对方先放弃时就形成了线程的死锁,一旦出现死锁,整个程序即不会发生异常,也不会给出任何提示,只是所有的线程
 *  处于阻塞状态,无法继续
 * 4.面试题:sleep()和wait()方法的区别
 *  ·sleep()不释放锁,wait()释放锁
 *  ·sleep()指定休眠的时间,wait()可以指定时间也可以无限等待直到notify或notifyAll()
 *  ·sleep()在Thread类中声明的静态方法,wait方法在Object类中声明
 *  ·因此我们在调用wait()方法是由锁对象调用,而锁对象的类型任意类型的对象,那么希望任意类型的对象都要有的方法,只能声明在Object类中
 */
public class $15_Lock {
    public static void main(String[] args) {
        Object g = new Object();
        Object m = new Object();
        Owner owner = new Owner(g,m);
        Customer customer = new Customer(g, m);
        new Thread(owner).start();
        new Thread(customer).start();

    }
}
class Owner implements Runnable{
    private Object goods;
    private Object money;

    public Owner(Object goods, Object money) {
        this.goods = goods;
        this.money = money;
    }

    @Override
    public void run() {
        synchronized (goods){
            System.out.println("先给钱");
            synchronized (money){
                System.out.println("再发货");
            }
        }
    }
}
class Customer implements Runnable{
    private Object goods;
    private Object money;

    public Customer(Object goods, Object money) {
        this.goods = goods;
        this.money = money;
    }

    @Override
    public void run() {
        synchronized (money){
            System.out.println("先发货");
            synchronized (goods){
                System.out.println("再给钱");
            }
        }
    }
}
