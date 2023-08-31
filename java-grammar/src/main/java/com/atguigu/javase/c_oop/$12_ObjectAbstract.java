package com.atguigu.javase.c_oop;
/*
*   抽象类:当父类的某些方法需要声明,但是又不确定如何实现时,可以将其声明为抽象方法,那么这个类就是抽象类
*       注意事项:
*           ①抽象类不能实例化,需要通过子类做具体实现
*           ②抽象类不一定包含abstract方法,一旦包含abstract方法,则这个类必是抽象类
*           ③abstract只能修饰类和方法,不能修饰属性和其他
*           ④抽象类中可以有非抽象方法,构造器,静态属性等等
*      抽象类和接口的区别:
*           相同点:都位于继承的顶端,用于被其他类实现和继承,都不能直接实例化对象,都包含抽象方法,其子类都必须重写这些抽象方法
*           不同点:类不能多继承,接口可以,抽象类可以有成员变量,构造方法,成员方法等
*
*
* */

public abstract class $12_ObjectAbstract {
    //抽象方法不能用private,final和static修饰,因为这些关键字都是和重写相违背的
    public abstract void call();



}
class A extends $12_ObjectAbstract{

    @Override
    public void call() {
        System.out.println("打电话");
    }
}
