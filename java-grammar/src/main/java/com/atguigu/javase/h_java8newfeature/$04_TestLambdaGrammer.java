package com.atguigu.javase.h_java8newfeature;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Lambda表达式是用来给[函数式接口]的变量或形参赋值用的
 *  本质上Lambda表达式是用于实现[函数式接口]的抽象方法
 *  Lambda表达式语法格式:   (形参列表)  ->{Lambda体}
 *  说明:
 *      ①{形参列表}它就是你要赋值的函数式接口的抽象方法{形参列表},照抄
 *      ②{Lambda体}就是实现这个抽象方法的方法体
 *      ③->称为Lambda操作符(减号和大于号中间不能有空格,而且必须是英文状态下半角输入方式)
 *  优化: Lambda表达式可以精简
 *      ①当{Lambda}体中只有一个语句时,可以省略{}和{;}
 *      ②当{Lambda}体中只有一句语句时,并且这个语句还是return语句,那么这个return也可以省略,但是如果{;}没有省略,return是不能省略的
 *      ③形参列表的类型可以省略
 *      ④当形参列表的形参个数只有一个,那么可以把数据类型和()一起省略,但是形参名不能省略
 *      ⑤当形参列表是空参时,()不能省略
 */
public class $04_TestLambdaGrammer {

    /**
     * 使用Lambda表达式给Runnnable接口的形参或变量赋值
     * 确认两件事,才能写好Lambda表达式
     *      ①这个接口的抽象方法长什么样
     *          public void run()
     *      ②这个抽象方法的实现要干什么事
     *          例如:我要打印"hello lambda"
     */
    @Test
    public void Test01(){
        Runnable r = () ->{
            System.out.println("hello lambda");
        };
        new Thread(r).start();
    }

    @Test
    public void Test02(){
        //省略lambda体
        Runnable r = () -> System.out.println("hello lambda");
        new Thread(r).start();
    }

    /**
     * 数组排序:不区分大小写
     */
    @Test
    public void Test03(){
        String[] arr = {"hello","Hello","java","chai"};
        /**
         * public static <T> void sort(T[] a,Comparator<? super T> c)
         * 这里使用Lambda表达式为Comparator类型的形参赋值
         * 两件事:
         *      ①这个接口的抽象方法 ,int compare(T o1, T o2)
         *      ②这个抽象方法要做什么事 这里是指对String类型的元素,不区分大小写的比较大小
         */
        Arrays.sort(arr,(o1,o2)->o1.compareToIgnoreCase(o2));
        for (String s : arr) {
            System.out.println(s);
        }
    }


    @Test
    public void Test04(){
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("java");
        list.add("world");
        /**
         * jdk1.8给Collection系列的集合,准确来讲是在Iterable接口中,增加了一个默认方法
         *      default void forEach(Consumer<? super T> action)
         *      这个方法是用来遍历集合的,代替原来的foreach循环
         *      这个方法的形参是Consumer接口类型,它是函数式接口中消费性接口的代表
         *
         *      现在需要调用这个方法,想要用Lambda表达式为Consumer接口类型形参赋值
         *      两件事:
         *          ①它的抽象方法: void accept(T t)
         *          ②抽象方法的实现要完成的事是什么? 例如,这里打印这个t
         */
        list.forEach(t-> System.out.println(t));
    }
}
