package com.atguigu.javase.j_reflect;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 反射的应用:获取类型的详细信息
 * 可以获取:包,修饰符,类型名,父类(包括泛型父类),父接口(包括泛型父接口),成员(属性,构造器,方法),注解(类上的,方法上的,属性上的)
 */
public class $04_ClassInfo {
    //1.先得到某个类型的Class对象
    Class clazz =String.class;
    //private String value;

    /**
     * 获取类信息
     */
    @Test
    public void test01() throws NoSuchFieldException {
        //(1)获取包对象,即所有java的包,都是package的对象
        Package pkg = clazz.getPackage();
        System.out.println("包名:"+pkg.getName());
        /*
        (2)获取修饰符
        其实修饰符是Modifier,里面有很多常量值
        Ox是十六进制
        PUBLIC                  = 0x00000001; 1 1
        PRIVATE                 = 0x00000002; 2 10
        PROTECTED               = 0x00000004; 4 100
        STATIC                  = 0x00000008; 8 1000
        FINAL                   = 0x00000010; 16 10000
        ...
        设计的理念,就是用二进制的某一位是1,来代表一种修饰符,整个二进制中只有一位是1,其余都是0
        mod = 17  0x00000011
        if((mod & PUBLIC)!=0) 说明修饰符中有public
        if((mod & FINAL)!=0) 说明修饰符中有final
         */
        int mod = clazz.getModifiers();
        System.out.println(Modifier.toString(mod));
        //(3)类型名
        String name = clazz.getName();
        System.out.println(name);
        //(4)父类,父类也有父类对应的class对象
        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);
        //(5)父接口们
        Class[] interfaces = clazz.getInterfaces();
        for (Class aClass : interfaces) {
            System.out.println(aClass);
        }
        /*
        (6)类的属性,你声明的一个属性,它是Field的对象
        Field clazz.getField(name) 根据属性名获取一个属性对象,但是只能得到公共的
        Field[] clazz.getFields() 获取所有公共的属性
        Field clazz.getDeclaredField(name) 根据属性名获取一个属性对象,可以获取已声明的
        Field[] clazz.getDeclaredFields() 获取所有已声明的属性
         */
        Field valueField = clazz.getDeclaredField("value");
        System.out.println("valueField= "+valueField);
    }

}
