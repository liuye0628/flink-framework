package com.atguigu.javase.i_socket;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress类主要表示IP地址,两个子类:Inet4Address,Inet6Address
 * 1.Internet上的主机有两种方式表示地址
 *  ·域名(hostName):www.baidu.com
 *  ·IP地址(hostAddress):202.108.35.210
 * 2.InetAddress类没有提供公共的构造器,而是提供了如下几个静态方法来获取InetAddress实例
 *  ·public static InetAddress getLocalHost()
 *  ·public static InetAddress getByName(String host)
 *  ·public static InetAddress getByAddress(byte[] addr)
 * 3.InetAddress提供如下几个常用的方法
 *  ·public String getHostAddress():返回ip地址字符串(以文本表现形式)
 *  ·public String getHostName(): 获取此ip地址的主机名
 */
public class $02_InetAddress {
    @Test
    public void test01() throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
    }
    @Test
    public void test02() throws UnknownHostException {
        InetAddress baidu = InetAddress.getByName("www.baidu.com");
        System.out.println(baidu);
    }
}
