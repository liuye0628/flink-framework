package com.atguigu.javase.i_socket;

/**
 * 1.通信的两端都要有Socket(也可以叫"套接字"),是两台机器间通信的端点,网络通信其实就是Socket间的通信,Socket可以分为:
 * ·流套接字(stream socket):使用TCP提供可依赖的字节流服务
 *      ·ServerSocket:此类实现TCP服务器套接字,服务器套接字等待请求通过网络传入
 *      ·Socket:此类实现客户端套接字(也可以就叫"套接字"),套接字是两台机器间通信的端点
 * ·数据报套接字(datagram socket):使用UDP提供"尽力而为"的数据报服务
 *      ·DatagramSocket:此类用来发送和接收UDP数据报包的套接字
 * 2.开发步骤:
 * ①服务器端:服务器程序的工作过程包含以下四个基本的步骤
 *  ·调用ServerSocket(int port):创建一个服务器端套接字,并绑定到指定端口上,用于监听客户端的请求
 *  ·调用accept():监听连接请求,如果客户端请求连接,则接受连接返回通信套接字对象
 *  ·调用该Socket类对象的getOutputStream()和getInputStream():获取输出流和输入流,开始网络数据的发送和接收
 *  ·关闭Socket对象:客户端访问结束,关闭通信套接字
 * ②客户端:客户端Socket的工作过程包含以下四个基本的步骤:
 *  ·创建Socket:根据指定服务端的IP地址或端口号构造Socket类对象,若服务器端响应,则建立客户端到服务器的通信线路,若连接失败,会出现异常
 *  ·打开连接到Socket的输入/出流:使用getInputStream()方法获得输入流,使用getOutputStream()方法获得输出流,进行数据传输
 *  ·按照一定的协议对数据进行读/写操作:通过输入流读取服务器放入线路的信息(但不能读取自己放入线路的信息),通过输出流将信息写入线路
 *  ·关闭Socket:断开客户端到服务器的连接,释放线路
 * 3.相关API
 *  ①ServerSocket类的构造方法:
 *  ·ServerSocket(int port):创建绑定到特定端口的服务器套接字
 *  ②ServerSocket类的常用方法:
 *  ·Socket accept():侦听并接受到此套接字的连接
 *  ③Socket类的常用构造方法:
 *  ·public Socket(InetAddress address,int port):创建一个流套接字并将其连接到指定IP地址的指定端口号
 *  ·public Socket(String host,int port):创建一个流套接字并将其连接到指定主机上的指定端口号
 *  ④Socket类的常用方法:
 *  ·public InputStream getInputStream():返回此套接字的输入流,可以用于接收信息
 *  ·public OutputStream getOutputStream():返回此套接字的输出流,可以用于发送信息
 *  ·public InetAddress getInetAddress():此套接字连接到的远程IP地址,如果套接字是未连接的,则返回null
 *  ·public InetAddress getLocalAddress():获取套接字绑定的本地地址
 *  ·public int getPort():此套接字连接到的远程端口号,如果尚未连接套接字,则返回0
 *  ·public int getLocalPort():返回此套接字绑定到的本地端口,如果尚未绑定套接字,则返回-1
 *  ·public void close():关闭此套接字,套接字被关闭后,套接字被关闭后,便不可在以后的网络连接中使用(即无法重新连接或重新绑定),需要创建新的
 *  套接字对象,关闭此套接字也会关闭该套接字的InputStream和OutputStream
 *  ·public void shutdownInput():如果在套接字上调用shutdownInput()后从套接字输入流读取内容,则流将返回EOF(文件结束符),即不能在此套接字的
 *  输入流中接收任何数据
 *  ·public void shutdownOutput():禁用此套接字的输出流,对于TCP套接字,任何以前写入的数据都将被发送,并且后跟TCP的正常连接终止序列,如果在套接字上
 *  调用shutdownOutput()后写入套接字输出流,则该流将抛出IOException,即不能通过此套接字的输出流发送任何数据
 * 注意:先后调用Socket的shutdownInput()和shutdownOutput()方法,仅仅关闭了输入流和输出流,并不等于调用Socket的close()方法,在通信结束后,仍然要调用
 * Socket的close()方法,因为只有该方法才会释放Socket占用的资源,比如占用本地的端口号等
 *
 */
public class $03_Socket {
}
