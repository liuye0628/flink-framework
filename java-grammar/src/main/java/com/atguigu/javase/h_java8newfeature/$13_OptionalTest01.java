package com.atguigu.javase.h_java8newfeature;

import java.util.Optional;

/**
 * 需求一:
 *      ①声明一个Girl类型,包含姓名(String)属性
 *      ②声明一个Boy类型,包含姓名(String),女朋友(Girl)属性
 *      ③在测试类中,创建一个Boy对象
 *          如果他有女朋友,显示他女朋友名称
 *          如果他没有女朋友,他的女朋友默认为"嫦娥",即只能欣赏"嫦娥"了
 */
public class $13_OptionalTest01 {
    public static void main(String[] args) {
        //Boy boy = new Boy("张三", null);
        Boy boy = new Boy("张三", new Girl("翠翠"));
        Optional<Girl> girlFriend = Optional.ofNullable(boy.getGirlFriend());
        Optional.of(girlFriend.orElse(new Girl("嫦娥"))).ifPresent(System.out::println);
    }
}


class Girl{
    private String name;

    public Girl(String name) {
        this.name = name;
    }

    public Girl() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Boy{
    private String name;
    private Girl girlFriend;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Girl getGirlFriend() {
        return girlFriend;
    }

    public void setGirlFriend(Girl girlFriend) {
        this.girlFriend = girlFriend;
    }

    public Boy() {
    }

    public Boy(String name, Girl girlFriend) {
        this.name = name;
        this.girlFriend = girlFriend;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "name='" + name + '\'' +
                ", girlFriend=" + girlFriend +
                '}';
    }
}
