package com.atguigu.javase.e_multithreading;

/**
 * 单例模式线程安全问题
 */
public class $11_Singleton {
    public static void main(String[] args) {
        /**
         * 饿汉式
         */
        Thread t1 = new Thread() {
            @Override
            public void run() {
                //super.run();
                Singleton instance = Singleton.INSTANCE;
                System.out.println(instance);//打印对象地址,查看每个线程实例获取的是否是同一个
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                //super.run();
                Singleton instance = Singleton.INSTANCE;
                System.out.println(instance);//打印对象地址,查看每个线程实例获取的是否是同一个
            }
        };
        t1.start();
        t2.start();
        /**
         * 懒汉式
         */
        Thread t3 = new Thread() {
            @Override
            public void run() {
                //super.run();
                Singleton1 instance = Singleton1.getInstance();
                System.out.println(instance);//打印对象地址,查看每个线程实例获取的是否是同一个
            }
        };
        Thread t4 = new Thread() {
            @Override
            public void run() {
                //super.run();
                Singleton1 instance = Singleton1.getInstance();
                System.out.println(instance);//打印对象地址,查看每个线程实例获取的是否是同一个
            }
        };
        t3.start();
        t4.start();
    }
}


/**
 * ①饿汉式:上来就创建对象,没有线程安全问题
 */

class Singleton{
    //2.不能让外界new,在本类中自己new对象出来,而且还得保证对象随着类的加载而加载
    public static final Singleton INSTANCE = new Singleton();
    //1.私有化构造器
    private Singleton(){

    }
}

/**
 * ②懒汉式:不着急要这个对象,什么时候使用,什么时候new对象给外界使用,但是要保证是同一个对象
 */
class Singleton1{
    //3.对外提供方法,返回本类需要new的对象(双重检测锁)
    public static Singleton1 getInstance(){
        //一旦创建了对象,之后再次获取对象,都不会再进入同步代码块,提升效率
        if(INSTANCE == null){
            //同步锁,锁住判断语句与创建对象并赋值的语句
            synchronized (Singleton1.class){
                if(INSTANCE == null){
                    INSTANCE = new Singleton1();
                }
            }
        }
        return INSTANCE;
    }
    //2.饿汉式不需要对象随着类的加载而new
    private static Singleton1 INSTANCE;
    //1.私有化构造器
    private Singleton1(){

    }
}




