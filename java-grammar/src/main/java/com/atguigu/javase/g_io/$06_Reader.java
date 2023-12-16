package com.atguigu.javase.g_io;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

/**
 * 字符流: 当使用字节流读取文本文件时,可能会有一个小问题,就是遇到中文字符时,可能不会显示完整的字符,那是因为一个中文字符可能占用多个字节存储,
 * 所以java提供一些字符流类,以字符为单位读写数据,专门用来处理文本文件
 * 注意:字符流只能操作文件,不能操作图片,视频等非文本文件,当我们单纯读或者写文件时,使用字符流,其他情况下使用字节流
 * 字符输入流:Reader
 * java.io.Reader 抽象类是表示用于读取字符流的的所有类的超类,可以读取字符信息到内存中,它定义了字符输入流的基本共性方法
 * · public void close(): 关闭此流并释放与此流相关联的任何系统资源
 * · public int read(): 从输入流读取字符
 * · public int read(char[] cbuf): 从输入流读取一些字符,并把他们存储到字符数组cbuf中
 */
public class $06_Reader {
    /**
     * java.io.FileReader类是读取字符文件常用类,构造时使用系统默认的字符编码和默认字节缓冲区
     * ①字符编码: 字节与字符的对应规则,windows中文编码默认是GBK编码表,eclipse中默认GBK,idea中默认UTF-8
     * ②字节缓冲区: 一个字节数组,用来临时存储字节数据
     */
    /**
     * 1.构造方法
     * · FileReader(File file): 创建一个新的FileReader,给定要读取的File对象
     * · FileReader(String filename): 创建一个新的FileReader,给定要读取的文件的名称
     */
    public void test01() throws FileNotFoundException {
        //使用File对象来创建流对象
        File file = new File("reader_demo.txt");
        FileReader fr = new FileReader(file);
        //使用文件名称来创建流对象
        File file1 = new File("reader_demo.txt");
    }


    /**
     * 2.读取字符数据
     * read(): 读取字符每次可以读取一个字符的数据,提升为int类型,读取到文件末尾,返回-1,循环读取
     * read(char[] cbuf): 使用字符数组读取,每次读取b个长度的字符到数组中,返回读取到的有效字符的个数,读取到末尾时,返回-1
     */
    @Test
    public void test02() throws Exception {
        /**
         * ①读取字符
         */
        //使用文件名创建流对象
        FileReader fr = new FileReader("reader_demo.txt");
        //定义变量,保存数据
        int b;
        //循环读取
        while((b = fr.read())!=-1){
            System.out.println((char)b);
        }
        //关闭资源
        fr.close();

        /**
         * ②使用字符数组读取
         */
        FileReader fr1 = new FileReader("reader_demo.txt");
        //定义变量,保存有效字符个数
        int len;
        //定义字符数组,作为装字符数据的容器
        char[] cbuf = new char[2];
        //循环读取
        while ((len = fr1.read(cbuf))!=-1){
            System.out.println(new String(cbuf,0,len));
        }
    }
}
