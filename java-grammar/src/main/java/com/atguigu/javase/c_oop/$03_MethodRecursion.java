package com.atguigu.javase.c_oop;
//递归
public class $03_MethodRecursion {
    //需求:使用递归的方式求出斐波那契数的第n值
    //规律 一个数等于前两个数之和(1,1,2,3,5)
    public static void main(String[] args) {
        System.out.println(feiBoNaqQie(6));

    }
    public static int feiBoNaqQie(int n){
        if(n==1 || n==2){
            return 1;
        }
         return feiBoNaqQie(n-1) + feiBoNaqQie(n-2);

    }
}
