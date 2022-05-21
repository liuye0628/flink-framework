package com.atguigu.javase.a_basicgrammar;

public class $09_For {
    public static void main(String[] args) {
        /*
            需求:打印1~100之间所有是9的倍数的整数,统计个数和总和
         */
        int count = 0;
        int sum = 0;
        for(int i = 1; i<=100; i++){
            if(i % 9 == 0){
                sum = sum + i;
                count++;
            }
        }
        System.out.println("sum=" + sum);
        System.out.println("count=" + count);
    }
}
