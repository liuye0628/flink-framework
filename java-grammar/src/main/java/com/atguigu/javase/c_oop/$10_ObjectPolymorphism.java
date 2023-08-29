package com.atguigu.javase.c_oop;

/**
 *面向对象特性:多态
 *  基本介绍:方法或对象具有多态性,是面向对象的第三大特征,多态是建立在封装和继承基础之上的
 *      1.方法的多态:重写和重载就体现多态
 *      2.对象的多态:
 *          ①一个对象的编译类型和运行类型可以不一致
 *          ②编译类型在定义对象时,就已经确定了,不能改变
 *          ③运行类型是可以变化的
 *          ④编译类型看定义时"="的左边,运行类型看"="的右边
 */

public class $10_ObjectPolymorphism {
    public static void main(String[] args) {
        //多态的具体使用(向上转型)
        Animal dog = new Dog();
        System.out.println(dog.id);//属性的值看编译类型
        dog.call();
        //dog.sleep();多态形式不能调用子类的特有功能
        //多态的具体使用(向下转型)
        Dog dog1 = (Dog)dog;
        dog1.sleep();//需要调用子类的特有功能,需要向下转型,只能强转父类的引用,不能强转父类的对象

        /*
        a instanceof A:比较操作符:用于判断对象a的运行类型是否为A类型或A类型的子类型
         */
        System.out.println(dog instanceof Animal);
    }


}




