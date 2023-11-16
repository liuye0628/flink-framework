package com.atguigu.javase.f_map;

import org.junit.Test;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * TreeMap:基于红黑树的NavigableMap实现,该映射根据其键的自然顺序进行排序,或者根据创建映射时提供的Comparator进行排序,具体取决于使用的构造方法
 */
public class $17_TreeMap {

    @Test
    public void Test01(){
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Liubei",18);
        treeMap.put("guanyu",17);
        treeMap.put("zhangfei",20);
        //String实现了Comparable接口,默认按照Unicode编码值进行排序
        Set<Map.Entry<String, Integer>> entrySet = treeMap.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            System.out.println(entry);
        }
    }

    @Test
    public void Test02(){
        //指定比较器Comparator,按照Unicode编码值进行排序,但是忽略大小写
        TreeMap<String, Integer> map = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });
        //TreeMap<String, Integer> map = new TreeMap<>();
        map.put("Liubei",18);
        map.put("guanyu",17);
        map.put("zhangfei",20);
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            System.out.println(entry);
        }


    }
}
