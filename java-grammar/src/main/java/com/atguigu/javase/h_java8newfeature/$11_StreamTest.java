package com.atguigu.javase.h_java8newfeature;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Stream练习:
 *  现在有两个ArrayList集合存储队伍中的多个成员姓名,要求使用传统的for循环(或增强for循环)依次进行以下这个若干操作步骤:
 *      ①第一个队伍只要名字为3个字的成员姓名,存储到一个新集合中
 *      ②第一个队伍筛选之后只要前3个人,存储到一个新集合中
 *      ③第二个队伍只要姓张的成员姓名,存储到一个新集合中
 *      ④第二个队伍筛选之后不要前两个人,存储到一个新集合中
 *      ⑤将两个队伍合并为一个队伍,存储到一个新集合中
 *      ⑥根据姓名创建Person对象,存储到一个新集合中
 *      ⑦打印整个队伍的Person对象信息
 */
public class $11_StreamTest {
    public static void main(String[] args) {
        ArrayList<String> one = new ArrayList<>();
        one.add("孙悟空");
        one.add("齐天大圣");
        one.add("弼马温");
        one.add("孙行者");
        one.add("唐三藏");
        one.add("如来");

        ArrayList<String> two = new ArrayList<>();
        two.add("刘备");
        two.add("刘玄德");
        two.add("诸葛孔明");
        two.add("诸葛亮");
        two.add("关羽");
        two.add("关云长");
        two.add("张飞");
        two.add("张翼德");
        two.add("张辽");


        Stream<String> streamOne = one.stream().filter(name -> name.length() == 3).limit(3);//第一个队伍只要名字为三个字的成员,并且只要前三个
        Stream<String> streamTwo = two.stream().filter(name -> name.startsWith("张")).skip(2);//第二个队伍只要姓张的,并且筛选后不要前两个
        Stream.concat(streamOne,streamTwo).map(name ->new Person(name)).forEach(System.out::println);//将两个队伍合并为一个队伍,根据姓名创建person对象,打印整个队伍的person信息
    }
}


class Person{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
