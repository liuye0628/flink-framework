package com.atguigu.javase.c_oop;



/**
 * 面向对象特性:封装
 *  封装:就是把抽象出来的数据(属性)和对数据的操作(方法)封装到一起,数据被保护在内部,程序只有通过被授权的操作(方法),才能对数据进行操作
 *  好处:隐藏实现细节,可以对数据进行验证,保证安全合理
 */

public class $05_ObjectEncapsulation {
    //1.将属性进行私有化private(不能直接修改属性)
    private String name;
    //2.提供一个公共的set方法可以对属性判断及赋值
    public  void setName(String name){
        //加入数据的验证逻辑
        this.name = name;//this 代表当前对象

    }
    //3.提供一个公共的get方法,可以获取属性的值
    public String getName(){
        return name;
    }
    /**
     * 构造器:是类的一种特殊的方法,主要作用是完场对类的初始化,特点:
     *  1.方法名与类名相同,没有返回值
     *  2.在创建对象时,系统会自动调用该类的构造器完成对对象的初始化
     *  3.如果程序没有定义构造器,系统会自动给类生成一个默认无参构造器,比如$05_ObjectEncapsulation(){}
     *  4.一旦定义了自己的构造器,默认的构造器就被覆盖,就不能再使用默认的无参构造器,除非显式的定义一下
     */
    //空参构造
    public $05_ObjectEncapsulation(){

    }
    //有参构造
    public $05_ObjectEncapsulation(String name){
        this.name=name;
    }
}
