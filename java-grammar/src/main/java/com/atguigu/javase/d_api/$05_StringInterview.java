package com.atguigu.javase.d_api;

import org.junit.Test;

import java.util.ArrayList;

//String 相关面试题
public class $05_StringInterview {
    /*
    * ①字符串的length与数组的length有什么不同
    *   字符串的length是方法 数组的length是属性
    * */
    /**
     * 需求一:在字符串中找出连续最长数字串,返回这个串的长度,并打印这个最长字符串
     * 例如abcd12345cd1215se123456789 返回9 打印出123456789
     */
    @Test
    public void demo01(){
        String str = "abcd12345cd1215se123456789";
        char[] chars = str.toCharArray();
        ArrayList<String> list = new ArrayList<>();
        String s ="";
        for (int i = 0; i < chars.length; i++) {

            boolean flag = true;
            if(chars[i] >='0'&& chars[i] <='9'){
                    s+=chars[i];
                }
            if(!(chars[i] >= '0'&& chars[i] <='9') && s!=""){
                list.add(s);
                s="";
            }
            if(i == chars.length-1){
                list.add(s);
            }
            //list.add(s);
        }
        int max =0;
        for (String s1 : list) {
            if(s1.length()>max){
                max = s1.length();
            }
        }
        for (String s1 : list) {
            if(s1.length()==max){
                System.out.println(s1);
                System.out.println(max);
            }
        }

    }
}
