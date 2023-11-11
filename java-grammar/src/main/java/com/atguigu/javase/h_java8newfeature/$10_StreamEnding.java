package com.atguigu.javase.h_java8newfeature;

import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 终结操作会从流的流水线生成结果,其结果可以是任何不是流的值,例如List,Integer,甚至是void,流进行了终止操作后,不能再次使用
 */
public class $10_StreamEnding {

    /**
     * void forEach(Consumer c) : 迭代
     */
    @Test
    public void Test01(){
        Stream.of(1,2,3,4,5)
                .forEach(System.out::println);
    }

    /**
     * long count() : 返回流中元素个数
     */
    @Test
    public void Test02(){
        System.out.println(Stream.of(1, 2, 3, 4, 5)
                .count());
    }

    /**
     * boolean allMatch(Predicate p) : 检查是否匹配所有元素
     * boolean anyMatch(Predicate p) : 检查是否至少匹配一个元素
     * boolean noneMatch(Predicate p) : 检查是否没有匹配所有元素
     */
    @Test
    public void Test03(){
        boolean result1 = Stream.of(1, 2, 3, 4)
                .allMatch(num -> num % 2 != 0);
        boolean result2 = Stream.of(1, 2, 3, 4)
                .anyMatch(num -> num % 2 != 0);
        boolean result3 = Stream.of(1, 2, 3, 4)
                .noneMatch(num -> num % 2 != 0);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

    /**
     * Optional findFirst(): 返回第一个元素
     * Optional findAny(): 返回当前流中的任意元素
     */
    @Test
    public void Test04(){
        Optional<Integer> opt = Stream.of(1, 2, 3, 4, 5, 6).findFirst();
        Optional<Integer> opt1 = Stream.of(2, 3, 4, 5, 6).findAny();
        System.out.println(opt);
        System.out.println(opt1);
    }

    /**
     * Optional max(Comparator c): 返回流中最大值
     * Optional min(Comparator c): 返回流中最小值
     */
    @Test
    public void Test05(){
        Optional<Integer> max = Stream.of(1, 2, 3, 4, 5, 6).max((t1, t2) -> Integer.compare(t1, t2));
        System.out.println(max);
        Optional<Integer> min = Stream.of(1, 2, 3, 4, 5, 6).min((t1, t2) -> Integer.compare(t1, t2));
        System.out.println(min);
    }

    /**
     * T reduce(T iden, BinaryOperator b): 可以将流中元素反复结合起来,得到一个值,返回T
     * T reduce(BinaryOperator b): 可以将流中元素反复结合起来,得到一个值,返回Optional
     */
    @Test
    public void Test06(){
        Integer reduce = Stream.of(1, 2, 3, 4, 5)
                .reduce(0, (t1, t2) -> t1 + t2);
        System.out.println(reduce);
        Optional<Integer> reduce1 = Stream.of(1, 2, 3, 4, 5)
                .reduce((t1,t2) -> t1>t2?t1:t2);
        System.out.println(reduce1);
    }

    /**
     * R collect(Collect c): 将流转换为其他形式,接收一个Collector接口的实现,用于给Stream中的元素做汇总的方法
     * Collector接口中方法的实现决定了如何对流执行收集的操作(如收集到List,Set,Map),另外Collectors实用类提供了很多静态方法,可以方便的创建常见收集器实例
     */
    @Test
    public void Test07(){
        List<Integer> list = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.toList());
        System.out.println(list);
    }
}
