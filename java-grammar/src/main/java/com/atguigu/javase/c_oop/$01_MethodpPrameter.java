package com.atguigu.javase.c_oop;
//成员方法传参机制
public class $01_MethodpPrameter {
    public static void main(String[] args) {
        int a = 100;
        basic(a);//基本数据类型传递的是值(值拷贝),形参的改变不会影响实参
        System.out.println(a);
        int[] b = new int[]{1,3,4,5,6};
        referEnce(b);//引用数据类型传递的是地址,可以通过形参改变实参
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + "\t");
        }

    }

    public static int basic(int i ){
        return i + 100;
    }

    public static void referEnce(int[] arr){
        arr[0] =666;
    }
}
