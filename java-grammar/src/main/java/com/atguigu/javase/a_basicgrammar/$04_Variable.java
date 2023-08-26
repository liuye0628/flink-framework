package com.atguigu.javase.a_basicgrammar;

public class $04_Variable {

    public static void main(String[] args){

        /*
            变量: 程序的基本组成单位
            变量三要素: 变量类型 变量名 = 变量值
            数据类型:
                基本数据类型: byte short int long float double char boolean
                引用数据类型: 类 接口 数组
                java的整型常量默认为int 浮点型常量默认为double
                byte -> short -> int -> long -> float -> double
                char-> int -> long -> float -> double
                byte,short 与char之间不会相互自动转换
            自动类型转换: 取值范围大的数据类型 变量名 = 取值范围小的数据类型
            强制类型转换: 取值范围小的数据类型 变量名 = (取值范围小的数据类型)取值范围大的数据类型
         */

        /*
            \n 代表的是换行
         */
        char c1 = '\n';
        System.out.print("111");
        System.out.print(c1);
        System.out.print("111");
        System.out.println(c1);

        /*
            \t 制表符 相当于tab键
         */
        System.out.println("name" + '\t' + "张三");

        /*
            在java中路径怎么表示
            E:\idea\io
            在java中两个反斜杠代表一个发女斜杠
         */
        String path = "E:\\Idea\\io";
        System.out.println(path);

        char c2 ='\'';
        System.out.println(c2);
        char c3 = 97;
        char c4 = '9';
        System.out.println(c3); //输出 a
        System.out.println(c4);

        byte b = 97;
        char c5 = (char)b;
        System.out.println(c5);

        int result = 'a';
        System.out.println(result);


    }
}
