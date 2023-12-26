package com.atguigu.javase.j_reflect;

import org.junit.Test;

/**
 * java.lang.class类
 *      一.万物皆对象,每个类编译后生成的字节码文件,即class文件,在类加载后JVM会为每个class文件创建一个对象,也就是Class类的一个对象,这个Class对象封装了类在方法
 * 区内的数据信息,并且向Java程序员提供了访问方法区内的类数据信息的接口
 *      二.java反射机制是在运行状态中,对于任何一个类,都能够知道这个类的所有属性和方法,对于任意一个对象,都能够调用它的任意一个方法和属性,这种动态获取的信息以及动态调用对象
 * 的方法的功能称为Java语言的反射机制
 *      三.要想解剖一个类,必须先要获取该类的Class对象,所以Class对象是反射的根源
 *      四.获取Class对象的四种方式:
 *          ①类型名.class--->要求编译期间已知类型,所有的Java类型都可通过此方式获取Class对象
 *          ②对象.getClass()--->获取对象的运行时类型
 *          ③Class.forName(类型全名称)--->可以获取编译期间未知的类型
 *          ④ClassLoader的类加载器器对象.loadClass(类型全名称)--->可以用系统类加载对象或自定义加载器对象加载指定路径下的类型
 *
 *
 */
public class $03_ClassObject {
    @Test
    public void test01() throws ClassNotFoundException {
        Class<$03_ClassObject> c = $03_ClassObject.class;
        ClassLoader loader = c.getClassLoader();
        Class<?> c2 = loader.loadClass("com.atguigu.javase.j_reflect.C");
        Class<C> c3 = C.class;
        System.out.println(c2==c3);
    }
    @Test
    public void test02() throws ClassNotFoundException {
        Class<String> c2 = String.class;
        Class<? extends String> c1 = "".getClass();
        Class<?> c3 = Class.forName("java.lang.String");
        System.out.println(c1 == c2);
        System.out.println(c1 == c3);
    }
}
