package com.atguigu.javase.f_map;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

//Collection 练习
public class $05_CollectionTest {


    /**
     * 需求一:
     *      ①添加100以内的质数到Collection的某个集合中
     *      ②使用foreach遍历
     *      ③使用Iterator遍历,并删除个位数是3的质数
     *      ④删除11
     *      ⑤查看最后剩下几个元素
     *      ⑥添加10个100以内的随机整数到另一个Collection的集合中
     *      ⑦求它们的交集
     */
    @Test
    public void test01(){
        ArrayList<Integer> list = new ArrayList<>();
        //①添加100以内的质数到集合list中
        for(int i = 2; i<=100;i++){
            boolean flag = true;
            for(int j = 2; j< i; j++){
                if(i % j == 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                list.add(i);
            }
        }
        //System.out.println(list);
        //②使用foreach遍历
        for (Integer a : list) {
            System.out.print(a + "\t");
        }
        System.out.println();
        //list.forEach(System.out::println);
        //③使用Iterator遍历并删除个位数是3的质数或11
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next % 10 == 3 || next == 11) {
                iterator.remove();//通过迭代器删除元素
            }
        }
        //④查看最后剩下的元素的个数
        System.out.println(list.size());
        System.out.println(list);
        //⑤添加10个100以内的随机整数到另一个collection集合中
        ArrayList<Integer> random = new ArrayList<>();
        for(int i = 1; i<=10;i++){
            random.add((int)(Math.random()*100));
        }
        System.out.println(random);
        //⑥求交集
        list.retainAll(random);
        System.out.println("交集为"+list);





    }

    /**
     * 需求二:
     *      声明学员类型Student,包含属性:姓名,成绩
     *      添加本组学员Student对象到Collection的某个集合中
     *          ①使用foreach遍历
     *          ②使用iterator遍历,并删除成绩低于60分的
     *
     */
    @Test
    public void test02(){
        //②添加学员对象到Collection集合中
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("刘备",100));
        students.add(new Student("关羽",55));
        students.add(new Student("张飞",80));
        //使用foreach遍历
        for (Student student : students) {
            System.out.println(student);
        }
        //使用iterator遍历,并删除成绩低于60分的
        Iterator<Student> studentIterator = students.iterator();
        while(studentIterator.hasNext()){
            Student next = studentIterator.next();
            System.out.println(next);
            if(next.getScore() < 60){
                studentIterator.remove();
            }
        }
        System.out.println(students);

    }


}
//①声明学生类型Student,包含属性:姓名成绩
class Student{
    private String name;
    private int score;


    public Student() {
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }


}
