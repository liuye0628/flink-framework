package com.atguigu.javase.g_io;

import java.io.*;

/**
 * 数据流(了解):在之前学习的IO流中,在程序代码中,要么将数据直接按照字节处理,要么按照字符处理,那么如果要在程序中直接处理Java的基础数据类型,怎么办呢?
 *  String name = "巫师";
 *  int age = 300;
 *  char gender = '男';
 *  int energy = 5000;
 *  double price = 75.5;
 *  boolean relive = true;
 *  完成这个需求,就可以使用DataOutputStream进行写,随后用DataInputStream进行读取,而且顺序要一致
 */
public class $13_DataStream {
    public void save() throws IOException {
        String name = "巫师";
        int age = 300;
        char gender = '男';
        int energy = 5000;
        double price = 75.5;
        boolean relive = true;
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("game.dat"));
        dos.writeUTF(name);
        dos.writeInt(age);
        dos.writeChar(gender);
        dos.writeInt(energy);
        dos.writeDouble(price);
        dos.writeBoolean(relive);
        dos.close();
    }

    public void reload() throws IOException{
        DataInputStream dis = new DataInputStream(new FileInputStream("game.dat"));
        String name = dis.readUTF();
        int age = dis.readInt();
        char gender = dis.readChar();
        int energy = dis.readInt();
        double price = dis.readDouble();
        boolean relive = dis.readBoolean();
        System.out.println(name +","+age+","+gender+","+energy+","+price+","+relive);
        dis.close();
    }
}
