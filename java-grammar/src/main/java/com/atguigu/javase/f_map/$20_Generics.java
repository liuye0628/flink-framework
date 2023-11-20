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
    //public static void test(T t){} 类型变量T 不能用于静态成员上


}
/**
 * 自定义泛型类和泛型接口:
 * 1.声明泛型类: 语法格式
 * [修饰符] class 类名<类型变量列表> {
 *
 * }
 * ①<类型变量列表>:可以是一个或多个类型变量,一般都是使用单个的大小字母表示,例如:<T>,<k,V>等
 * ②当类或接口声明了<类型变量列表>时,其中的类型变量不能用于静态成员上
 *
 * 2.声明泛型接口:语法格式
 * [修饰符] interface 接口名<类型变量列表> [implements 父接口们]{
 *
 * }
 * 3.泛型类和接口的子类或实现类:
 * 泛型类和接口一样可以被继承和实现,一个类在继承父类或实现接口时分两种情况:
 *  ①子类或实现类明确泛型类的类型参数变量
 *  //定义实现类时,明确接口中声明的类型参数,此时实现类不再是泛型类
 *  public class GerInterfaceImal implements GerInterface<String>{
 *      ........
 *  }
 *  ②子类不明确泛型类的类型参数变量
 *  //定义实现类时,实现类不明确接口中声明的类型参数,实现类仍然是泛型类
 *  ag:ArrayList类实现了泛型接口,未明确泛型类型参数,依然是泛型类
 *  public class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable
 * 4.声明泛型类和接口
 *  ①在使用这种参数化的类或接口创建对象时,我们需要指定泛型变量的实际类型参数(必须是引用数据类型)
 *  ②指定泛型实参时,必须左右两边类型参数一致,jdk1.7后支持简写形式,右边类型参数可以省略
 *  ArrayList<String> list = new ArrayList<>();//省略右边泛型类型
 *  ③当使用参数化类型的类或接口,如果没有指定泛型,即为泛型擦除,相当于Object类型
 *  //类型擦除
 *  public class CircleComparator implements Comparator{
 *      @Override
 *      public int compare(Object o1, Object o2){
 *              ........
 *      }
 *  }
 *
 */

/**
 * 自定义泛型方法:使用泛型时,如果外界只关心某个方法,而不关心类其他的成员,那么可以只在该方法上声明泛型,方法泛型化,称为泛型方法
 *  语法格式:
 *  [修饰符] <类型变量列表> 返回值类型 方法名([形参列表])[throws 异常列表]{
 *      //...
 *  }
 *  ①<类型变量列表>:可以是一个或多个类型,一般都是使用单个的大写字母表示,例如:<T>,<K,V>等
 *  ②静态方法也可以单独泛型化,区别泛型类或接口中的静态方法(不能使用泛型类或接口定义的泛型变量)
 */
