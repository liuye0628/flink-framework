package com.atguigu.datastructalg.chapter01.class01;

/**
 * 给定一个参数N,返回 1!+2!+3!+4!+...+N!的结果
 */

public class $02_SumOfFactoril {
    public static void main(String[] args){
        int N = 10;
        System.out.println(f1(N));
        System.out.println("---");
        System.out.println(f2(N));


    }

    /**
     * 给定一个整数N,实现N的阶乘
     * @param N
     * @return
     */
    public static long factoril(int N){
        long ans = 1;
        for (int i = 1; i <= N; i++) {
            ans *= i;
        }
        return ans;

    }

    /**
     * 中间结果不保存
     * @param N
     * @return
     */
    public static long f1(int N){
        long ans = 0;
        for (int i = 1; i <= N; i++) {
            ans += factoril(i);
        }
        return ans;
    }

    /**
     * 中间结果保存
     * @param N
     * @return
     */
    public static long f2(int N){
        long ans = 0;
        long cur = 1;
        for (int i = 1; i<=N;i++){
            cur = cur * i;
            ans += cur;
        }
        return ans;


    }
}
