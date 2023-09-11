package com.atguigu.javase.d_api;

import java.io.UnsupportedEncodingException;

//构造字符串对象
public class $02_StringInit {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //①字符串常量对象(推荐)
        String str = "abc";
        //②使用无参构造
        String str1 = new String();
        System.out.println(str1);
        //③创建字符串常量副本(不推荐)
        String str2 = new String("hello");
        //④通过字符数组构造
        char[] a = {'1','2','3','4','5'};
        String str3 = new String(a);
        String str4 = new String(a,2,3);
        System.out.println(str4);
        //⑤通过字节数组构造
        byte[] b = {97,98,99};
        String str5 = new String(b);
        String str6 = new String(b,"GBK");
        System.out.println(str6);
        //⑥通过"+"
        int num = 123;
        String str7 =num + "";
        System.out.println(str7);
    }
}
