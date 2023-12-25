package com.atguigu.javase.j_reflect;
/*
类加载:类在内存中的生命周期: 加载->使用->卸载
1.类的加载过程: 当程序主动使用某个类时,如果该类还未加载到内存里,系统会通过加载,链接,初始化三个步骤来对该类进行初始化,如果没有意外,JVM会
连续完成这三个步骤,所以有时也会把这三个步骤统称为类加载,主要分为三个阶段:
    ①加载:load,就是指将类型的class字节码数据读入内存
    ②链接:link
        ·验证:校验被加载的class文件的合法性,并且不会危害虚拟机的自身安全(文件格式验证,语义分析等)
        ·准备:为类变量分配内存(在方法区中),并设置初始值(0,null,false),为静态常量赋初始值(常量池中)
            比如: public static int sector = 3;类变量在此阶段会被设置初始值为0,而不是3
            public static final int number = 3;静态常量在此阶段会被设置为3
        ·解析:把字节码中的符号引用替换为对应的直接地址引用
            符号引用就是一组符号来描述目标,可以是任何字面量
            直接引用就是直接指向目标的指针,相对偏移量或一个间接定位到目标的句柄
    ③初始化:initialize
        ·为类的静态变量赋予正确的初始值,JVM负责对类进行初始化,主要对类变量进行初始化,类初始化执行的是(),该方法会执行1.类变量的显式赋值代码
        2.静态代码块中的代码,用于给类变量初始化值
 */
public class $01_ClassLoad extends Father{
    static{
        System.out.println("main方法所在的类(2)");//主方法所在的类会初始化
    }

    public static void main(String[] args) throws ClassNotFoundException {
        new A();//第一次使用A就是创建它的对象,会初始化A类
        B.test();//直接使用B类的静态成员会初始化B类
        Class<?> clazz = Class.forName("com.atguigu.javase.j_reflect.C");//通过反射会操作C类,会初始化C类
        System.out.println(D.NUM);//D类不会初始化,因为NUM是final的
        System.out.println(F.num);
        F.test();//F类不会初始化,E类会初始化,因为num和test()是在E类中声明的
        //G类不会初始化,此时还没有正式用的G类
        G[] arr = new G[5];//没有创建G的对象,创建的是准备用来装G对象的数组对象
        //G[]是一种新的类型,是数组类型,动态编译生成的一种新的类型
        //G[].class
    }
}


/**
 * 2.哪些操作会导致类的初始化?
 *  ①运行主方法所在的类,要先完成类的初始化,再执行main方法
 *  ②第一次使用某个类型就是在new它的对象,此时这个类没有初始化的话,先完成类初始化再完成实例初始化
 *  ③调用某个类的静态成员(类变量和类方法),此时这个类没有初始化的话,先完成类初始化
 *  ④子类初始化时,发现它的父类还没有初始化的话,那么先初始化父类
 *  ⑤通过反射操作某个类时,如果这个类没有初始化,也会导致该类先初始化
 * 3.哪些使用类的操作,但是不会导致类的初始化?
 *  ①使用某个类的静态的常量(static final)
 *  ②通过子类调用父类的静态变量,静态方法,只会导致父类初始化,不会导致子类初始化,即只有声明静态成员的类才会初始化
 *  ③用某个类型声明数组并创建数组对象时,不会导致这个类初始化
 */
class Father{
    static{
        System.out.println("main方法所在的类的父类(1)");//初始化子类时,会初始化父类
    }
}
class A{
    static{
        System.out.println("A类初始化");
    }
}
class B{
    static{
        System.out.println("B类初始化");
    }
    public static void test(){
        System.out.println("B类的静态方法");
    }
}
class C{
    static {
        System.out.println("C类初始化");
    }
}
class D{
    public static final int NUM = 10;
    static {
        System.out.println("D类的初始化");
    }
}
class E{
    static int num = 10;
    static{
        System.out.println("E父类的初始化");
    }
    public static void test(){
        System.out.println("父类的静态方法");
    }
}
class F extends E{
    static {
        System.out.println("F子类的初始化");
    }
}
class G{
    static {
        System.out.println("G类的初始化");
    }
}
