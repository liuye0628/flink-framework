package com.atguigu.javase.j_reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 反射的应用:获取泛型父类信息
 * Type:
 * (1)Class
 * (2)ParameterizedType
 *      例如:Father<String,Integer>
 *          ArrayList<String>
 * (3)TypeVariable
 *      例如:T,U,E,K,V
 * (4)wildcardType
 *      例如:ArrayList<?>
 *          ArrayList<? super 下限>
 *          ArrayList<? extends 上限>
 * (5)GenericArrayType
 *      例如:T[]
 */
public class $08_ClassInfo5 {
    public static void main(String[] args) throws ClassNotFoundException {
        /*
        需求:在运行时,获取Son类型的泛型父类的泛型实参<String,Integer>
         */
        //1.先获取class对象
        Class<?> clazz = Class.forName("com.atguigu.javase.j_reflect.Son");
        /*
        2.获取泛型父类
        Class sc = clazz.getSuperClass();
        getSuperClass()只能得到父类名,无法得到父类的泛型实参列表
         */
        Type type = clazz.getGenericSuperclass();
        //Father2<String,Integer>属于ParameterizedType
        ParameterizedType pt = (ParameterizedType) type;
        /*
        3.获取泛型父类的泛型实参列表
         */
        Type[] typeArray = pt.getActualTypeArguments();
        for (Type type1 : typeArray) {
            System.out.println(type1);
        }

    }
}
/*
泛型形参:<T,U>
 */
class Father2<T,U>{

}
/*
泛型实参:<String,Integer>
 */
class Son extends Father2<String,Integer>{

}

