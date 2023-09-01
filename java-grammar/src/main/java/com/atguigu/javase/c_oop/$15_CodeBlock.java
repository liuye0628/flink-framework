package com.atguigu.javase.c_oop;

/**
 * 代码块:又称为初始化块,属于类中的成员,类似于方法,将逻辑语句封装到方法体中,通过{}包围起来
 * 但和方法不同;没有方法名,没有返回值,没有参数.只有方法体,而且不能通过对象或类显式调用,而是加载类或创建对象时隐式调用
 */

public class $15_CodeBlock {
    //1.构造代码块(普通代码块)

    /**
     * 在创建对象实例时,会被隐式的调用,被创建一次,就会调用一次,如果只是使用类的静态成员时,普通代码块并不会执行
     */
    {
        a();
        b();//普通代码块即能调用静态成员,又能调用非静态成员
        System.out.println("我是构造代码块");
    }
    //2.静态代码块
    /**
     * 作用就是对类进行初始化,并且它随着类的加载而执行,并且只会执行一次
     */
    static{
        a();//静态代码块只能调用静态成员
        System.out.println("我是静态代码块");
    }

    public static void main(String[] args) {
        a();//如果只是使用类的静态成员时,普通代码块并不会执行,静态代码块会执行
        //$15_CodeBlock codeBlock = new $15_CodeBlock();
        //$15_CodeBlock codeBlock1 = new $15_CodeBlock();
        /**
         * 类什么时候被加载:
         *  ①创建对象实例时(new)
         *  ②创建子类对象实例,父类也会被加载,而且父类先被加载,子类后被加载
         *  ③使用类的静态成员时
         */


    }
    public static void a(){
        System.out.println("a");
    }
    public void b(){
        System.out.println("b");
    }
}
