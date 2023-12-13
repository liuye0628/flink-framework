package com.atguigu.javase.g_io;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 字节流:字节输出流
 *      一切文本数据(文件,图片,视频等)在存储时,都是以二进制数字的形式保存,都一个一个的字节,那么传输时一样如此,所以字节流可以传输任意文件数据
 *      在操作流的时候,我们要时刻明确,无论使用什么样的流对象,底层传输的始终为二进制数据
 * java.io.OutputStream抽象类是表示字节输出流的所有类的超类,将指定的字节信息写出到目的地,它定义了字节输出流的基本共性功能方法
 * · public void close(): 关闭此输出流并释放与此流相关联的任何系统资源
 * · public void flush(): 刷新此输出流并强制任何缓冲的输出字节被写出
 * · public void write(byte[] b): 将b.length字节从指定的字节数组写入此输出流
 * · public void write(byte[] b, int off, int len): 从指定的字节数组写入len字节,从偏移量off开始输出到此输出流
 * · public abstract void write(int b): 将指定的字节写入此输出流
 * 注意:close方法,当完成流的操作时,必须调用此方法,释放系统资源
 *
 */
public class $03_OutputStream {

    /*
    OutputStream有很多子类
    以java.io.FileOutputStream为例,此类为文件输出流,用于将数据写出到文件
     */


    /**
     * 1.构造方法
     * · public FileOutputStream(File file):创建文件输出流以写入由指定的File对象表示的文件
     * · public FileOutputStream(String name): 创建文件输出流以指定的名称写入文件
     * 当你创建一个流对象时,必须传入一个文件路径,该路径下,如果没有这个文件,会创建该文件,如果有这个文件,会清空这个文件的数据
     */
    @Test
    public void test01() throws FileNotFoundException {
        //使用File对象创建流对象
        File file = new File("stream_demo.txt");
        FileOutputStream fos = new FileOutputStream(file);
        //使用文件名称来创建流对象
        FileOutputStream fos1 = new FileOutputStream("stream_demo.txt");
    }

    /**
     * 2.写出字节数据(不进行追加续写)
     */
    @Test
    public void test02() throws IOException {
        //使用文件名称来创建流对象
        FileOutputStream fos = new FileOutputStream("stream_demo.txt");
        /*
        写出字节
         */
        fos.write(97);//写出第1个字节
        fos.write(98);//写出第2个字节
        fos.write(99);//写出第3个字节

        /*
        写出字节数组
         */
        byte[] bytes = "hello world".getBytes();//字符串转换为字节数组
        fos.write(bytes);//写出字节数组数据

        /*
        写出指定长度字节数组
         */
        fos.write(bytes,2,2);//写出从索引2开始,2个字节,索引2是l,两个字节也就是ll


        //关闭资源
        fos.close();
    }

    /**
     * 3.数据追加续写
     * 根据test02,发现每次程序运行,创建输出流对象,都会清空目标文件中的数据,如何保留目标文件中数据,还能继续添加新数据呢
     * · public FileOutputStream(File file,boolean append):创建文件输出流以写入由指定的File对象表示的文件
     * · public FileOutputStream(String name,boolean append):创建文件输出流以指定的名称写入文件
     * 这两个构造方法,参数中都需要传入一个boolean类型的值,true表示追加数据,false表示清空原有数据,这样创建的输出流对象,就可以指定是否追加续写了
     */
    @Test
    public void test03() throws IOException {
        //使用文件名称来创建流对象
        FileOutputStream fos = new FileOutputStream("stream_demo.txt",true);

        /*
        写出字节数组
         */
        byte[] bytes = "hello world".getBytes();//字符串转换为字节数组
        fos.write(bytes);//写出字节数组数据

        /*
        写出指定长度字节数组
         */
        //fos.write(bytes,2,2);//写出从索引2开始,2个字节,索引2是l,两个字节也就是ll


        //关闭资源
        fos.close();
    }


    /**
     * 4.写出换行
     *  ·回车符\r和换行符\n
     *      ·回车符:回到一行的开头(return)
     *      ·换行符:下一行(newline)
     *  ·系统中的换行
     *      ·Windows系统中,每行结尾是回车+换行 即\r\n;
     *      ·Unix系统中,每行的结尾只有换行 即\n
     *      ·Mac系统中,每行结尾是回车 即\r 从Mac OS x开始与Linux统一
     */
    @Test
    public void test04() throws IOException {
        //使用文件名称来创建流对象
        FileOutputStream fos = new FileOutputStream("stream_demo.txt");
        //定义字节数组
        byte[] words = {97,98,99,100};
        for (int i = 0; i < words.length; i++) {
            fos.write(words[i]);//写出一个字节
            fos.write("\r\n".getBytes());//写出一个换行,换行符号转成数组写出
        }
        //关闭资源
        fos.close();

    }
}
