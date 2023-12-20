package com.atguigu.javase.g_io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * 需求:序列化集合
 * 1.将存有多个自定义对象的集合序列化操作,保存到list.txt文件中
 * 2.反序列化list.txt,并遍历集合,打印对象信息
 */
public class $15_ObjectStreamTest {
    public static void main(String[] args) throws Exception {
        Student student = new Student("老王", "lw");
        Student student1 = new Student("老张", "lz");
        Student student2 = new Student("老李", "ll");
        ArrayList<Student> list = new ArrayList<>();
        list.add(student);
        list.add(student1);
        list.add(student2);
        //序列化操作
        serializ(list);
        //反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("list.txt"));
        ArrayList<Student> students = (ArrayList<Student>) ois.readObject();
        for (int i = 0; i < students.size(); i++) {
            Student s = list.get(i);
            System.out.println(s.name+"--"+s.EnName);
        }

    }

    /*
    序列化操作
     */
    private static void serializ(ArrayList<Student> arrayList) throws Exception{
        //创建序列化流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("list.txt"));
        //写出对象
        oos.writeObject(arrayList);
        //释放资源
        oos.close();
    }
}
class Student implements java.io.Serializable{
    String name;
    String EnName;

    public Student(String name, String enName) {
        this.name = name;
        EnName = enName;
    }
}
