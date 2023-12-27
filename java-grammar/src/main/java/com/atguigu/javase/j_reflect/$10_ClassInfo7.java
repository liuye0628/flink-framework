package com.atguigu.javase.j_reflect;

import java.util.Map;

/**
 * 反射的应用:获取内部类或外部类信息
 * · public Class<?>[] getClasses(): 返回所有公共内部类和内部接口,包括从超类继承的公共类和接口成员以及该类声明的公共类和接口成员
 * · public Class<?>[] getDeclaredClasses(): 返回Class对象的一个数组,这些对象反映声明为此Class对象所表示的类的成员的所有类和接口,
 * 包括该类所声明的公共,保护,默认(包)访问及私有类和接口,但不包括继承的类和接口
 * · public Class<?> getDeclaringClass(): 如果此Class对象所表示的类或接口是一个内部类或内部接口,则返回它的外部类或外部接口,否则返回null
 */
public class $10_ClassInfo7 {
    public static void main(String[] args) {
        Class<Map> clazz = Map.class;
        Class<?>[] inners = clazz.getDeclaredClasses();
        for (Class<?> inner : inners) {
            System.out.println(inner);
        }
        Class<Map.Entry> ec = Map.Entry.class;
        Class<?> outer = ec.getDeclaringClass();
        System.out.println(outer);
    }
}
