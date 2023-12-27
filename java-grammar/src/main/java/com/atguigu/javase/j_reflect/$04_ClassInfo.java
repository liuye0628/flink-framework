package com.atguigu.javase.j_reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            //修饰符,数据类型,属性名
            int modifiers = field.getModifiers();
            System.out.println("属性的修饰符: "+Modifier.toString(modifiers));
            String name1 = field.getName();
            System.out.println("属性名:"+name1);
            Class<?> type = field.getType();
            System.out.println("属性的数据类型:"+type);
        }
        System.out.println("-----------------");
        /*
        (7)构造器们
         */
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            //修饰符,构造器名称,构造器形参列表,抛出异常列表
            int modifiers = constructor.getModifiers();
            System.out.println("构造器的修饰符: "+Modifier.toString(modifiers));
            String name1 = constructor.getName();
            System.out.println("构造器名: "+ name1);
            //形参列表
            System.out.println("形参列表: ");
            Class[] parameterTypes = constructor.getParameterTypes();
            for (Class parameterType : parameterTypes) {
                System.out.println(parameterType);
            }
            //异常列表
            System.out.println("异常列表:");
            Class[] exceptionTypes = constructor.getExceptionTypes();
            for (Class exceptionType : exceptionTypes) {
                System.out.println(exceptionType);
            }
        }
        System.out.println("--------------------");
        /*
        (8)方法们
         */
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            //修饰符,返回值类型,方法名,形参列表,异常列表
            int modifiers = method.getModifiers();
            System.out.println("方法的修饰符: "+Modifier.toString(modifiers));
            Class<?> returnType = method.getReturnType();
            System.out.println("返回值类型: "+returnType);
            String name1 = method.getName();
            System.out.println("方法名: "+name1);
            //形参列表
            System.out.println("形参列表: ");
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println(parameterType);
            }
            //异常列表
            System.out.println("异常列表: ");
            Class<?>[] exceptionTypes = method.getExceptionTypes();
            for (Class<?> exceptionType : exceptionTypes) {
                System.out.println(exceptionType);
            }
        }
    }

}
