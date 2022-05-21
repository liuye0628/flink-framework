package com.atguigu.javase.a_basicgrammar;

public class $05_Operator {
    public static void main(String[] args) {
        /*
            算术运算符: + - * / % ++ --
         */
        int a = 10;
        int b = 3;
        int result01= a + b;
        int result02= a - b;
        int result03= a * b;
        int result04= a / b;
        int result05= a % b;
        System.out.println(result01);
        System.out.println(result02);
        System.out.println(result03);
        System.out.println(result04);
        System.out.println(result05);
        System.out.println(a++);
        System.out.println(++a);

        /*
            关系运算符: == != < > <= >=
            关系运算符的结果都为boolean类型
            instance of 检查是否是类的对象
         */
        boolean result06 = a == b;
        System.out.println(result06);

        /*
            赋值运算符: = += -= *= /= %=
         */
        byte c = 1;
        c+=1;
        System.out.println(c);

        /*
            逻辑运算符: & && | || ! ^
         */
        int i = 10;
        int j = 20;
        int k = 10;
        boolean result07 = (i == j) && (i < k );
        boolean result08 = (i == j) || (i < k );
        System.out.println(result07);
        System.out.println(result08);
        /*
            三元运算符: 条件表达式?表达式1:表达式2
         */
        //使用三元表达式求三个数中的最大值
        int n1 = 5;
        int n2 = 7;
        int n3 = 1;
        int max = n1 > n2 ? n1 : n2 > n3 ? n2 : n3;
        System.out.println(max);


    }
}
