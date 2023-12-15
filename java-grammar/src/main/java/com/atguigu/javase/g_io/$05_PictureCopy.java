package com.atguigu.javase.g_io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节流练习:图片复制
 */

public class $05_PictureCopy {
    public static void main(String[] args) throws IOException {
        //1.创建流对象
        //1.1 指定数据源
        FileInputStream fis = new FileInputStream("D:\\code\\IdeaProjects\\flink-framework\\java-grammar\\src\\main\\java\\com\\atguigu\\javase\\g_io\\picturecopy.png");
        //1.2 指定目的地
        FileOutputStream fos = new FileOutputStream("D:\\code\\IdeaProjects\\flink-framework\\java-grammar\\src\\main\\java\\com\\atguigu\\javase\\g_io\\picturecopy2.png");


        //2.读写数据
        //2.1 创建数组
        byte[] b = new byte[1024];
        //2.2 定义长度
        int len;
        //2.3 循环读取
        while((len = fis.read(b))!=-1){
            //2.4 写出数据
            fos.write(b,0,len);
        }

        //3.关闭资源
        fos.close();
        fis.close();


    }
}
