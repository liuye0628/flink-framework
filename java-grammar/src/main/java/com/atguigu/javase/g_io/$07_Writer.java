package com.atguigu.javase.g_io;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;

/**
 * 字符输出流:Writer
 * java.io.Writer抽象类是表示用于写出字符流的所有类的超类,将指定的字符信息写出到目的地,它定义了字节输出流的基本共性方法
 * · void write(int c): 写入单个字符
 * · void write(char[] cbuf): 写入字符数组
 * · abstract void write(char[] cbuf,int off, int len): 写入字符数组的某一部分,off数组的开始索引,len写的字符个数
 * · void write(String str): 写入字符串
 * · void write(String str, int off, int len):写入字符串的某一部分,off字符串的开始索引,len写的字符个数
 * · void flush(): 刷新该流的缓冲
 * · void close(): 关闭此流,但要先刷新它
 */
public class $07_Writer {


    /**
     * 1.构造方法
     * · FileWriter(File file): 创建一个新的FileWriter,给定要读取的File对象
     * · FileWriter(String filename): 创建一个新的FileWriter,给定要读取的文件名称
     * 当你创建一个流对象时,必须传入一个文件路径,类似于FileOutputStream
     */
    @Test
    public void test01() throws Exception{
        //使用File对象创建流对象
        File file = new File("reader_demo.txt");
        FileWriter fw = new FileWriter(file);
        //使用文件名称来创建流对象
        FileWriter file1 = new FileWriter("reader_demo.txt");
    }
}
