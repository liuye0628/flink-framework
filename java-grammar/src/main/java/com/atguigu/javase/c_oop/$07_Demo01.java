package com.atguigu.javase.c_oop;

public class $07_Demo01 {
    /**
     * 需求:定义Person类,里面有name,age属性,并提供compareTo方法,用于判断是否与另一个人相等,名字与年龄完全一样,就返回true,否则返回false
     */
    public static void main(String[] args) {
        Person person = new Person(24, "李白");
        Person person1 = new Person(24,"李白");
        System.out.println(person.compareTo(person1));
    }

}
class Person{
    private int age;
    private String name;
    public Person(int age,String name){
        this.age = age;
        this.name = name;
    }
    public Boolean compareTo(Person person){
        if(this.age== person.age && this.name.equals(person.name)){
            return true;
        }
        return false;
    }
}
