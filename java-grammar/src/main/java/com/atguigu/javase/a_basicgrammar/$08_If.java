package com.atguigu.javase.a_basicgrammar;

import java.util.Scanner;

public class $08_If {
    public static void main(String[] args) {
        /*
            需求:对学生成绩大于60的输出"合格",小于60的输出"不合格"
            注意:输入的成绩不能大于100
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学生成绩:");
        int score = scanner.nextInt();
        if(score > 60){
            System.out.println("合格");
        }else{
            System.out.println("不合格");
        }
    }

}
