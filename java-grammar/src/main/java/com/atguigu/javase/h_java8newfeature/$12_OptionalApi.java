package com.atguigu.javase.h_java8newfeature;

import org.junit.Test;

import java.util.Locale;
import java.util.Optional;

/**
 * 背景:为了解决常见的空指针异常问题,Google公司著名的Guava项目引入了Optional类,Guava通过使用检查空值的方式来防止代码污染,它鼓励程序员写更干净的代码
 * 受到Google Guava的启发,Optional类已经成为Java8类库的一部分
 *
 * Optional实际上是个容器:它可以保存类型T的值,或者仅仅保存null
 */

public class $12_OptionalApi {


    /**
     * Optional对象创建
     * ·static Optional empty(): 用来创建一个空的Optional
     * ·static Optional of(T value): 用来创建一个非空的Optional
     * ·static Optional ofNullable(T value): 用来创建一个可能是空,也可能非空的Optional
     */
    @Test
    public void test01(){
        String str = "hello";
        Optional<String> opt = Optional.of(str);
        System.out.println(opt);
        String str1 = null;
        Optional<String> opt1 = Optional.ofNullable(str1);
        System.out.println(opt1);
    }


    /**
     * Optional对象取出
     * · T get():要求Optional容器必须非空 T get()与of(T value)使用是安全的
     * · T orElse(T other): 如果Optional容器中非空,就返回所包装值,如果为空,就用orElse(T other) other指定的默认值(备胎)代替,orElse(T other)与ofNullable(T value)配合使用
     * · T orElseGet(Supplier<? extends T> other) : 如果Optional容器中非空,就返回所包装值,如果为空,就用Supplier接口的Lambda表达式提供的值代替
     * · T orElseThrow(Supplier<? extends X> exceptionSupplier): 如果Optional容器中非空,就返回所包装值,如果为空,就抛出你指定的异常类型代替原来的NoSuchElementException
     */
    @Test
    public void test02(){
        String str = "hello";
        Optional<String> opt = Optional.of(str);
        String s = opt.get();
        System.out.println(s);
        String str1 = null;
        Optional<String> opt1 = Optional.ofNullable(str1);
        String s1 = opt1.orElse("word");
        System.out.println(s1);
        String s2 = opt1.orElseGet(() -> new String("hello world!"));
        System.out.println(s2);
        //String s3 = opt1.orElseThrow(() -> new RuntimeException("值不存在"));
        //System.out.println(s3);
        //判断是否是纯字母单词,如果是,转为大写,否则保持不变
        String str2 = "word";
        Optional<String> opt2 = Optional.ofNullable(str2);
        String result = opt2.filter(t -> t.matches("[a-zA-Z]+"))
                .map(t -> t.toUpperCase())
                .orElse(str2);
        System.out.println(result);

    }

    /**
     * Optional:其他方法
     * · boolean isPresent(): 判断Optional容器中的值是否存在
     * · void ifPresent(Consumer<? super T> consumer): 判断Optional容器中的值是否存在,如果存在,就对它进行Consumer指定的操作,如果不存在就不做
     * · Optional map(Function<? super T,? extends U> mapper): 判断Optional容器中的值是否存在,如果存在,就对他进行Function接口指定的操作,如果不存在就不做
     */
}
