package com.atguigu.javase.a_basicgrammar;

import java.util.Scanner;

public class $06_Scanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //请输入用户的姓名
        System.out.print("请输入用户的姓名:");
        String name = scanner.next();
        System.out.println(name);

        /*
            通过键盘录入两个整数,让整数相加,输出结果
         */
        System.out.println("请输入第一个整数:");
        int a = scanner.nextInt();
        System.out.println("请输入第二个整数:");
        int b = scanner.nextInt();
        int sum = a + b;
        System.out.println("两个整数的和为:" + sum);
    }
}
