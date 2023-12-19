package com.atguigu.javase.g_io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 需求:将GBK编码的文本文件,转换为UDF-8编码的文本文件
 * 分析: 1.指定GBK编码的转换流,读取文本文件
 *      2.使用UTF-8编码的转换流,写出文本文件
 */
public class $12_TransDemo {
    public static void main(String[] args) throws Exception{
        InputStreamReader isr = new InputStreamReader(new FileInputStream("file_gbk.txt"),"GBK");//转换输入流,使用GBK编码
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("file_utf8.txt"));//转换输出流,默认utf-8编码

        //读写数据
        char[] cbuf = new char[1024];//定义数组
        int len;//定义长度
        while((len = isr.read(cbuf))!=-1){//循环读取
            osw.write(cbuf,0,len);//循环写出
        }
        //释放资源
        osw.close();;
        isr.close();
    }
}
