package com.atguigu.javase.e_multithreading;

/**
 * 创建多线程方式
 */

public class $02_ThreadCreation {
    public static void main(String[] args) {
        /*
        方式一:继承Thread类
         */
        MyThread mt = new MyThread("新的线程! ");//创建自定义线程对象
        mt.start();//开启新线程
        //在主方法中执行for循环
        for (int i = 0; i < 10; i++){
            System.out.println("main线程! "+ i);
        }
        System.out.println("--------------------------------------");
        /*
        方式二:实现Runnable接口
         */
        MyRunnable mr = new MyRunnable();//创建自定义类对象 线程任务对象
        Thread t = new Thread(mr, "mr");
        t.start();
        /*
        方式三:使用匿名内部类对象
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++){
                    System.out.println(Thread.currentThread().getName() + " " + i);
                }
            }
        }).start();

    }
}


/**
 * 方式一:继承Thread类
 *  Java中java.lang.Thread是表示线程的类,每个Thread类或其子类的实例代表一个线程对象,通过继承Thread类来创建多线程的步骤
 *      ①定义Thread类的子类,并重写该类的run()方法,该run()方法的方法体就代表了线程需要完成的任务,因此把run()方法称为线程执行体
 *      ②创建Thread子类的实例,即创建了线程对象
 *      ③调用线程对象的start()方法来启动该线程
 *  注意事项:
 *      ①手动调用run()方法不是启动线程的方式,只是普通方法调用
 *      ②start()方法启动线程后,run()方法会由jvm调用执行
 *      ③不要重复启动同一个线程,否则抛出异常IllegalThreadStateException
 *      ④不要使用Junit单元测试多线程,不支持,主线程结束后会调用System.exit()直接退出JVM
 */
class MyThread extends Thread{
    //定义指定线程名称的构造方法
    public MyThread(String name) {
        //调用父类的String参数的构造方法,指定线程的名称
        super(name);
    }

    /**
     * 重写run()方法完成该线程执行的逻辑
     */
    @Override
    public void run() {
        //super.run();
        for(int i = 0; i < 10; i++){
            System.out.println(getName()+": 正在执行!" + i);
        }
    }
}

/**
 * 方式二:实现Runnable接口
 * Java有单继承的限制,当我们无法继承Thread类时,那么该如何做呢?在核心类库中提供了Runnable接口,我们可以实现Runnable接口,重写run()方法,
 * 然后再通过Thread类的对象代理启动和执行我们的线程体run()方法,通过实现Runnable接口创建线程并启动的步骤
 *      ①定义实现Runnable接口的实现类,并重写该接口的run()方法,该run()方法的方法体同样是该线程的线程执行体
 *      ②创建Runnable实现类的实例,并以此实例作为Thread的target来创建Thread对象,该Thread对象才是真正的线程对象
 *      ③调用线程对象的start()方法来启动线程
 */
class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}

/**
 * 两种创建线程方式比较
 *      ①Thread类本身也是实现了Runnable接口的,run()方法都来自Runnable接口,run()方法也是真正要执行的线程任务
 *      ②因为Java类是单继承的,所以继承Thread的方式有单继承的局限性,但是使用上更简单一些
 *      ③实现Runnable接口的方式,避免了单继承的局限性,并且可以使多个线程对象共享一个Runnable实现类(线程任务类)对象,从而方便在多线程任务执行时共享数据
 */
