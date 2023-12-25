package com.atguigu.javase.j_reflect;

/**
 * 类加载器:类的加载通过类加载器完成
 * 1.类加载器分为:
 * ①引导类加载器(Bootstrap ClassLoader),又称为根类加载器
 *  ·它负责加载jre/rt.jar核心库
 *  ·它本身不是Java代码实现的,也不是ClassLoader的子类,获取它的对象时往往返回null
 * ②扩展类加载器(Extension ClassLoader):
 *  ·它负责加载jre/lib/ext扩展库
 *  ·它是ClassLoader的子类
 *  ·Java代码编写
 * ③应用程序类加载器(Application ClassLoader):
 *  ·也称为系统类加载器System Class Loader
 *  ·它负责加载项目的classpath路径下的类
 *  ·它是ClassLoader的子类
 *  ·Java代码编写
 * ④自定义类加载器:
 *  ·当你的程序需要加载"特定"目录下的类,可以自定义类加载器
 *  ·当你的程序的字节码文件需要加密时,那么往往会提供一个自定义类加载器对其进行解码
 *  ·tomcat服务器中会应用到
 *  ·Java编写
 * 2.Java系统类加载器中的双亲委派模式
 *      在JVM虚拟机中,如果一个类加载器收到类加载的请求,它首先不会自己去尝试加载这个类,而是把这个请求委派给父类加载器完成,每个类加载器都是如此,
 *  只有当父加载器在自己的搜索范围内找不到指定的类时(即ClassNotFoundException),子加载器才会自己尝试去加载
 *      也就是说,对于每个类加载器,只有父类(依次递归)找不到时,才自己加载,这就是双亲委派模式
 *      为什么需要双亲委派模型呢?
 *      ①这样可以避免重复加载,前面已经说明,当一个类要加载时,先看父类加载器是否加载,如果已经加载过,则无需再重复加载
 *      ②考虑到安全因素:假设我们使用一个第三方Jar包,该Jar包中自定义了一个java.lang.String类,它的功能和系统String的功能相同,但是加入
 *      了恶意代码,那么JVM会加载这个自定义的String类,从而在我们所有用到String类的地方都会执行该恶意代码,如果有双亲委派模型,自定义的String
 *      类是不会被加载的,因为最顶层的类加载器会首先加载系统的java.lang.String类,而不会加载自定义的String类,防止了恶意代码的注入
 * 3.获取类加载器的方式:
 *  ·获取当前类的加载器: ClassLoader classLoader = Demo.class.getClassLoader();
 *  ·获取当前线程上下文类加载器: Classloader contextClassLoader = Thread.currentThread().getContextClassLoader();
 *  ·获取系统类加载器: ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader()
 */
public class $02_ClassLoader {
    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());
    }
}
