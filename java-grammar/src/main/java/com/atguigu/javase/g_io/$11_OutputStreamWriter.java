package com.atguigu.javase.g_io;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * 转换流java.io.OutputStreamWriter,是Writer的子类,是从字符流到字节流的桥梁,使用指定的字符集将字符编码为字节,它的字符集可以由名称指定
 * 也可以接受平台的默认字符集
 */
public class $11_OutputStreamWriter {

    /**
     * 1.构造方法
     * · OutputStreamWriter(OutputStream in): 创建一个使用默认字符集的字符流
     * · OutputStreamWriter(OutputStream in,String charsetName): 创建一个指定字符集的字符流
     */
    public void test01() throws Exception{
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("io_demo.txt"));
        OutputStreamWriter osw1 = new OutputStreamWriter(new FileOutputStream("io_demo.txt"),"GBK");
    }

    /**
     * 2.指定编码写出
     * @throws Exception
     */
    @Test
    public void test02() throws Exception{
        //创建流对象,默认UTF-8编码
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("io_demo.txt"));
        //写出数据
        osw.write("你好");//保存为6个字节
        osw.close();

        //创建流对象,指定GBK编码
        //OutputStreamWriter osw2 = new OutputStreamWriter(new FileOutputStream("io_demo.txt"), "GBK");
        //写出数据
        //osw2.write("你好");//保存为4个字节
        //osw2.close();

    }
}
