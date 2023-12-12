package com.atguigu.javase.g_io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * java.io.File类
 * File类是java.io包下代表与平台无关的文件和目录,也就是说希望在程序中操作文件和目录都可以通过File类来完成,File类能新建,删除,重命名文件和目录
 * 在API中Flie的解释是文件和目录路径名的抽象表示形式,即File类是文件或目录的路径,而不是文件本身,因此File类不能直接访问文件内容本身,如果需要访问文件内容本身,则需要使用
 * 输入/输出流
 * ·File类代表磁盘或网络中某个文件或目录的路径名称,如/atguigu/javase/io/test.jpg
 * ·但不能直接使用File对象读取和写入数据,如果要操作数据,需要IO流,File对象好比是水库的"路线地址",要"存取"里面的水到你"家里",需要"管道"
 */
public class $01_File {
    /*
    1.构造方法
    ·public File(String pathname): 通过将给定的路径名字符串转换为抽象路径名来创建新的File实例
    ·public File(String parent,String child):从父路径名字符串和子路径名字符串创建新的File实例
    ·public File(File parent,String child): 从父抽象路径名和子路径名字符串创建新的File实例
     */
    @Test
    public void test01(){
        //文件路径名
        String pathname = "D:\\code\\IdeaProjects\\flink-framework\\java-grammar\\src\\main\\java\\com\\atguigu\\javase\\g_io";
        File file1 = new File(pathname);
        //通过父路径与子路径字符串
        String parent = "D:\\code\\IdeaProjects\\flink-framework\\java-grammar\\src\\main\\java\\com\\atguigu\\javase\\g_io";
        String child = "a.txt";
        File file2 = new File(parent, child);
        //通过父级file对象和子路径字符串
        File file3 = new File(file1, child);
        /*
        注意:
            ①一个File对象代表硬盘中实际存在的一个文件或者目录
            ②无论该路径下是否存在文件或者目录,都不影响File对象的创建
         */

    }
    /*
     2.常用方法(了解)
     2.1.获取文件或目录基本信息的方法
     ·public String getName(): 返回由此File表示的文件或目录的名称
     ·public long length(): 返回由此File表示的文件的长度
     ·public String getPath(): 将此FIle转换为路径名字符串
     ·public long lastModified(): 返回File对象对应的文件或目录的最后修改时间(毫秒值)
     */
    @Test
    public void test02(){
        File f = new File("D:\\code\\IdeaProjects\\flink-framework\\java-grammar\\src\\main\\java\\com\\atguigu\\javase\\g_io\\text.txt");
        System.out.println("文件构造路径:"+f.getPath());
        System.out.println("文件名称:"+f.getName());
        System.out.println("文件长度:"+f.length()+"字节");
        System.out.println("文件最后修改时间:"+ LocalDateTime.ofInstant(Instant.ofEpochMilli(f.lastModified()), ZoneId.of("Asia/Shanghai")));
    }
    /*
 2.常用方法(了解)
 2.2.各种路径问题
 File类可以使用文件路径字符串来创建File实例,该文件路径字符串即可以是绝对路径,也可以是相对路径
 默认情况下,系统总是依据用户的工作路径来解释相对路径,这个路径由系统属性"user.dir"指定,通常也就是运行java虚拟机时所作的路径
 ①绝对路径:从盘符开始的路径,这是一个完整的路径
 ②相对路径:相对于项目目录的路径,这是一个便捷的路径,开发中经常使用
 ③规范路径:所谓规范路径名,即对路径中的".."等进行解析后的路径名
 ·public String getPath(): 将此FIle转换为路径名字符串
 ·public String getAbsolutePath(): 返回此File的绝对路径名字符串
 ·public String getCanonicalPath(): 返回File对象对应的规范路径名
 ①Windows的路径分隔符使用"\",而java程序中的"\"表示转义字符,所以在Windows中表示路径,需要用"\",或者直接使用"/"也可以,Java程序支持将"/"
 当做平台无关的路径分隔符,或者直接使用File.separator常量值表示
 ②把构造File对象指定的文件或目录的路径名,称为构造路径,它可以是绝对路径,也可以是相对路径
 ③当构造路径是绝对路径时,那么getPath()和getAbsolutePath()结果一样
 ④当构造路径是相对路径时,那么getAbsolutePath()的路径=user.dir的路径 + 构造路径
 ⑤当路径中不包含".."和"/"开头等形式的路径,那么规范路径和绝对路径一样,否则会将".."解析,路径中如果出现".."表示上一级目录,路径中如果以"/"开头
 表示从根目录下开始导航

 */
    @Test
    public void test03() throws IOException {
        File f = new File("D:\\code\\IdeaProjects\\flink-framework\\java-grammar\\src\\main\\java\\com\\atguigu\\javase\\g_io\\text.txt");
        System.out.println("文件/目录构造路径:"+f.getPath());
        System.out.println("文件/目录名称:"+f.getName());
        System.out.println("文件/目录的绝对路径名:"+f.getAbsolutePath());
        System.out.println("文件/目录的规范路径名:"+f.getCanonicalPath());
        System.out.println("文件/目录父目录名:"+f.getParent());
        System.out.println("---------------------------------------");
        File f1 = new File("text.txt");
        System.out.println("user.dir ="+System.getProperty("user.dir"));
        System.out.println("文件/目录构造路径:"+f1.getPath());
        System.out.println("文件/目录名称:"+f1.getName());
        System.out.println("文件/目录的绝对路径名:"+f1.getAbsolutePath());
        System.out.println("文件/目录的规范路径名:"+f1.getCanonicalPath());
        System.out.println("文件/目录父目录名:"+f1.getParent());
        System.out.println("---------------------------------------");
        File f2 = new File("../text.txt");
        System.out.println("user.dir ="+System.getProperty("user.dir"));
        System.out.println("文件/目录构造路径:"+f2.getPath());
        System.out.println("文件/目录名称:"+f2.getName());
        System.out.println("文件/目录的绝对路径名:"+f2.getAbsolutePath());
        System.out.println("文件/目录的规范路径名:"+f2.getCanonicalPath());
        System.out.println("文件/目录父目录名:"+f2.getParent());
    }

