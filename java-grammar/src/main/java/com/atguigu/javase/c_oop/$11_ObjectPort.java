package com.atguigu.javase.c_oop;
/*
* 接口
*  基本介绍:接口就是给出一些没有实现的方法,封装到一起,某个类要使用的时候,在根据具体情况把这些方法写出来
*  jdk1.8之后接口可以有静态方法,默认方法.也就是说接口中可以有方法的具体实现
*  注意事项:
*       ①接口不能被实例化
*       ②成员变量:默认使用public static final 修饰,即使不写默认也有,而且必须初始化
*       ③抽象方法:在接口中定义没有方法体的方法(即使不写abstract,默认也有),实现类必须对该方法重写(抽象类除外)
*       ④默认方法:default 修饰,有方法体,实现类可以不对该方法重写,如果需要重写,则不需要带default
*       ⑤静态方法:static 修饰,有方法体,不能被实现类重写
*       ⑥接口可以多继承,一个类可以同时实现一个或多个接口,接口不能继承其他的类
*
* */
public interface $11_ObjectPort {
    void open();
    public default void close(){
        System.out.println("关闭");
    }
    static void start1(){
        System.out.println();
    };

}
//一个类实现接口,则需要将该接口的所有抽象方法都实现
class Test implements $11_ObjectPort{

    @Override
    public void open() {
        System.out.println("打开测试");
    }

    /*@Override
    public void close() {
        System.out.println("关闭测试");

    }*/


}
