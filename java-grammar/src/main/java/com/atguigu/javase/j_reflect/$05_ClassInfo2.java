package com.atguigu.javase.j_reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * 反射的应用:创建任意引用类型的对象
 * 两种方式:
 *  ①直接通过Class对象来实例化(要求必须有无参构造)
 *  ②通过获取构造器对象来进行实例化
 */
public class $05_ClassInfo2 {
    /**
     * 方式一的步骤:
     * (1)获取该类型的Class对象
     * (2)创建对象
     */
    @Test
    public void test01() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName("com.atguigu.javase.j_reflect.C");
        Object o = clazz.newInstance();
        System.out.println(o);
    }

    /**
     * 方式二的步骤:
     * (1)获取该类型的Class对象
     * (2)获取构造器对象
     * (3)创建对象
     * 如果构造器的权限修饰符修饰的范围不可见,也可以调用setAccessible(true)
     */
    @Test
    public void test02() throws Exception{
        //获取Class对象
        Class<?> clazz = Class.forName("com.atguigu.javase.j_reflect.C");
        //获取构造器对象
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        //创建实例对象
        Object o = constructor.newInstance();
        System.out.println(o);
    }
}
