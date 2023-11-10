package com.atguigu.javase.h_java8newfeature;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 方法引用
 *  Lambda表达式是可以简化函数式接口的变量与形参赋值的语法,而方法引用和构造器引用是为了简化Lambda表达式的,当Lambda表达式满足一些特殊的情况,还可以再简化:
 *      ①Lambda体中只有一句语句,并且是通过调用对象的/类的现有的方法来完成的
 *          例如:System.out对象,调用println()方法来完成Lambda体
 *              Math类,调用random()静态方法来完成Lambda体
 *      ②Lambda表达式的形参正好是给该方法的实参
 *          例如: t -> System.out.println(t)
 *               () -> Math.random()都是无参
 */

public class $06_MethodReference {
    /**
     * 方法引用的语法格式
     *  ①实例对象名::实例方法
     *  ②类名::静态方法
     *  ③类名::实例方法
     * 说明:
     *  ·::称为方法引用操作符(两个:中间不能有空格,而且必须英文状态下半角输入)
     *  ·Lambda表达式的形参列表,全部在Lambda体中使用上了,要么是作为调用方法的对象,要么是作为方法的实参
     *  ·在整个Lambda体中没有额外的数据
     */


    @Test
    public void test01(){
        List<Integer> list = Arrays.asList(1, 4, 3, 8, 5);
        //list.forEach(t -> System.out.println(t));
        //用方法再简化
        list.forEach(System.out::println);
    }

    @Test
    public void test02(){
        //Stream<Double> stream = Stream.generate(() -> Math.random());
        //用方法引用简化
        Stream<Double> stream = Stream.generate(Math::random);
        stream.forEach(System.out::println);
    }
    @Test
    public void test03(){
        String[] arr = {"hello","java","world"};
        //Arrays.sort(arr,(s1,s2)->s1.compareToIgnoreCase(s2));
        /**
         * 用方法引用简化
         * Lambda表达式的形参,第一个(s1)正好是调用方法的对象,剩下的形参(s2)正好是方法的实参
         */
        Arrays.sort(arr,String::compareToIgnoreCase);
        Arrays.asList(arr).forEach(System.out::println);
    }
    @Test
    public void test04(){
        //Runnable r = () -> System.out.println("hello lambda");
        Runnable r = System.out::println;//不能简化方法引用,因为"hello lambda"这个无法省略
    }
}
