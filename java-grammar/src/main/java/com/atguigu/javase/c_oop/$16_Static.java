package com.atguigu.javase.c_oop;

/**
 * 类变量与类方法(static修饰)
 * 静态方法只能访问静态成员,非静态方法既可以访问静态成员,也可以访问非静态成员
 */
public class $16_Static {
    static int id = 1;//类变量
    public static void main(String[] args) {

        System.out.println($16_Static.id);//访问 类变量.类变量名
    }
    //类方法:当方法中不涉及与对象相关的成员,则可以将方法设计成静态方法提高开发效率
    public static void myStatic(){
        /**
         * 注意事项:
         *  ①类方法只能访问静态变量或静态方法
         *  ②类方法中不允许使用和对象有关的关键字,比如this和super,成员方法则可以
         *  ③类方法可以通过类名调用,也可以通过方法名调用
         *  ④类方法和普通方法都是通过类的加载而加载,将结构信息存储在方法区
         */
    }
}
