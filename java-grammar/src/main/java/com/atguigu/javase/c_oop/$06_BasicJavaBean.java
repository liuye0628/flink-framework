package com.atguigu.javase.c_oop;

/**
 * 标准javabean:
 *  1.类必须是具体的和公共的
 *  2.具有无参数的构造方法以及有参数的构造方法
 *  3.成员变量私有化,并提供用来操作成员变量的set()方法和get()方法
 */

public class $06_BasicJavaBean {
    private String field1;
    private String field2;

    public $06_BasicJavaBean() {
    }

    public $06_BasicJavaBean(String field1, String field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }
}
