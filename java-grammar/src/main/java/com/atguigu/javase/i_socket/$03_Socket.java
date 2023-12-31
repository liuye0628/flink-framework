package com.atguigu.javase.i_socket;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

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
    /**
     * 示例一:单个客户端与服务端单次通信
     */
    /**
     * 客户端示例代码
     */
    @Test
    public void client() throws IOException {
        //1.准备socket,连接服务器,需要指定连接服务器的IP地址和端口号
        Socket socket = new Socket("127.0.0.1", 8888);
        //2.获取输出流,用来发送消息给服务器
        OutputStream out = socket.getOutputStream();
        //发送数据
        out.write("星期天".getBytes());
        //会在流的末尾加入一个"流的末尾"标记,对方才能读到-1,否则对方的读取方法会一致阻塞
        socket.shutdownOutput();
        //3.获取输入流,用来接收服务器发送给客户端的数据
        InputStream input = socket.getInputStream();
        //接收数据
        byte[] data = new byte[1024];
        StringBuilder s = new StringBuilder();
        int len;
        while((len = input.read(data))!=-1){
            s.append(new String(data,0,len));
        }
        System.out.println("服务器返回的消息是:"+s);
        //4.关闭socket,不再与服务器通信,即断开与服务器的连接
        //socket关闭,意味着InputStream与OutputStream也关闭了
        socket.close();
    }


    /**
     * 服务器端示例代码
     */
    @Test
    public void server() throws IOException {
        //1.准备一个ServerSocket对象,并绑定8888端口
        ServerSocket server = new ServerSocket(8888);
        System.out.println("等待连接....");
        //2.在8888端口监听客户端的连接,该方法是个阻塞的方法,如果没有客户端连接,将一直阻塞
        Socket socket = server.accept();
        System.out.println("一个客户端连接成功!");
        //3.获取输入流,用来接收该客户端发送给服务器的数据
        InputStream input = socket.getInputStream();
        //接收数据
        byte[] data = new byte[1024];
        StringBuilder s = new StringBuilder();
        int len;
        while((len = input.read(data))!=-1){
            s.append(new String(data,0,len));
        }
        System.out.println("客户端发送的消息是:"+s);
        //4.获取输出流,用来发送数据给该客户端
        OutputStream out = socket.getOutputStream();
        //发送数据
        out.write("欢迎登录".getBytes());
        out.flush();
        //5.关闭socket,不再与该客户端通信
        //socket关闭,意味着InputStream和OutputStream也关闭了
        socket.close();
        //6.如果不再接收任何客户端通信,可以关闭ServerSocket
        server.close();
    }


    /**
     * 示例二:多个客户端与服务器之间的多次通信
     * 通常情况下,服务器不应该只接受一个客户端请求,而应该不断的接受来自客户端的所有请求,所以Java程序通常会通过循环,不断的调用ServerSocket的accept()方法
     * 如果服务器端要同时处理多个客户端请求,因此服务器端需要为每一个客户端单独分配一个线程来处理,否则,无法实现同时
     * 之前学习IO流的时候,提到过装饰着设计模式,该设计使得不管底层IO流是怎样的节点流:文件流也好,网络Socket产生的流也好,程序都可以将其包装成处理流,甚至可以多层
     * 包装,从而提供更多方便的处理
     * 案例需求:多个客户端连接服务器,并进行多次通信
     *  ·每个客户端连接成功后,从键盘输入英文单词或中国成语,并发送给服务器
     *  ·服务器收到客户端的消息后,把词语"反转"后返回给客户端
     *  ·客户端接收服务器返回的"词语",打印显示
     *  ·当客户端输入"stop"时,断开与服务器的连接
     *  ·多个客户端可以同时给服务器"发送词语",服务器可以同时处理多个客户端的请求
     */

    /**
     * 客户端示例代码二
     */
    @Test
    public void client2() throws IOException {
        //1.准备socket,连接服务器,需要指定服务器的IP地址和端口号
        Socket socket = new Socket("127.0.0.1", 8888);
        //2.获取输出流,用来发送数据给服务器
        OutputStream out = socket.getOutputStream();
        PrintStream ps = new PrintStream(out);
        //3.获取输入流,用来接收服务器发送给该客户端的数据
        InputStream input = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(input));
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("输入发送给服务器的单词或词语:");
            String message = scanner.nextLine();
            if(message.equals("stop")){
                socket.shutdownOutput();
                break;
            }
            //4.发送数据
            ps.println(message);
            //接收数据
            String feedback = br.readLine();
            System.out.println("从服务器收到的反馈是:"+feedback);
        }
        //5.关闭socket,断开与服务器的连接
        scanner.close();
        socket.close();

    }

    /**
     * 服务器端示例代码二
     */
    @Test
    public void server2() throws IOException {
        //1.准备一个ServerSocket
        ServerSocket server = new ServerSocket(8888);
        System.out.println("等待连接...");
        int count = 0;
        while(true){
            //2.监听一个客户端的连接
            Socket socket = server.accept();
            System.out.println("第"+ ++count + "个客户端" + socket.getInetAddress().getHostAddress()+"连接成功!!");
            ClientHandlerThread ct = new ClientHandlerThread(socket);
            ct.start();
        }
        //这里没有关闭Server,永远监听
    }

    static class ClientHandlerThread extends Thread{
        private Socket socket;
        public ClientHandlerThread(Socket socket){
            super();
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                //(1)获取输入流,用来接收客户端发送给服务器的数据
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                //(2)获取输出流,用来发送数据给该客户端
                PrintStream ps = new PrintStream(socket.getOutputStream());
                String str;
                //(3)接收数据
                while((str = br.readLine())!=null){
                    //(4)反转
                    StringBuilder word = new StringBuilder(str);
                    word.reverse();
                    //(5)返回给客户端
                    ps.println(word);
                }
                System.out.println(socket.getInetAddress().getHostAddress()+"正常退出");
            } catch (IOException e) {
                System.out.println(socket.getInetAddress().getHostAddress()+"意外退出");
            } finally {
                try {
                    //(6)断开连接
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
