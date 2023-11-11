package com.atguigu.javase.h_java8newfeature;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;



/**
 * 构造器引用
 *  ①当Lambda表达式是创建一个对象,并且满足Lambda表达式形参,正好是给创造这个对象的构造器的实参列表
 *  ②当Lambda是创造一个数组对象,并且满足Lambda表达式形参,正好是给创造这个数组对象的长度
 */
public class $07_ConstructorReference {
    /**
     * 构造器引用的语法格式
     *  ·类名::new
     *  ·数组类型名::new
     */
    @Test
    public void test01(){
        //通过供给型接口,提供一个空字符串对象
        //Supplier<String> s = () -> new String();
        Supplier<String> s = String::new;
    }
    @Test
    public void test02(){
        Stream<String> stream = Stream.of("1.0", "2.3", "4.4");
        //Stream<BigDecimal> stream1 = stream.map(num -> new BigDecimal(num));
        Stream<BigDecimal> stream1 = stream.map(BigDecimal::new);
        stream1.forEach(System.out::println);
    }

    /**
     * 这个方法是模仿HashMap,把你指定的数组长度纠正为2的n次方的代码
     * createArray()的作用是,创建一个长度为2的n次方的数组
     * @param fun
     * @param length
     * @param <R>
     * @return
     */
    public <R> R[] createArray(Function<Integer,R[]> fun, int length){
        int n = length -1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        length = n < 0 ?1:n+1;
        return fun.apply(length);
    }
    @Test
    public void test03(){
        /*
        Function是一个函数式接口,可以用Lambda表达式来赋值
        Function<T,R>的抽象方法 R apply(T t)
        createArray这个方法中用的是Function<Integer,R[]> fun 说明T类型此时已被指定为Integer
         */
        //Function<Integer,String[]> f = (Integer len) -> new String[len];//因为Lambda体是创建一个数组对象来完成的,此时Lambda表达式的形参正好是创建数组用的长度
        //通过构造器引用策略
        Function<Integer,String[]> f = String[]::new;
        String[] array = createArray(f, 10);
        System.out.println(array.length);
    }
    @Test
    public void test04(){
        Stream<Integer> stream = Stream.of(1, 2, 3);
        Stream<int[]> map = stream.map(int[]::new);
    }
}
