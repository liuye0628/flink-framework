package com.atguigu.javase.f_map;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 增强for循环(foreach循环)是jdk1.5以后出来的一个高级for循环,专门用来遍历数组和集合的
 *  格式:
 *          for(元素的数据类型 变量 : Collection集合or数组){
 *              //写操作代码
 *          }
 *  foreach本质上是使用iterator迭代器进行遍历的,可以在第29行打断点,使用单步调试进入代码,发现foreach本质是调用集合的iterator()方法
 *  返回一个迭代器进行迭代的
 */
public class $03_Foreach {
    public static void main(String[] args) {
        //①遍历数组
        int[] arr = {3,5,7,9};
        //使用增强for遍历数组
        for (int i : arr) {//i 代表数组中的每个元素
            System.out.print(i+"\t");
        }
        System.out.println();
        //②遍历集合
        Collection<String> coll = new ArrayList<>();
        coll.add("须佐之男");
        coll.add("御馔津");
        coll.add("一目连");
        //使用增强for遍历集合
        for (String s : coll) {//s 代表集合中的每个元素
            System.out.print(s+"\t");//遍历的时候不能使用Collection的remove()方法,否则会报异常
        }
    }

    /*
    java.lang.Iterable接口
    实现这个接口允许对象成为"foreach"语句的目标
    Java5时Collection接口继承了Iterable接口,因此Collection系列的集合就可以使用forEach遍历
     */
}
