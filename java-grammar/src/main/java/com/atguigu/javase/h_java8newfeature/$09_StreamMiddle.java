package com.atguigu.javase.h_java8newfeature;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * 多个中间操作可以连接起来形成一个流水线,除非流水线上触发终止操作,否则中间操作不会执行任何的处理!而在终止操作时一次性全部处理,称为"惰性取值"
 */
public class $09_StreamMiddle {

    /**
     * filter(Predicate p): 接收Lambda,从流中排除某些元素
     * Predicate 是函数式接口,抽象方法:boolean test(T t)
     */
    @Test
    public void test01(){
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);//创建Stream
        Stream<Integer> stream1 = stream.filter(t -> t % 2 == 0);//加工处理:过滤
        stream1.forEach(System.out::println);//终结操作:遍历

    }

    /**
     * distinct(): 筛选,通过流所生成元素的equals()去除重复元素
     */
    @Test
    public void test02(){
        Stream.of(1,2,3,4,1,2,3,4,5)
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * limit(long maxSize): 截断流,使其元素不超过给定数量
     */
    @Test
    public void test03(){
        Stream.of(1,2,3,4,1,2,3,4,5)
                .limit(3)
                .forEach(System.out::println);
    }

    /**
     * skip(long n):跳过元素,返回一个扔掉了前n个元素的流,若流中元素不足n个,则返回一个空流,与limit(n)互补
     */
    @Test
    public void test04(){
        Stream.of(1,2,3,4,1,2,3,4,5)
                .skip(3)
                .forEach(System.out::println);
    }

    /**
     * peek(Consumer action):接收Lambda,对流中的每个数据执行Lambda体操作
     */
    @Test
    public void test05(){
        long count = Stream.of(1, 2, 3, 4, 1, 2, 3, 4, 5)
                .peek(System.out::println)
                .count();
        System.out.println("count="+count);
    }

    /**
     * sorted() :产生一个新流,其中按自然顺序排序
     * sorted(Comparator com) :产生一个新流,其中按照比较器排序
     */
    @Test
    public void test06(){
        //需求:找到三个数最大的,前三名最大的,不重复
        Stream.of(1,23,44,55,55,77,23,33)
                .distinct()
                .sorted((t1,t2) -> Integer.compare(t2,t1))
                .limit(3)
                .forEach(System.out::println);
    }

    /**
     * map(Function f) : 接收一个函数作为参数,该元素会被映射到每个元素上,并将其映射成新的元素
     * mapToDouble(ToDoubleFunction f) : 接收一个函数作为参数,该函数会被应用到每个元素上,产生一个新的DoubleStream
     * mapToInt(ToIntFunction f) : 接收一个函数作为参数,该函数会被应用到每个元素上,产生一个新的IntStream
     * mapToLong(ToLongFunction f) : 接收一个函数作为参数,该函数会被应用到每个元素上,产生一个新的LongStream
     */
    @Test
    public void test07(){
        Stream.of("hello","world","Java")
                .map(word -> word.toUpperCase())
                .forEach(System.out::println);
    }

    /**
     * flatMap(Function f) : 接收一个函数作为参数,将流中的每个值都转换为另一个流,然后把所有的流连接成一个流
     */
    @Test
    public void test08(){
        Stream.of("hello","world","java")
                .flatMap(word -> Stream.of(word.split("|")))//输出单个字符
                .forEach(System.out::println);
    }
}
