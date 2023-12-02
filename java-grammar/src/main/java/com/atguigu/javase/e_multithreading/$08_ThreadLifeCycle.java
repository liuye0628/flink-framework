package com.atguigu.javase.e_multithreading;

/**
 * 传统线程模型的五种线程状态:
 *      传统线程模型中把线程生命周期描述为五种状态:新建(New),就绪(Runnable),运行(Running),阻塞(Blocked),死亡(Dead),CPU需要在多条线程之间
 *   切换,于是线程状态会多次在运行,阻塞,就绪之间切换
 */
public class $08_ThreadLifeCycle {
    /**
     * 传统线程模型:
     *      ①新建:当一个Thread类或其子类的对象被声明或创建时,新生的线程对象处于新建状态,此时它和其他java对象一样,仅仅由jvm为其分配了
     *      内存,并初始化化了实例变量的值,此时的线程对象并没有任何线程的动态特征,程序也不会执行它的线程体run()
     *      ②就绪:就是当线程对象调用了start()方法之后,线程就从新建状态转为就绪状态,这时线程并未执行,只是具备了运行的条件,还需要获取CPU资源后才能执行
     *      ③运行:如果处于就绪状态的线程获取获取了CPU资源,开始执行run()方法中的线程体代码,则该线程处于运行状态,如果计算机只有一个CPU,
     *      在任何时刻只有一个线程处于运行状态,如果计算机有多个处理器,将会有多个线程(Parallel)执行
     *      当然,美好的时光总是短暂的,而且CPU讲究雨露均沾,对于抢占式策略的系统而言,系统会给每个可执行的线程一个小时间段来处理任务,当该时间用完,系统会剥夺
     *      该线程占有的资源,让其回到就绪状态等待下一次被调度,此时其他线程将获得执行机会,而在选择下一个线程时,系统会优先考虑线程的优先级
     *      ④阻塞:当在运行过程中的线程遇到某些特殊情况时,线程会临时放弃CPU资源,不再执行,即进入阻塞状态,比如线程调用了sleep()方法,会主动放弃所占有的CPU资源
     *      ⑤死亡:线程完成任务结束或意外终止后,线程就进入死亡状态
     */

    /**
     * JDK定义的六种线程状态(了解)
     * 在 java.lang.Thread类内部定义了一个枚举类用来描述线程的六种状态:
     *      public enum State{
     *          NEW,
     *          RUNNABLE,
     *          BLOCKED,
     *          WAITING,
     *          TIMED_WAITING,
     *          TERMINATED
     *      }
     *      跟传统线程模型中的线程状态不同的是:
     *      ①枚举类中没有区分就绪和运行状态,而是定义成了一种状态Runnable
     *          ·因为对于Java对象来说,只能标记为可运行,至于什么时候运行,不是jvm来控制的了,是OS来进行调度的,而且时间比较短暂,因此对于Java对象
     *          的状态来说,无法区分,只能我们人为的进行想象和理解
     *      ②传统模型中的阻塞状态在枚举类中的定义又细分为了三种状态:BLOCKED,WAITING,TIMED_WAITING
     *          ·BLOCKED:是指互有竞争关系的几个线程,其中一个线程占有锁对象时,其他线程只能等待锁,只有获得锁对象的线程才能有执行机会
     *          ·TIMED_WAITING:当前线程执行过程中遇到Thread类的sleep或join,Object类的wait,LockSupport类的park方法,并且在调用
     *          这些方法时,设置了时间,那么当前线程会进入TIMED_WAITING,直到时间到,或被中断
     *          ·WAITING:当前线程执行过程中遇到Object类的wait,Thread类的join,LockSupport类的park方法,并且在调用这些方法时,没有指定
     *          时间,那么当前线程会进入WAITING状态,直到被唤醒
     *              ·通过Object类的wait进入WAITING状态的要有Object的notify/notifyAll唤醒
     *              ·通过Condition的await进入WAITING状态的要有Condition的signal方法唤醒
     *              ·通过LockSupport类的park方法进入WAITING状态的要有LockSupport类的unpark方法唤醒
     *              ·通过Thread类的join进入WAITING状态,只有调用join方法的线程对象结束,才能让当前线程恢复
     *      说明:当从WAITING或TIMED_WAITING恢复到RUNNABLE状态时,如果发现当前线程没有得到监视器锁,那么会立即转入BLOCKED状态
     */
}
