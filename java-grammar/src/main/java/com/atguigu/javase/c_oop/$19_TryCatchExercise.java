package com.atguigu.javase.c_oop;

import java.util.Scanner;

/**
 * 需求:如果用户输入的不是一个整数,就提示它反复输入,直到输入一个整数为止
 */

public class $19_TryCatchExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        while(true){
            try {
                System.out.println("请输入一个整数:");
                 num  = Integer.parseInt(scanner.next());
                break;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println("你输入的不是一个整数");
            } finally {
            }
        }
        System.out.println("你输入的值=" + num);

    }
}
