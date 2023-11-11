package com.atguigu.javase.h_java8newfeature;

import java.util.ArrayList;

/**
 * 需求二:
 *      ①声明学生类,包含姓名和年龄
 *      ②添加几个学生对象到一个ArrayList集合中
 *      ③对集合中的学生进行操作,找出年龄大于30岁的,并取出第一个学生,如果没有这样的学生,用无参构造new一个学生对象,打印学生信息
 */
public class $14_OptionalTest02 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("刘备",45));
        list.add(new Student("关羽",23));
        list.add(new Student("张飞",55));
        list.add(new Student("诸葛亮",20));
        list.add(new Student("赵云",18));

        Student stu = list.stream().filter(s -> s.getAge() > 30).findFirst().orElse(new Student());
        System.out.println(stu);
    }
}

class Student{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
