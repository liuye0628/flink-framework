package com.atguigu.javase.j_reflect;

import java.lang.reflect.Field;

/**
 * 反射的应用:操作任意类型的属性
 * (1)获取该类型的Class对象 Class clazz = Class.forName("com.atguigu.javase.j_reflect.C")
 * (2)获取属性对象 Field field = clazz.getDeclaredField("value")
 * (3)设置属性可访问 field.setAccessible(true)
 * (4)创建实例对象 如果操作的是非静态属性,需要创建实例对象 Object obj = clazz.newInstance();
 * (5)设置属性值 field.set(obj."chai")
 * (6)获取属性值 Object value = field.get(obj)
 * 如果操作静态变量,那么实例对象可以省略,用null表示
 */
public class $06_ClassInfo3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        //1.获取Employee的Class对象
        Class<?> clazz = Class.forName("com.atguigu.javase.h_java8newfeature.Employee");
        //2.获取属性对象,例如:id属性
        Field idField = clazz.getDeclaredField("id");
        //3.如果id是私有的等在当前类中不可访问access的,需要做如下操作
        idField.setAccessible(true);
        //4.创建实例对象,即创建Employee对象
        Object employee = clazz.newInstance();
        /*
        5.获取属性值
        以前: int 变量 = Employee对象.getId()
        现在: Object id属性对象.get(Employee对象)
         */
        Object value = idField.get(employee);
        System.out.println("id="+ value);
        /*
        6.设置属性值
        以前: Employee对象.setId(值)
        现在: id属性对象.set(Employee对象,值)
         */
        idField.set(employee,2);
        value = idField.get(employee);
        System.out.println("id="+value);
    }
}
