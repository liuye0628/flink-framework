package com.atguigu.javase.d_api;

import org.junit.Test;

/**
 *   与String的区别
 *   因为String对象是不可变对象,虽然可以共享常量对象,但是对于频繁字符串的修改和拼接操作,效率极低,因此JDK又在java.lang包提供了可变字符序列StringBuilder和StringBuffer类型
 *      ①StringBuffer:老的,线程安全的(因为它的方法有synchronized修饰),效率低
 *      ②StringBuilder:线程不安全的,效率高
 *      ③常用的API,StringBuffer,StringBuilder是完全一致的
 */
public class $06_StringBuilderStringBuffer {
    public static void main(String[] args) {
        /**
         * （1）StringBuffer append(xx)：拼接，追加
         * （2）StringBuffer insert(int index, xx)：在[index]位置插入xx
         * （3）StringBuffer delete(int start, int end)：删除[start,end)之间字符
         * StringBuffer deleteCharAt(int index)：删除[index]位置字符
         * （4）void setCharAt(int index, xx)：替换[index]位置字符
         * （5）StringBuffer reverse()：反转
         * （6）void setLength(int newLength) ：设置当前字符序列长度为newLength
         * （7）StringBuffer replace(int start, int end, String str)：替换[start,end)范围的字符序列为str
         * （8）int indexOf(String str)：在当前字符序列中查询str的第一次出现下标
         * int indexOf(String str, int fromIndex)：在当前字符序列[fromIndex,最后]中查询str的第一次出现下标
         * int lastIndexOf(String str)：在当前字符序列中查询str的最后一次出现下标
         * int lastIndexOf(String str, int fromIndex)：在当前字符序列[fromIndex,最后]中查询str的最后一次出
         * 现下标
         * （9）String substring(int start)：截取当前字符序列[start,最后]
         * （10）String substring(int start, int end)：截取当前字符序列[start,end)
         * （11）String toString()：返回此序列中数据的字符串表示形式
         */

    }
    @Test
    public void test01(){
        StringBuilder s = new StringBuilder("Helloworld");
        s.setLength(30);//void setLength(int newLength):设置当前字符序列为newLength
        System.out.println(s);
    }
    @Test
    public void test02(){
        StringBuilder s = new StringBuilder();
        s.append("hello").append(true).append('a').append(12).append("atguigu");//append(xx):追加
        System.out.println(s);
        System.out.println(s.length());
    }
    @Test
    public void test03(){
        StringBuilder s = new StringBuilder("helloworld");
        s.insert(5,"java");//insert(int index,xx):在[index]位置插入xx
        System.out.println(s);
    }
    @Test
    public void test04(){
        StringBuilder s = new StringBuilder("helloworld");
        s.delete(1,3);//delete(int start,int end):删除[start,end]之间字符(左闭右开)
        System.out.println(s);
        s.deleteCharAt(5);//deleteCharAt(int index):删除[index]位置字符
        System.out.println(s);
        s.setCharAt(1,'k');//setCharAt(int index,xx):替换index位置字符
        System.out.println(s);
    }
    @Test
    public void test05(){
        StringBuilder s = new StringBuilder("helloworld");
        s.reverse();//reverse():反转
        System.out.println(s);
    }


}
