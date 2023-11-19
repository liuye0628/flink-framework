package com.atguigu.javase.f_map;

/**
 * jdk 1.5设计了泛型的概念,泛型即为"类型参数",这个类型参数在声明它的类,接口或方法中,代表未知的通用的类型
 * <数据类型>这种语法形式就叫泛型,其中数据类型只能是引用数据类型
 * ·TypeVariable:类型变量,例如ArrayList<E>中的E,Map<K,V>中的K,V
 * ·ParameterizedType:参数化类型,例如:Comparator<T>,Comparator<String>
 * ·GenericArrayType:泛化的数据类型,即T[]
 * ·WildcardType:通配符类型,例如:ComPARATOR <?>等
 * @param <T>
 */
//声明类和接口时,在类名或接口名后面声明类型变量,我们把这样的类或接口称为泛型类或泛型接口
public class $20_Generics<T> {

    //声明方法时,在修饰符与返回值类型之间声明类型变量,我们把声明(是声明不是单纯的使用)了类型变量的方法称为泛型方法
    public static <T> int a(){
        return 0;
    }


}
