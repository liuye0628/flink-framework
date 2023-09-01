package com.atguigu.javase.c_oop;
//异常

/**
 * 基本概念:在java语言中,将程序中发生的不正常情况称为"异常"(开发过程中的语法错误和逻辑错误不是异常)
 * 执行过程中的异常事件可分为两类
 *      ①Error(错误):Java虚拟机无法解决的严重问题,如jvm系统内部错误,资源耗尽等严重情况,比如StackOverflowError(栈溢出)和OOM(out of memory),Error是严重错误,程序会崩溃
 *      ②Exception:其他因编程错误或偶然的外在因素导致的一般性问题,可以使用针对性的代码进行处理,例如空指针访问,试图读取不存在的文件,网络连接中断等等
 *      ③Exception分为两大类:运行时异常[程序运行时发生的异常]和编译时异常[编程时,编译器检查出的异常]
 */
public class $18_Exception {

    public static void main(String[] args) {
        //异常处理方式
        //1.try-catch-finally:程序员在代码中捕获发生的异常,自行处理
        try {
            System.out.println("可能有异常的代码");
        } catch (Exception e) {
            /**
             * ①当异常发生时,系统将异常封装成Exception对象e,传递给catch
             * ②得到异常对象后,程序员自己处理
             * ③如果没有发生异常,catch代码块不执行
             * ④如果要求多个catch捕获不同的异常,要求子类异常写在前面,父类异常写在后面
             */
            e.printStackTrace();
        } finally {
            /**
             * ①不管try代码块是否异常发生,始终要执行那finally
             * ②通常将释放资源的代码放在finally
             */
        }




    }
    //2.throws:将发生的异常抛出,交给调用者(方法来处理),最顶级的处理者就是JVM(处理异常:输出异常信息,退出程序)
    //如果程序员没有显式处理异常,默认就是throws
    public static void m(String s) throws NullPointerException{
        if(s == null){
            throw new NullPointerException("空指针异常");
        }

    }
}
