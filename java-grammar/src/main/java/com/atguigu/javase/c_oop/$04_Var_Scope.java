package com.atguigu.javase.c_oop;
/*
* java中作用域的分类
*   1.全局变量:也就是属性,作用域为整个类体,随着对象的创建而产生,随着对象的消失而消失
*   2.局部变量:作用域为定义它的代码块中,随着代码块的执行而创建,随着代码块的结束而消失
*
* */
public class $04_Var_Scope {

    int a;//全局变量可以不赋值,直接使用,因为有默认值
    public int c;//全局变量可以加修饰符

    public static void main(String[] args) {
        test();
    }
    public static void test(){
        int b;
        //System.out.println(b);---->局部变量必须赋值后才能使用,因为没有默认值
        int a = 10;
        //int a = 100;------>在同一个作用雨中,两个局部变量不能重名
        //public int d = 66;------>局部变量不可以加修饰符
        System.out.println(a);//局部变量可以和全局变量重名,访问时遵循就近原则
    }



}
