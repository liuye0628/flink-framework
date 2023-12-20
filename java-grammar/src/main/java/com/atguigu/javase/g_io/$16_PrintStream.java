package com.atguigu.javase.g_io;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.*;

/**
 * 打印流PrintStream与PrintWriter
 * 打印流只有输出没有输入
 */
public class $16_PrintStream {
    /*
    1.构造方法
    · public PrintStream(String FileName): 使用指定的文件名创建一个新的字节打印流
    · public PrintWriter(String FileName): 使用指定的文件名创建一个新的字符打印流
    · PrintWriter(OutputStream out,boolean autoFlush): 基于字符输出流创建一个自动刷新的字符打印流
     */
    public void test01() throws Exception{
        PrintStream ps = new PrintStream("ps.txt");
        PrintWriter pw = new PrintWriter("pw.txt");
        PrintWriter pw2 = new PrintWriter(new FileOutputStream("pw2.txt"), true);
    }

    /*
    2.打印流输出
     */
    @Test
    public void test02(){
        PrintStream ps = null;
        PrintWriter pw = null;
        try {
            ps = new PrintStream("ps.txt");
            ps.write(97);
            ps.print('b');
            ps.println("c");
            ps.close();
            pw = new PrintWriter("pw.txt");
            pw.write("aa");
            pw.print("bb");
            pw.println("cc");
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {//释放资源
        }
    }

    /*
    3.标准输入/输出流
    System类中有三个属性字段:
    ----------------------------------------------------
    Modifier and Type     |       Field and Description
    static PrintStream    |       err The "standard" error output stream
    static InputStream    |       in The "standard" input Stream
    static PrintStream    |       out The "standard" output stream
    ----------------------------------------------------
    System.in 标准输入流,本质是一个字节输入流,默认接受键盘录入的数据(不要用Junit单元测试,键盘输入)
    System.out 标准输出流,本质是一个字节输出流,默认输出数据到控制台
    既然是流对象,我们就可以玩一个"小把戏",改变标准输出流的流向
     */
    @Test
    public void test03() throws Exception{
        //调用系统的打印流,控制台直接输出97
        System.out.println(97);
        //创建字节打印流,指定文件的名称
        PrintStream ps = new PrintStream("ps.txt");
        //设置系统的打印流流向,输出到"ps.txt"
        System.setOut(ps);
        System.out.println(97);
    }

    /*
    4.JDK1.7之后引入新try..catch
    语法格式:
    try(需要关闭的资源对象的声明){
        业务逻辑代码,可能发生异常的代码
    }catch(异常类型 e){
        处理异常代码
    }catch(异常类型 e){
        处理异常代码
    }
    ....
    它没有finally,也不需要程序员去关闭资源对象,无论是否发生异常,都会关闭资源对象
     */
    @Test
    public void test04(){
        try(
                FileInputStream fis = new FileInputStream("stream_demo.txt");
                InputStreamReader isr = new InputStreamReader(fis,"GBK");
                BufferedReader br = new BufferedReader(isr);

                FileOutputStream fos = new FileOutputStream("1.txt");
                OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
                BufferedWriter bw = new BufferedWriter(osw)

        ){
            String str;
            while((str=br.readLine())!=null){
                bw.write(str);
                bw.newLine();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * IOUtils工具类:是Apache出品的一个方便IO操作的工具类,简化了IO流的读,写,复制及关闭流操作(使用前需要导包)
     */
    public void test05() throws Exception{
        IOUtils.copy(new FileInputStream("ps.txt"),new FileOutputStream("pw.txt"));//复制文件
        IOUtils.write("hello world",new FileOutputStream("ps.txt"),"UTF-8");//写数据到文件
    }
}
