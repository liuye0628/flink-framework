package com.atguigu.javase.d_api;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Random;

/**
 * Math相关的类:
 *  java.lang.Math类包含用于执行基本数学运算的方法,如初等指数,对数,平方根与三角函数,类似这样的工具类,其所有的方法都为静态方法,并且不会创建对象,使用起来非常简单
 */
public class $07_Math {
    public static void main(String[] args) {
        /**
         * Math:用于执行基本数学运算的方法
         */
        double pi = Math.PI;//返回圆周率
        System.out.println(pi);
        System.out.println(Math.abs(-7));//返回绝对值
        System.out.println(Math.ceil(3.7));//返回大于等于参数最小的整数
        System.out.println(Math.floor(3.1));//返回小于等于参数最小的整数
        System.out.println(Math.round(3.5));//返回最接近参数最小的long(相当于四舍五入法)
        System.out.println(Math.random());//返回(0,1)的随机值
        System.out.println(Math.max(8,9));//返回(a,b)的最大值
        System.out.println(Math.min(8,9));//返回(a,b)的最小值
        /**
         * Random:用于产生随机数
         */
        Random random = new Random();
        System.out.println(random.nextInt());//生成随机整数
        System.out.println(random.nextInt(6));//生成随机整数,不包含6
        /**
         * BigInteger:不可变的任意精度的整数
         */
        BigInteger b1 = new BigInteger("999999999");
        BigInteger b2 = new BigInteger("666666666");
        //System.out.println("b1+b2:"+(b1+b2));错误的,无法直接用"+"求和
        System.out.println("和" + b1.add(b2));
        System.out.println("减" + b1.subtract(b2));
        System.out.println("乘" + b1.multiply(b2));
        System.out.println("除" + b1.divide(b2));
        System.out.println("余" + b1.remainder(b2));
        /**
         * BigDecimal:不可变的,任意精度的有符号十进制数
         */
        BigDecimal d1 = new BigDecimal("234.678");
        BigDecimal d2 = new BigDecimal("134.678");
        System.out.println("和" + d1.add(d2));
        System.out.println("减" + d1.subtract(d2));
        System.out.println("乘" + d1.multiply(d2));
        System.out.println("除" + d1.divide(d2,20, RoundingMode.UP));
        System.out.println("余" + d1.remainder(d2));
    }
}
