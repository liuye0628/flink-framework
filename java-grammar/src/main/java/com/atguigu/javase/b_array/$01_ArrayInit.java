package com.atguigu.javase.b_array;

public class $01_ArrayInit {
    public static void main(String[] args) {
        /**
         * 数组特点:
         *  定长:才度固定,数组在定义之后,后续不能改变数组的长度
         *  数据类型:既能存储基本类型,还能存储引用数据类型的数据
         */

        //静态初始化
        int [] arr = new int[]{1,2,3,4,5};
        //动态初始化
        int [] arr2 = new int[4];
        arr2[0] = 1;
    }
}
