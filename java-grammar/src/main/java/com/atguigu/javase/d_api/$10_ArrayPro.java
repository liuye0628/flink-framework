package com.atguigu.javase.d_api;


import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

//数组的算法升华
//java.util.Arrays数组工具类:提供了很多静态方法对数组进行操作
public class $10_ArrayPro {
    public static void main(String[] args) {
        int[] arr = new int[5];
        System.out.println(arr);//打印数组,输出地址值
        System.out.println("arr数组的初始状态:"+Arrays.toString(arr));//toString():把数组的元素拼接成一个字符串
        Arrays.fill(arr,3);//fill(int[] arr ,int value):用value填充整个arr数组
        System.out.println("arr数组的现在状态:"+Arrays.toString(arr));//toString():把数组的元素拼接成一个字符串
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);//赋值为100以内的随机整数
        }
        System.out.println("arr数组的现在状态:"+Arrays.toString(arr));//toString():把数组的元素拼接成一个字符串
        int[] arr2 = Arrays.copyOf(arr, 10);//copeOf(int[]arr int newLength):根据原数组复制一个长度为newLength的新数组,并返回新数组
        System.out.println("新数组:"+Arrays.toString(arr2));
        System.out.println("两个数组的比较结果:"+Arrays.equals(arr, arr2));//equals(int[] a, int[] a2) ：比较两个数组的长度、元素是否完全相同
        Arrays.sort(arr);//Arrays.sort(arr):将arr数组按照从小到大进行排序
        System.out.println("arr数组的现在状态:"+Arrays.toString(arr));
    }
    /**
     * 数组反转:借助一个新数组
     */
    @Test
    public void test01(){
        int[] arr = {1,2,3,4,5};
        //1.创建一个新数组
        int[] arr1 = new int[arr.length];
        //2.复制元素
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr[arr.length-1-i];
        }
        //3.arr指向arr1
        arr = arr1;
        for (int i : arr) {
            System.out.print(i+"\t");
        }
    }
    /**
     * 数组反转:首尾对应位置交换
     */
    @Test
    public void test02(){
        int[] arr = {1,2,3,4,5};
        for(int i=0;i<arr.length/2;i++){
            int temp = 0;
            temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
        for (int i : arr) {
            System.out.print(i+"\t");
        }
    }
    /**
     * 数组扩容:当原来的数组长度不够了需要扩容,例如新增位置来存储10
     */
    @Test
    public void test03(){
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int[] newArr = new int[arr.length + 1];
        //复制元素
        for (int i = 0; i < arr.length; i++) {
            newArr[i]=arr[i];
        }
        newArr[newArr.length-1]=10;
        arr = newArr;
        for (int i : arr) {
            System.out.print(i+"\t");
        }
    }

    /**
     * 数组元素的插入:在原数组的某个[index]插入一个元素
     */
    @Test
    public void test04(){
        int[] arr = {1,2,3,4};
        int index = 1;
        //在index为1的位置插入0
        int[] arr2 = new int[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            arr2[i]=arr[i];
        }
        //a,b,c,d,e,0
        //a,1,b,c,d,e
        for(int i=arr2.length-1;i>index;i--){
            arr2[i]=arr2[i-1];
        }
        arr2[index]=0;
        for (int i : arr2) {
            System.out.print(i+"\t");
        }


    }


}
