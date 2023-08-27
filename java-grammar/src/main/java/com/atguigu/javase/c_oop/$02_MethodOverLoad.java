package com.atguigu.javase.c_oop;
//方法重载
public class $02_MethodOverLoad {
    /*
    * 方法重载 :方法名相同,参数列表不同
    *   1.方法名必须相同
    *   2.形参列表必须不同(形参类型,个数或顺序,至少有一个不同,参数名无要求)
    *   3.返回类型无要求
    * */
    public static void main(String[] args) {
        myAdd(1,2);
        myAdd(1,2,3);
        //可变参数
        sum(1,2,3);
        sum(1,2,3,4);
    }
    //需求:定义方法 完成2个整数相加,3个整数相加
    public static void myAdd(int a,int b){
        System.out.println(a+b);
    }
    public static void myAdd(int a, int b,int c){
        System.out.println(a+b+c);
    }
    /**
     * 可变参数:java允许将一个类中同名同功能,但参数个数不同的方法封装为一个方法
     *  1.可变参数的本质就是一个数组
     *  2.可变参数可以和普通类型的参数放在一个形参列表,但必须保证可变参数在最后
     *  3.一个形参列表只能出现一个可变参数
     */
    public static void sum(int... nums){
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        System.out.println(total);
    }


}
