package com.atguigu.javase.d_api;
//字符串对象的内存分析
public class $04_StringMemoryAnalyze {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "world";
        String s3 = "helloworld";
        String s4 = s1 + "world";
        String s5 = s1 + s2;
        String s6 = "hello" + "world";
        /**
         * 结论:
         *  ①常量+常量:结果是常量池
         *  ②常量+变量或变量+变量:结果是堆
         */
        System.out.println(s3 == s4);//false
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//true

    }
}
