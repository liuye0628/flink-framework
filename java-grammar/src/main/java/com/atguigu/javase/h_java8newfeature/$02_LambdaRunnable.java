package com.atguigu.javase.h_java8newfeature;

/**
 * 使用lambda表达式代替runnable接口的匿名内部类写法
 *      面向对象的思想:做一件事情,找一个能解决这个事情的对象,调用对象的方法,完成事情
 *      函数式编程思想:只要能获取到结果,谁去做的,怎么做的都不重要,重视的是结果,不是过程
 */
public class $02_LambdaRunnable {
    public static void main(String[] args) {
        /*
        Lambda表达式其实就是实现SAM接口的语法糖,所谓SAM接口就是single abstract method,即该接口只有一个抽象方法需要实现
        当然该接口可以包含其他非抽象方法
        其实只要满足"SAM"特征的接口都可以称为函数式接口,但是如果要更明确一点,最好在声明接口时,加上@Functionalinterface,一旦使用该注解来定义接口,编译器
        将会强制检查该接口是否确实有且仅有一个抽象方法,否则将会报错
        在学过的SAM接口中标记了@Functionalinterface的函数式接口有Runnable,Comparator,FileFilter
        java8在java.util.function新增了很多函数式接口,主要分为四大类:消费型,供给型,判断型,功能型,基本可以满足开发需求
         */
        new Thread(()->System.out.println("多线程任务执行!")).start();


    }
}
