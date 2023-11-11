package com.atguigu.javase.h_java8newfeature;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream是Java8中处理集合的关键抽象概念,他可以指定你希望对集合进行的操作,可以执行非常复杂的查找,过滤和映射数据等操作,使用Stream API对
 * 集合数据进行操作,就类似于使用SQL执行的数据库查询,也可以使用Stream API来并行执行操作,简言之Stream API提供了一种高效且易于使用的处理数
 * 据的方式
 *
 * Stream是数据渠道,用于操作数据源(集合,数组等)所生成的元素序列,集合讲的是数据,负责存储数据,Stream流讲的是计算,负责处理出具
 * 注意:
 *      ①Stream自己不会存储元素
 *      ②Stream自己不会改变源对象,每次处理都会返回一个持有把结果的新Stream
 *      ③stream操作是延迟执行的,这意味着他们会等到需要结果的时候才执行
 * Stream操作三个步骤
 *      ①创建一个Stream:通过一个数据源(如集合,数组等),获取一个流
 *      ②中间操作:中间操作是个操作链,对数据源的数据进行n处理,但是在终结操作前,并不会真正执行
 *      ③终止操作:一旦执行终止操作,就执行中间操作链,最终产生结果并结束Stream
 */
public class $08_StreamCreate {
    /*
    创建Stream方式一:通过集合
    Java8中的Collection接口被扩展,提供了两个获取流的方法
    ·public default Stream stream():返回一个顺序流
    ·public default Stream parallelStream():返回一个并行流
     */
    @Test
    public void test01(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        //jdk1.8中 Collection系列集合增加了方法
        Stream<Integer> stream = list.stream();
        stream.forEach(System.out::println);

    }
    /*
    创建Stream方式二:通过数组
    Java8中的Arrays的静态方法stream()可以获取数组流
    ·public static Stream stream(T[] array):返回一个流
     */
    @Test
    public void test02(){
        int[] arr = {1,2,3,4,5};
        IntStream stream = Arrays.stream(arr);
        stream.forEach(System.out::println);
        String[] arr1 = {"hello","world"};
        Stream<String> stream1 = Arrays.stream(arr1);
        stream1.forEach(System.out::println);
    }
    /*
    创建Stream方式三:通过Stream的of()
    可以调用Stream类静态方法of(),通过显示值创建一个流,它可以接收任意数量的参数
    ·public static Stream of(T... values):返回一个顺序流
     */
    @Test
    public void test03(){
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        stream.forEach(System.out::println);
    }
    /*
    创建Stream方式四:创建无限流
    可以使用静态方法 Stream.iterate()和Stream.generate()创造无限流
    ·public static Stream iterate(final T seed,final UnaryOperator f):返回一个无限流
    ·public static Stream generate(Supplier s):返回一个无限流
     */
    @Test
    public void test04(){
        Stream<Double> stream = Stream.generate(Math::random);
        //stream.forEach(System.out::println);
        Stream<Integer> stream1 = Stream.iterate(1, num -> num += 2).limit(10);
        stream1.forEach(System.out::println);
    }
}
