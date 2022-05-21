package com.atguigu.javase.a_basicgrammar;

/**
 * 常量:在代码的运行过程中,值不会改变的数据
 */

public class $03_Constant {
    public static void main(String[] args){
        //整数常量:所有的整数
        System.out.println(1);
        //小数常量:所有带小数点的
        System.out.println(1.5);
        /*
        字符常量:带''的,''中必须有,且只能有一个内容
         */
        System.out.println(' ');
        System.out.println('a');
        //System.out.println('11');
        /*
        字符串常量:带""的,""里面可以随便写,有没有内容都行
         */
        System.out.println("");
        System.out.println("武松");
        //布尔常量:true,false
        System.out.println(true);
        System.out.println(false);
        //空常量:null 代表啥也不是,啥也没有,数据不存在,不能直接使用
        //System.out.println(null);会报错

        System.out.println("===============华丽的分割线==============");
        System.out.println(1+1);//2
        System.out.println(3-2.5);//0.5
        System.out.println(3*2);//6
        System.out.println(5/2);//取商
        System.out.println(5%2);//取余
        System.out.println(5.0/2);//除数或者被除数有一个为小数,那么结果就是带小数点的数据
    }
}
