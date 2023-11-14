package com.atguigu.javase.f_map;

import java.util.HashSet;
import java.util.Objects;

/**
 * HashSet是Set接口的典型实现,大多数时候使用Set集合时都使用这个实现类
 * java.util.HashSet底层的实现其实是一个java.util.HashMap支持,HashMap的底层是一个Hash表
 * HashSet按Hash算法来存储集合中的元素,因此具有很好的存取和查找性能
 */
public class $11_HashSet {
    /**
     * HashSet集合判断两个元素相等的标准:
     *      ①两个对象通过hashCode()方法比较相等
     *      ②两个对象equals()方法返回值要相等
     * 因此,存储到HashSet的元素要重写hashCode()和equals()方法
     *
     *
     */
    public static void main(String[] args) {
        HashSet<A> set = new HashSet<>();
        set.add(new A(1,"刘备"));
        set.add(new A(1,"刘备"));//重复元素无法添加
        set.add(new A(2,"张飞"));
        set.add(new A(3,"关羽"));
        set.add(new A(4,"赵云"));
        set.add(new A(5,"诸葛亮"));
        for (A a : set) {
            System.out.println(a);
        }

    }
}

class A{
    private int id;
    private String name;

    public A() {
    }

    public A(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "A{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a = (A) o;
        return id == a.id && name.equals(a.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

