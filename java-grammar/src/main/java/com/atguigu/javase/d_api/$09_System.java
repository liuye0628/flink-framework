package com.atguigu.javase.d_api;
//系统相关类
public class $09_System {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();//返回当前系统时间距离1970年1月1日 0:0:0的毫秒值
        System.out.println(time);//1694694215664
        System.exit(0);//退出当前系统
        System.out.println("over");//不会执行

    }
}
