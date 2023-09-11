package com.atguigu.javase.d_api;

/**
 * String:引用数据类型,表示字符串,String也是一个类,位于java.lang包下,java程序中所有的字符串字面量(如"abc")都可以看做是此类的实例,因为字符串太常用了
 * 所有java提供了这种简单的字符串字面量的表达方式
 *
 */

public class $01_StringPeculiarity {
    public static void main(String[] args) {
        String s = "hello";
        s="world";
        System.out.println(s);
        //①字符串不可变,修改字符串变量值,相当于新生成一个字符串对象
        /*public final class String
                implements java.io.Serializable, Comparable<java.lang.String>, CharSequence {
            *//** The value is used for character storage. *//*
            private final char value[];

            *//** Cache the hash code for the string *//*
            private int hash; // Default to 0
            ......
            }

            */
        //②字符数组private final char value[]:字符串对象的内部存储方式,String底层是靠字符数组实现的
        /*
        * String s = "abc" 相当于
        * char[] data={'a','b','c'}
        * String str = new String(data)
        * */
        //③字符串字面量也是一个String类的实例,存储在字符串常量池中,相同的字符串字面量表示的对象在内存中只有一份
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);//内存中只有一个"abc"对象被创建,同时被s1和s2共享
        //④字符串String类型本身是final声明的,意味着我们不能继承String,也就意味着我们不能去重写它的方法

    }
}
