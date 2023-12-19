package com.atguigu.javase.g_io;

import org.junit.Test;

import java.io.*;

/**
 * 缓冲流,也叫高效流,按照数据类型分类
 * · 字节缓冲流: BufferedInputStream BufferedOutputStream
 * · 字符缓冲流: BufferedReader BufferedWriter
 * 缓冲流的基本原理:是在创建流对象时,会创建一个内置的默认大小为8k的缓冲区数组,通过缓冲区读写,减少系统IO次数,从而提高读写的效率
 */
public class $08_BufferedStream {

    /**
     * 字节缓冲流
     * 1.构造方法:
     * · public BufferedInputStream(InputStream in): 创建一个新的缓冲输入流
     * · public BufferedOutputStream(OutputStream out): 创建一个新的缓冲输出流
     */
    public void test01() throws Exception{
        //创建字节缓冲输入流
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("stream_demo.txt"));
        //创建字节缓冲输出流
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("stream_demo.txt"));
    }

    /**
     * 字节缓冲流
     * 2.效率测试:一次读/写一个字节
     */
    @Test
    public void test02() throws Exception{
        //记录开始时间
        long start = System.currentTimeMillis();
        //创建流对象
        FileInputStream fis = new FileInputStream("stream_demo.txt");
        FileOutputStream fos = new FileOutputStream("stream_demo_test01.txt");
        //读写数据
        int b;
        while((b = fis.read())!=-1){
            fos.write(b);
        }
        fos.close();
        fis.close();
        //记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("普通流复制时间:"+(end - start)+"毫秒");//18毫秒
    }


    /**
     * 字节缓冲流
     * 2.效率测试:使用缓冲流
     */
    @Test
    public void test03() throws Exception{
        //记录开始时间
        long start = System.currentTimeMillis();
        //创建流对象
        BufferedInputStream bis =new BufferedInputStream(new FileInputStream("stream_demo.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("stream_demo_test02.txt"));
        //读写数据
        int b;
        while((b = bis.read())!=-1){
            bos.write(b);
        }
        bos.close();
        bis.close();
        //记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("缓冲复制时间:"+(end - start)+"毫秒");//2毫秒
    }


    /**
     * 字节缓冲流
     * 2.效率测试:一次读写一个字节数组
     */
    @Test
    public void test04() throws Exception{
        //记录开始时间
        long start = System.currentTimeMillis();
        //创建流对象
        BufferedInputStream bis =new BufferedInputStream(new FileInputStream("stream_demo.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("stream_demo_test03.txt"));
        //读写数据
        int len;
        byte[] bytes = new byte[8 * 1024];
        while((len = bis.read(bytes))!=-1){
            bos.write(bytes,0,len);
        }
        bos.close();
        bis.close();
        //记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("缓冲流使用数组复制时间:"+(end - start)+"毫秒");//2毫秒
    }


    /**
     * 字符缓冲流
     * 1.构造方法:
     * · public BufferedReader(Reader in): 创建一个新的缓冲输入流
     * · public BufferedWriter(writer out): 创建一个新的缓冲输出流
     */
    public void test05() throws Exception{
        //创建字符缓冲输入流
        BufferedReader br = new BufferedReader(new FileReader("reader.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("reader.txt"));
    }

    /**
     * 字符缓冲流
     * 2.特有方法
     * 字符缓冲流的基本方法与普通字符流调用方式一致,不再阐述,我们来看它们具备的特有方法
     * · BufferedReader: public String readLine(): 读一行文字
     * · BufferedWriter: public void newLine(): 写一行行分隔符,由系统属性定义符号
     * @throws Exception
     */
    @Test
    public void test06() throws Exception{
        /*
        readLine()方法
         */
        //创建流对象
        BufferedReader br = new BufferedReader(new FileReader("reader_demo.txt"));
        //定义字符串,保存读取的一行文字
        String line = null;
        //循环读取,读取到最后返回null
        while ((line = br.readLine())!=null){
            System.out.println(line);
            System.out.println("---------");
        }
        //释放资源
        br.close();

        /*
        newLine()方法
         */
        //创建流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("reader_demo.txt"));
        //写出数据
        bw.write("今天");
        //写出换行
        bw.newLine();
        bw.write("星期");
        bw.newLine();
        bw.write("二");
        bw.close();

    }

}
