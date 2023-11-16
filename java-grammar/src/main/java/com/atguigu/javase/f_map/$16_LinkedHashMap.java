package com.atguigu.javase.f_map;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * LinkedHashMap 是HashMap的子类,与HashMap的不同之处在于,后者维护着一个运行于所有条目的双重链接列表,此链接列表定义了迭代顺序,该迭代顺
 * 序通常就是将键插入到映射中的顺序(插入顺序)
 */
public class $16_LinkedHashMap {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        map.put(1,"张三");
        map.put(2,"李四");
        map.put(3,"王五");
        map.put(3,"赵六");
        map.put(null,null);
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        for (Map.Entry<Integer, String> entry : entrySet) {
            System.out.println(entry);
        }
    }
}
