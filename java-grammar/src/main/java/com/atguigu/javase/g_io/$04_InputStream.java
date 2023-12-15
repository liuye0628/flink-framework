package com.atguigu.javase.g_io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 字节流:字节输入流
 * java.io.InputStream抽象类是表示字节输入流所有类的超类,可以读取字节信息到内存中,它定义了字节输入流的基本共性功能方法
 * · public void close(): 关闭此输入流并释放与此流相关联的任何系统资源
 * · public abstract int read(): 从输入流读取数据的下一个字节
 * · public int read(byte[] b): 从输入流中选取一些字节数,并将它们存储到字节数组b中
 * 注意:close方法,当完成流的操作时,必须调用此方法,释放系统资源
 */
public class $04_InputStream {

    /*
    1.构造方法
    · FileInputStream(File file): 通过打开与实际文件的连接来创建一个FileInputStream,该文件由文件系统的File对象file命名
    · FileInputStream(String name): 通过打开与实际文件的连接来创建一个FileInputStream,该文件由文件系统路径名name命名
    当你创建一个流对象时,必须创建一个文件路径,,该路径下,如果没有该文件,会抛出FileNotFoundException
     */
    @Test
    public void test01() throws FileNotFoundException {
        //使用File对象创建流对象
        File file = new File("stream_demo.txt");
        FileInputStream fis = new FileInputStream(file);
        //使用文件名称创建流对象
        FileInputStream fis1 = new FileInputStream("stream_demo.txt");
    }

    /**
     * 2.读取字节数据
     * read():读取字节,每次可以读取一个字节的数据,提升为int类型,读取到文件末尾,返回-1
     *  ①虽然读取了一个字节,但是会自动提升为int类型
     *  ②流操作关闭时,必须释放系统资源,调用close()方法,千万记得
     * read(byte[] b),每次读取b的长度个字节到数组中,返回读取到的有效的字节个数,读取到末尾时,返回-1
     */
    @Test
    public void test02() throws IOException {
        //使用文件名称创建流对象
        FileInputStream fis = new FileInputStream("stream_demo.txt");
//        int read = fis.read();
//        System.out.println((char)read);
//        read = fis.read();
//        System.out.println((char)read);
//        read = fis.read();
//        System.out.println((char)read);
//        read = fis.read();
//        System.out.println((char)read);
//        read = fis.read();
//        System.out.println((char)read);//读取到-1,返回-1
        /**
         * 1.读取字节
         */
        //定义变量 保存数据
        int read;
        //循环读取
        while ((read = fis.read()) != -1) {
            System.out.println((char) read);
        }
        fis.close();

        /**
         * 2.使用字节数组读取
         * 使用数组读取,每次读取多个字节,减少了系统间的IO操作次数,从而提高了读写的效率,建议开发中读取
         */
        //使用文件名称创建流对象
        FileInputStream fis1 = new FileInputStream("stream_demo.txt");
        //定义变量,作为有效个数
        int len;
        //定义字节数组,作为装字节数据的容器
        byte[] b = new byte[2];
        //循环读取
        while((len = fis1.read(b))!=-1){
            //每次读取后,把数组的有效字节部分,变成字符串打印
            System.out.println(new String(b,0,len));//len每次读取到的有效字节个数
        }
        //关闭资源
        fis1.close();

    }
}
