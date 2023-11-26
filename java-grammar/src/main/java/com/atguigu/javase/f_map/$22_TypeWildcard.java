package com.atguigu.javase.f_map;


import java.util.List;

/**
 * 类型通配符: 当我们声明一个变量/形参时,这个变量或形参的类型是泛型类或泛型接口,例如:Comparator类型,但是我们仍然无法确定这个泛型类或泛型接口的类型变量
 * <T>的具体类型,此时我们考虑使用类型通配符
 */
public class $22_TypeWildcard {
    //表示此方法可以接受一个泛型是<Animal>或者List<Animal的子类型>的List集合
    //<? extends 上限> -> 用于设定通配符上限
    public static void forList(List<? extends Animal> list){
        for (Animal animal : list) {
            System.out.println(animal);
        }
    }
    //表示此方法可以接受一个泛型是<Animal>或者List<Animal的父类型>的List集合
    //<? super 下限> -> 用于设定通配符下限
    public static void ForList(List<? super Animal> list){
        for (Object o : list) {
            System.out.println(o);
        }
    }
}



class Animal{
    private int age = 6;
    private String name = "animal";
    private String address = "深圳";
    int id = 0;

    public void call(){
        System.out.println("动物会叫");
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
class Dog extends Animal {
    private String color = "white";
    private String address = "广州";
    int id = 1;



    /*
    方法重写 :子类方法的参数,方法名称要和父类方法的参数,方法名称完全一样
             子类方法的返回类型要和父类方法的返回类型一样,或者是父类返回类型的子类
             子类方法不能缩小父类方法的返回权限
             私有方法不能被重写

     */
    @Override
    public void call(){
        super.call();//super代表父类的引用,用于访问父类的属性,方法,构造器,但不能访问父类中private修饰的属性和方法,在构造中使用super()无论是有参还是无参,都要放在第一行,且只能出现一句
        System.out.println("汪汪汪");
    }
    public void sleep(){
        System.out.println("呼呼呼");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }
}
