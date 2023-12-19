package com.atguigu.javase.g_io;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * 转换流java.io.InputStreamReader,是Reader的子类,是从字节流到字符流的桥梁,它读取字节,并使用指定的字符集将其解码为字符,它的字符集
 * 可以由名称指定,也可以接受平台的默认字符集
 */
public class $10_InputStreamReader {

    /**
     * 1.构造方法:
     * · InputStreamReader(InputStream in): 创建一个使用默认字符集的字符流
     * · InputStreamReader(InputStream in, String charsetName): 创建一个指定字符集的字符流
     */
    @Test
    public void test01() throws FileNotFoundException, UnsupportedEncodingException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("io_demo.txt"));
        InputStreamReader isr1 = new InputStreamReader(new FileInputStream("io_demo.txt"),"GBK");
    }

    /**
     * 2.指定编码读取
     */
    @Test
    public void test02() throws Exception{
        //1.创建流对象,默认UTF-8编码
        InputStreamReader isr = new InputStreamReader(new FileInputStream("io_demo.txt"));
        //2.创建流对象,默认GBK编码
        InputStreamReader isr2 = new InputStreamReader(new FileInputStream("io_demo.txt"), "GBK");
        //3.定义变量,保存字符
        int read;
        //使用GBK编码字符流读取,乱码
        while((read = isr2.read())!=-1){
            System.out.println((char)read);
        }
        isr2.close();
        //使用默认编码字符流读取,正常解析
        while((read = isr.read())!=-1){
            System.out.println((char)read);
        }
        isr.close();
    }
}
