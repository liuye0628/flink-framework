package com.atguigu.javase.f_map;

import java.util.Properties;

/**
 * Properties是Hashtable的子类,Properties可保存在流中或从流中加载,属性列表中每个键及其对应值都是一个字符串
 */
public class $18_Properties {
    public static void main(String[] args) {
        Properties properties = System.getProperties();
        String property = properties.getProperty("file.encoding");
        System.out.println(property);
    }
}
