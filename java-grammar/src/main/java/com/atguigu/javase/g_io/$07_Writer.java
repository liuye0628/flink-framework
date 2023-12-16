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

    /**
     * 2.写出数据
     * write(int b): 写出字符,每次可以写出一个字符数据
     *      注意:①虽然参数为int类型四个字节,但是只会保留一个字符的信息写出
     *          ②未调用close方法,数据只是保存到了缓冲区,并未写出到文件中
     * write(char[] cbuf),write(char[] cbuf,int off, int len): 写出字符数组,每次写出字符数组中的数据,用法类似FileOutputStream
     * write(String str),write(String str, int off, int len): 每次可以写出字符串中的数据
     */
    @Test
    public void test02() throws Exception{
        /*
        写出字符
         */
        //使用文件名称创建对象
        FileWriter fw = new FileWriter("reader_demo.txt");
        fw.write(97);//写出第一个字符
        fw.write('b');//写出第二个字符
        fw.write('c');//写出第三个字符
        fw.write(30000);//写出第四个字符,中文编码表中30000对应一个数字

        /*
        写出字符数组(字符串)
         */
        char[] chars = "今天星期六".toCharArray();//字符串转换为字符数组
        fw.write(chars);//写出字符数组
        fw.write(chars,1,2);//写出由索引1开始,两个字节
        /*
        续写与换行:类似于FileOutputStream
         */
        /*
        注意:关闭资源时,与FileOutputStream不同,如果不关闭,数据只是保存在缓冲区,并未保存在文件里
         */
        fw.close();

    }

    /**
     * 关闭与刷新:
     * 因为内置缓冲区的原因,如果不关闭输出流,无法写出字符到文件中,但是关闭的流对象,是无法继续写出数据的,如果我们即想写出数据,又想继续使用流,就需要flush方法了
     * · flush: 刷新缓冲区,流对象可以继续使用,字符流默认缓冲区为8k的字符数组
     * · close: 先刷新缓冲区,然后通知系统释放资源,流对象不可以再被使用了
     */
    @Test
    public void test03() throws Exception{
        //使用文件名称创建流对象
        FileWriter fw = new FileWriter("reader_demo.txt");
        /*
        写出数据,通过flush
         */
        fw.write('刷');//写出第一个字符
        fw.flush();
        fw.write('新');//继续写出第二个字符,写出成功

        /*
        写出数据,通过close
         */
        fw.write('关');
        fw.close();
        fw.write('闭');//继续写出第二个字符,报错:java.io.IOException: Stream closed
        fw.close();
        //注意:即便是flush方法写出了数据,操作的最后还是要调用close方法,释放系统资源

    }
}
