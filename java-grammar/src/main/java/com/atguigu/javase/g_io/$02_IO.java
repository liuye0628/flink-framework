package com.atguigu.javase.g_io;

/**
 * IO概述
 */

public class $02_IO {

    /**
     * 1.什么是io
     * 生活中,你肯定经理过这样的场景,当你编辑一个文本文件,忘记了ctrl+s,可能文件就白白编辑了,当你的电脑上插入一个U盘,可以把一个视频,拷贝到你的电脑
     * 硬盘里,那么数据都是在哪些设备上呢?键盘,内存,硬盘,外界设备等等
     * 我们把这种数据的传输,可以看做是一种数据的流动,按照流动的方向,以内存为基准分为输入input和输出output,即流向内存是输入流,流出内存的是输出流
     * Java中I/O操作主要是指java.io包下的内容,进行输入,输出操作,输入也叫读取数据,输出也叫做写出数据
     */

    /**
     * 2.IO的分类
     * ①按照数据的流向分为输入流和输出流
     * ·输入流:把数据从其他设备读取到内存中的流(以InputStream,Reader结尾)
     * ·输出流:把数据从内存中写入到其他设备上的流(以OutputStream,Writer结尾)
     * ②根据数据的类型分为字节流和字符流
     * ·字节流:以字节为单位,读取数据的流(以InputStream和OutputStream结尾)
     * ·字符流:以字符为单位,读取数据的流(以Reader和Writer结尾)
     * ③根据IO流的角色不同分为:节点流和处理流
     * ·节点流:可以从或向一个特定的地方(节点)读写数据,如FileReader
     * ·处理流:是对一个已经存在的流进行连接和封装,通过所封装的流的功能调用实现数据读写,如BufferedReader,处理流的构造方法总是要带一个其他的流对象做参数
     * 一个流对象经过其他流的多次包装,称为流的链接
     * 这种设计是装饰模式(Decorator Pattern)也称为包装模式(Wrapper pattern),其使用一种对客户端透明的方式来动态的扩展对象的功能,它是通过继承扩展功能
     * 的替代方案之一,在现实中你也有很多装饰者的例子,例如:人需要各种各样的衣着,不管你穿着怎样,但是,对于你个人的本质是不变的,充其量只是在外面加上了一些装饰
     * ,如"好看的","保暖的"
     * ④常用的节点流
     * ·文件FileInputStream FileOutputStream FileReader FileWriter 文件进行处理的节点流
     * ·字符串 StringReader StringWriter对字符串处理的节点流
     * ·数组 ByteArrayInputStream ByteArrayOutputStream CharArrayReader CharArrayWriter对数组进行处理的节点流(对应的不再是文件,而是内存中的一个数组)
     * ·管道 PipedInputStream PipedOutputStream PipedReader PipedWriter对管道进行处理的节点流
     * ⑤常用的处理流
     * ·缓冲流:BufferedInputStream BufferedOutputStream BufferedReader BufferedWriter--增加缓冲功能,避免频繁读写磁盘
     * ·转换流:InputStreamReader OutputStreamReader--实现字节流与字符流之间的转换
     * ·数据流:DataInputStream DataOutputStream-提供读写Java基础数据类型功能
     * ·对象流:ObjectInputStream ObjectOutputStream--提供直接读写Java对象功能
     */

    /**
     * IO中的基类
     *                        输入流                   输出流
     * 字节流              字节输入流InputStream        字节输出流OutputStream
     * 字符流              字符输入流Reader             字符输出流Writer
     */
}
