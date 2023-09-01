package com.atguigu.javase.c_oop;

import java.util.Objects;

public class $17_Object {
    public static void main(String[] args) {
        //1.toString()方法
        /**
         * ①基本介绍:默认返回全类名+@+哈希值的十六进制,子类往往重写toString()方法用于返回对象的属性信息
         * ②重写toString方法打印对象或拼接对象时,都会自动调用该对象的toString形式
         * ③当直接输出一个对象时,toString方法会被默认的调用
         */
        Person1 person1 = new Person1(21, "李白");
        Person1 person2 = new Person1(21, "李白");
        System.out.println(person1);
        System.out.println(person1.equals(person2));

    }
}
class Person1{
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public Person1() {
    }

    public Person1(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person1 person1 = (Person1) o;
        return age == person1.age && name.equals(person1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}
