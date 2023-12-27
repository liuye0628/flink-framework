package com.atguigu.javase.j_reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射的应用:调用任意类型的方法
 * (1)获取该类型的Class对象 Class clazz = Class.forName("com.atguigu.javase.j_reflect.C")
 * (2)获取方法对象 Method method = clazz.getDeclaredMethod("login",String.class,String.class)
 * (3)创建实例对象 Object obj = clazz.newInstance();
 * (4)调用方法 Object result = method.invoke(obj,"chai",123)
 * 如果方法的权限修饰符修饰的范围不可见,也可以调用setAccessible(true)
 * 如果方法是静态方法,实例对象也可以省略,用null代替
 */
public class $07_ClassInfo4 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //1.获取Employee的Class对象
        Class<?> clazz = Class.forName("com.atguigu.javase.h_java8newfeature.Employee");
        /*
        2.获取方法对象
        在一个类中,唯一定位到一个方法,需要:(1)方法名 (2)形参列表,因为方法可能重载
        例如:void setName(String name)
         */
        Method method = clazz.getDeclaredMethod("setName", String.class);
        //3.创建实例对象
        Object employee = clazz.newInstance();
        /*
        4.调用方法
        以前: Employee对象.setName(值)
        现在: 方法对象.invoke(Employee对象,值)
         */
        method.invoke(employee,"张三");
        System.out.println(employee);
    }
}
