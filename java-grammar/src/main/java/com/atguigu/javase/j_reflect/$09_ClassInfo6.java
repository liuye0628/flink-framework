package com.atguigu.javase.j_reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 反射的应用: 读取注解信息
 * 需求:获取MyClass类型上面配置的注解@MyAnnotation的value值
 */
public class $09_ClassInfo6 {
    public static void main(String[] args) {
        //读取注解
        //1.获取Class对象
        Class<MyClass> clazz = MyClass.class;
        //2.获取注解对象(指定注解对象)
        MyAnnotation my = clazz.getAnnotation(MyAnnotation.class);
        //3.获取配置参数值
        String value = my.value();
        System.out.println(value);
    }
}

//声明
@Retention(RetentionPolicy.RUNTIME) //说明这个注解可以保留到运行时
@Target(ElementType.TYPE) //说明这个注解只能用到类型上面,包括类,接口,枚举等
@interface MyAnnotation{
    //配置参数,如果只有一个配置参数,并且名称是value,在赋值时可以省略value=
    String value();
}
//使用注解
@MyAnnotation("/login")
class MyClass{

}