    /*
      2.常用方法(了解)
      2.3.判断功能的方法
      ·public boolean exists(): 此File表示的文件或目录是否实际存在
      ·public boolean isDirectory(): 此File表示是否为目录
      ·public boolean isFile(): 此File表示是否为文件
     */
    @Test
    public void test04(){
        File f = new File("D:\\code\\IdeaProjects\\flink-framework\\java-grammar\\src\\main\\java\\com\\atguigu\\javase\\g_io\\text.txt");
        //判断是否存在
        System.out.println("text.txt是否存在:"+f.exists());
        //判断是否为文件
        System.out.println("text.txt是否为文件:"+f.isFile());
        //判断是否为目录
        System.out.println("text.txt是否为目录:"+f.isDirectory());
    }
    /*
      2.常用方法(了解)
      2.3.创建删除功能的方法
      ·public boolean createNewFile(): 当且仅当具有该名称的文件商不存在,创建一个新的空文件
      ·public boolean delete(): 删除由此File表示的文件或目录,只能删除空目录
      ·public boolean mkdir(): 创建右此File表示的目录
      ·public boolean mkdirs(): 创建右此File表示的目录,包括任何必须但不存在的父目录
     */
    @Test
    public void test05() throws IOException {
        //文件的创建
        File f1 = new File("io_demo.txt");
        System.out.println("是否存在:"+f1.exists());//false
        System.out.println("是否创建:"+ f1.createNewFile());//true
        System.out.println("是否存在:"+f1.exists());//false


        //目录的创建
        File f2 = new File("io_demo");
        System.out.println("是否存在:"+f2.exists());//false
        System.out.println("是否创建:"+f2.mkdir());//true
        System.out.println("是否存在:"+f2.exists());//true


        //创建多级目录
        File f3 = new File("io_demo\\a");
        System.out.println("是否创建:"+f3.mkdirs());//true
        //文件的删除
        //System.out.println(f1.delete());//true

        //目录的删除
        System.out.println(f2.delete());
        System.out.println(f3.delete());

        //api中说明:delete方法,如果此File表示目录,则目录必须为空才能删除
    }
    /*
  2.常用方法(了解)
  2.3.目录操作
  ·public String[] list(): 返回一个String数组,表示该File目录中的所有子文件或目录
  ·public File[] listFiles(): 返回一个File数组,表示该File目录中的所有子文件或目录
  ·public File[] listFiles(FileFilter filter): 返回所有满足指定过滤器的文件或目录,如果给定filter为null,则接受所有路径名,否则
  ,当且仅当在路径名上调用过滤器的FileFilter.accept(java.io.File)方法返回true时,该路径名才满足过滤器,如果当前对象不表示一个目录,或者发生IO错误
  则返回null
 */
    @Test
    public void test06(){

    }



}
