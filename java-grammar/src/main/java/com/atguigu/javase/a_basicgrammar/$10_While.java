package com.atguigu.javase.a_basicgrammar;

public class $10_While {
    public static void main(String[] args) {
        /*
            需求:世界最高山峰是珠穆朗玛峰(8844.43米=8844430毫米),假如我有一张足够大的纸,它的厚度
            是0.1毫米,请问我折叠多少次,可以折成珠穆朗玛峰的高度?
         */
        int shanfeng = 8844430;
        double paper = 0.1;
        int count = 0;
        while(paper < shanfeng){
            paper = paper * 2;
            count++;
        }
        System.out.println(count);
    }
}
