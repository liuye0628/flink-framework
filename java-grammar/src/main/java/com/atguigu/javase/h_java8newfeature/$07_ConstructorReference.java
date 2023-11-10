package com.atguigu.javase.h_java8newfeature;

import org.junit.Test;

import java.math.BigDecimal;
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
    @Test
    public void test03(){

    }
}
