package com.atguigu.javase.i_socket;

import org.junit.Test;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

/**
 * UDP(User Datagram Protocol),用户数据报协议,是一个无连接的传输层协议,提供面向事务的简单不可靠的信息传送服务,类似于短信
 * UDP协议是一种面向非连接的协议,面向非连接指的是在正式通信前不必与对方先建立连接,不管对方状态就直接发送,至于对方是否可以接收到这些数据
 * 内容,UDP协议无法控制,因此说UDP协议是一种不可靠的协议,无连接的好处就是快,省内存空间和流量,因为维护连接需要创建大量的数据结构,UDP会尽最大
 * 努力交付数据,但不保证可靠交付,没有TCP的确认,重传机制,如果因为网络原因没有传送到对端,UDP也不会给应用层返回错误信息
 * UDP协议是面向数据报文的信息传送服务,UDP在发送端没有缓冲区,对于应用层交付下来的报文在添加了首部之后就直接交付于ip层,不会进行合并,也不会
 * 进行拆分,而是一次交付一个完整的报文,比如我们要发送一个100字节的报文,我们调用一次send()方法就会发送100字节,接收方也需要用receive()方法一次性接收
 * 100字节,不能使用循环每次获取10个字节,获取10次这样的做法
 * UDP协议没有拥塞控制,所以当网络出现的拥塞不会导致主机发送数据的速率降低,虽然UDP的接收端有缓冲区,但是这个缓冲区只负责接收,并不会保证UDP报文的到达顺序
 * 是否和发送的顺序一致,因为网络传输的时候,由于网络拥塞的存在是很大的可能导致先发的报文比后发的报文晚到达,如果此时缓冲区满了,后面到达的报文将直接被丢弃,
 * 这个对实时应用来说很重要,比如视频通话,直播等应用
 * 因此UDP适用于一次只传输少量数据,对可靠性要求不高的应用环境,数据报大小限制在64K以下
 */
public class $04_UDP {
    /**
     * 基于UDP协议的网络编程仍然需要在通信实例的两端各建立一个Socket,但是这两个Socket之间并没有虚拟链路,这两个Socket只是发送,接收数据报
     * 的对象,Java提供了DatagramSocket对象作为基于UDP协议的Socket,使用DatagramPacket代表DatagramSocket发送,接收的数据报
     * ①DatagramSocket类的常用方法:
     * ·public DatagramSocket(int port):创建数据报套接字并将其绑定到本地主机上的指定端口,套接字将被绑定到通配符地址,IP地址由内核来选择
     * ·public DatagramSocket(int port,InetAddress iaddr):创建数据报套接字,将其绑定到指定的本地地址,本地端口必须在0到65535之间(包括两者),如果IP
     * 地址为0.0.0.0,套接字将被绑定到通配符地址,IP地址由内核选择
     * ·public void close():关闭此数据报套接字
     * ·public void send(DatagramPacket p):从此套接字发送数据报包,DatagramPacket包含的信息指示:将要发送的数据,其长度,远程主机的IP地址和远程主机的端口号
     * ·public void receive(DatagramPacket p):从此套接字接收数据报包,当此方法返回时,DatagramPacket的缓冲区填充了接收的数据,数据报包也包含了发送方的IP地址和发送方
     * 机器上的端口号,此方法在接收到数据报前一直阻塞,数据报包对象的length字段包含所接收信息的长度,如果信息比包的长度长,该信息将被截短
     * ②DatagramPacket类的常用方法:
     * ·public DatagramPacket(byte[] buf,int length),构造DatagramPacket,用来接收长度为length的数据包,length参数必须小于等于buf.length
     * ·public DatagramPacket(byte[] buf,int lengh, InetAddress address,int port):构造数据报包,用来将长度为length的包发送到指定主机上的指定端口号,length
     * 参数必须小于等于buf.length
     * ·public int getLength():返回将要发送或接收的到数据的长度
     */
    /**
     * 发送端
     * @throws IOException
     */
    @Test
    public void send() throws IOException {
        //1.建立发送端的DatagramSocket
        DatagramSocket ds = new DatagramSocket();
        //要发送的数据
        ArrayList<String> all = new ArrayList<>();
        all.add("星期一");
        all.add("星期二");
        all.add("星期三");
        all.add("星期四");
        //接收方的IP地址
        InetAddress ip = InetAddress.getByName("127.0.0.1");
        //接收方的监听端口号
        int port = 9999;
        //发送多个数据报
        for (int i = 0; i < all.size(); i++) {
            //2.建立数据包DatagramPacket
            byte[] data = all.get(i).getBytes();
            DatagramPacket dp = new DatagramPacket(data, data.length, ip, port);
            //3.调用Socket的发送方法
            ds.send(dp);
        }
        //4.关闭Socket
        ds.close();
    }

    /**
     * 接收端
     */
    @Test
    public void Receive() throws Exception{
        //1.建立接收端的DatagramSocket,需要指定本端的指定端口号
        DatagramSocket ds = new DatagramSocket(9999);
        //一直监听数据
        while(true){
            //2.建立数据包DatagramPacket
            byte[] buffer = new byte[1024 * 64];
            DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
            //3.调用Socket的接收方法
            ds.receive(dp);
            //4.拆封数据
            String s = new String(buffer, 0, dp.getLength());
            System.out.println(s);
        }
    }


}
