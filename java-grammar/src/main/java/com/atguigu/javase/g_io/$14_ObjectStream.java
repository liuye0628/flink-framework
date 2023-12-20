package com.atguigu.javase.g_io;

import org.junit.Test;

import java.io.*;

/**
 * 对象流与序列化:
 * Java提供了一种对象序列化的机制,用字节序列可以表示一个对象,该字节序列包含该对象的类型和对象中存储的属性等信息,字节序列写出到文件中以后,相当于
 * 文件中持久保存了一个对象的信息
 * 反之,该字节序列还可以从文件中读取回来,重构对象,对它进行反序列化,对象的数据,对象的类型,和对象中存储的数据信息,都可以在内存中创建对象
 */
public class $14_ObjectStream {
    /*
    java.io.ObjectOutputStream类,将Java对象的原始数据类型写出到文件,实现对象的持久存储
     */

    /*
    1.构造方法
    · public ObjectOutputStream(OutputStream out): 创建一个指定OutputStream的ObjectOutputStream
     */
    public void test01() throws Exception{
        FileOutputStream fos = new FileOutputStream("io_demo.txt");
        ObjectOutputStream out = new ObjectOutputStream(fos);
    }


    /*
    2.序列化操作
    · 该类必须实现java.io.Serializable接口,Serializable是一个标记接口,不实现此接口的类将不会使任何状态序列化或反序列化,会抛出NotSerializableException
        · 如果对象的某个属性也是引用数据类型,那么如果该属性也要序列化的话,也要实现Serializable接口
    · 该类的所有属性必须是可序列化的,如果一个属性不需要可序列化,则该属性必须注明是瞬态的,使用transient关键字修饰(比如网络传输时,考虑安全因素,银行卡字段可以使用
    transient不进行序列化)
    · 静态变量的值不会序列化(静态变量的值不属于某个对象的数据,而是属于类的数据)
     */
    static class Employee implements java.io.Serializable{
        //加入序列版本号
        private static final long serialiVersionUID = 1L;
        public static String company = "xxx";
        public String name;
        public String address;
        public transient int age;//transient瞬态修饰成员,不会被序列化
        public void addressCheck(){
            System.out.println("Address check : "+ name +"--"+address);
        }
    }
    /*
    3.写出对象方法
    · public final void writeObject(Object obj): 将指定的对象写出
     */
    @Test
    public void test02(){
        Employee e = new Employee();
        e.name="zhangsan";
        e.address="shenzhen";
        e.age=26;
        try {
            //创建序列化流对象
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.txt"));
            //写出对象
            out.writeObject(e);
            //释放资源
            out.close();
            System.out.println("Serialized data is saved");//姓名,地址被序列化,年龄没有被序列化
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    /*
    java.io.ObjectInputStream:反序列化流,将之前使用ObjectOutputStream序列化的原始数据恢复为对象
     */

    /*
    1.构造方法
    · public ObjectInputStream(InputStream in): 创建一个指定InputStream的ObjectInputStream
     */


    /*
    2.反序列化操作一:
    如果能找到一个对象的class文件,我们可以进行反序列化操作,调用ObjectInputStream读取对象的方法
    · public final Object readObject(): 读取一个对象
    对于JVM可以反序列化对象,它必须是能够找到class文件的类,如果找不到该类的class文件,则抛出一个ClassNotFoundException异常
     */
    @Test
    public void test03(){
        Employee e = null;
        //创建反序列化流
        try {
            FileInputStream fileIn = new FileInputStream("employee.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            //读取一个对象
             e = (Employee) in.readObject();
             //释放资源
            in.close();
            fileIn.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        //无异常,直接打印输出
        System.out.println("Name:" + e.name);
        System.out.println("Address:"+e.address);
        System.out.println("age: "+e.age);
    }

    /*
    3.反序列化操作二:
    当JVM反序列化对象时,能找到class文件,但是class文件在序列化对象后发生了修改,那么反序列化操作也会失败,抛出一个InvalidClassException异常
    原因如下:
        · 该类的序列版本号与从流中读取的类描述符的版本号不匹配
        · 该类包含未知数据类型
    Serializable接口给需要序列化的类,提供了一个序列版本号,SerialversionUID该版本号的目的在于验证序列化的对象和对应类是否版本匹配
     */
}
