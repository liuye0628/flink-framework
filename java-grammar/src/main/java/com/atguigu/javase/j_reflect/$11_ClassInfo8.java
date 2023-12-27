package com.atguigu.javase.j_reflect;

import java.lang.reflect.Array;

/**
 * 反射的应用:动态创建和操作任意类型的数组
 * 在java.lang.reflect包下还提供了一个Array类,Array对象可以代表所有的数组,程序可以通过使用Array类来动态的创建数组,操作数组元素等
 * · public static Object newInstance(Class<?> componentType,int...dimensions): 创建一个具有指定的组件类型和维度的新数组
 * · public static void setXxx(Object array,int index, xxx value): 将array数组中[index]元素的值修改为value,此处的Xxx对应8种基本数据
 * 类型,如果该属性的类型是引用数据类型,则直接使用set(Object array, int index, Object value)方法
 * · public static xxx getXxx(Object array,int index, xxx value): 将array数组中[index]元素的值返回.此处的Xxx对应8种基本数据类型,
 * 如果该属性的类型是引用数据类型,则直接使用get(Object array,int index)方法
 */
public class $11_ClassInfo8 {
    public static void main(String[] args) {
        Object arr = Array.newInstance(String.class, 5);
        Array.set(arr,0,"星期三");
        Array.set(arr,1,"星期四");
        System.out.println(Array.get(arr,0));
        System.out.println(Array.get(arr,1));
        System.out.println(Array.get(arr,2));
    }
}
