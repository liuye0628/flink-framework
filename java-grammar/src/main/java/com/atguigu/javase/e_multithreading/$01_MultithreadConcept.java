package com.atguigu.javase.e_multithreading;

/**
 * 多线程相关概念
 */
public class $01_MultithreadConcept {

    /**
     * 1.并行与并发
     *  并行(parallel):指多个事件任务同一时刻发生(同时发生),指在同一时刻,有多条指令在多个处理器上同时执行,单核CPU同一时刻只能处理一条指令,所以单核CPU做不到并行处理
     *  并发(concurrency):指两个或多个事件在同一个微小的时间段内发生,指在同一个时刻只能有一条指令执行,但多个进程的指令被快速轮换执行,使得在宏观上具有多个线程同时执行
     *  的效果,程序并发执行可以在有限条件下,充分利用CPU资源,这是我们研究的重点
     *
     *      在操作系统上,安装了多个程序,并发指的是在一段时间内宏观上有多个程序同时运行,这在单CPU系统中,每一时刻只能有一个程序执行,即微观上这些程序是分时的交替运行,只不过
     *  给人的感觉是同时运行,那是因为分时交替运行的时间是非常短的
     *      而在多个CPU系统中,则这些可以并发执行的程序便可以分配到多个处理器上(CPU),实现多任务并行执行,即利用每个处理器来处理一个可以并发执行的程序,这样多个程序便可以同时执行
     *  目前电脑市场上说的多核CPU,便是多核处理器,核越多,并行处理的程序越多   能大大提高程序运行的效率
     *
     *  注意:单核处理器的计算机肯定是不能并行处理多个任务的,只能是多个任务在单个CPU上并发运行,同理,线程也是一样的,从宏观角度上理解线程是并向运行的,但是从微观程度上分析确是
     *  串行运行的,即一个线程一个线程去运行,当系统只有一个CPU时,线程会以某种顺序执行多个线程,我们把这种情况称为线程调度
     *
     *   单核CPU:只能并发
     *   多核CPU:并行+并发
     *
     *  eg: 并行:多项任务一起执行,之后再汇总,例如:泡方便面,电水壶烧水,一边撕调料倒入桶中
     *      并发:同一时刻多个线程在访问同一个资源,多个线程对一个点,例如,春运抢票,电商秒杀....
     */

    /**
     * 2.线程与进程
     * ·程序:为了完成某个任务或功能,选择一种编程语言编写的一组指令的集合
     * ·软件:一个或多个应用程序+相关的素材和资源文件等构成一个软件系统
     * ·进程:进程是对一个程序运行过程(创建->运行->消亡)的描述,系统会为每个运行的程序建立一个进程,并为进程分配独立的系统资源,比如内存空间等资源
     * ·线程:线程是进程中的一个执行单元,负责完成当前程序的任务,一个进程中至少有一个线程,一个进程中是可以有多个线程的,这个应用程序也可以称之为多线程程序,多线程使得程序可以并发执行,充分利用CPU资源
     * ·面试题:进程是操作系统调度和分配资源的最小单位,线程是CPU调度的最小单位,不同的进程之间是不共享内存的,进程之间的数据交换和通信的成本是很高,不同的线程是共享同一个进程的内存,
     * 当然不同的线程也是有自己独立的内存空间,对于方法区,堆中的同一个对象的内存,线程之间是可以共享的,但是栈的局部变量永远是独立的
     */

    /**
     * 3.多线程的优点与应用场景
     *  主要优点:充分利用CPU空闲时间片,用尽可能短的时间完成用户的请求,也就是使程序的响应速度更快
     *  应用场景:①多任务处理,多个用户请求服务器,服务端程序可以开启多个线程分别处理每个用户的请求,互不影响
     *          ②单个大任务处理,下载一个大文件,可以开启多个线程一起下载,减少整体下载时间
     */

    /**
     * 4.线程调度
     *  指CPU资源如何分配给不同的线程,常见的两种线程调度方式:
     *      ·分时调度:所有线程轮流使用CPU的使用权,平均分配每个线程占用CPU的时间
     *      ·抢占式调度:优先让优先级高的线程使用CPU,如果线程的优先级相同,那么会随机选择一个(线程随机性),java采用的是抢占式调度方式
     *          抢占式调度详解:
     *              大部分操作系统都支持多进程并发执行,现在的操作系统几乎都支持同时运行多个程序,比如:现在我们上课一边使用编辑器,一边使用录屏文件,同时还开着画图板
     *          dos窗口等软件,此时,这些程序是在同时运行,"感觉这些软件好像在同一时刻运行着"
     *              实际上,CPU(中央处理器)使用抢占式调度模式在多个线程之间进行着高速的切换,对于CPU的一个核而言,某个时刻,只能执行一个线程,而CPU在多个线程之间的切换速度
     *          相对我们的感觉要快,看上去就是在同一个时刻运行,其实,多线程程序并不能提高程序的运行速度,但能提高程序的运行效率,让CPU的使用率更高
     */
}
