package com.atguigu.javase.c_oop;
/**
 *  面向对象特性:继承
 *      基本介绍:继承可以解决代码复用,让我们的编程更加靠近人类思维,当多个类存在相同的属性和方法时,可以从这些类中抽象出父类
 *      ,在父类中定义这些相同的属性和方法,所有的子类不需要重新定义这些属性和方法,只需要通过extends来声明继承父类即可
 */
public class $09_ObjectExtend {
    public static void main(String[] args) {
        //1.子类和父类中的成员变量不重名
        Animal animal = new Animal();
        System.out.println(animal.getAge());//如果new的是父类,只能调用父类自己的成员变量
        Dog dog = new Dog();
        System.out.println(dog.getAge());//如果new的是子类,既能调用自己的,还能调用父类中继承过来的
        System.out.println(dog.getColor());
        //2.子类和父类中的成员变量重名
        System.out.println(animal.getAddress());//如果是父类对象,调用父类中的成员变量
        System.out.println(dog.getAddress());//如果是子类的,调用的是子类的成员变量
        animal.call();
        dog.call();

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
class Dog extends Animal{
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