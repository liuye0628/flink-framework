package com.atguigu.javase.f_map;

import java.util.LinkedHashSet;

/**
 * LinkedHashSet是HashSet的子类,他在HashSet的基础上,在结点中增加了两个属性before和after维护了结点的前后添加顺序
 * java.util.LinkedHashSet,它是链表和哈希表组合的一个数据存储结构,LinkedHashSet插入性能略低于HashSet,但在迭代访问
 * Set里的全部元素时有很好的性能
 */
public class $12_LinkedHashSet {
    public static void main(String[] args) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("刘备");
        linkedHashSet.add("关羽");
        linkedHashSet.add("张飞");
        linkedHashSet.add("刘备");
        System.out.println("元素个数:"+linkedHashSet.size());
        for (String name : linkedHashSet) {
            System.out.println(name);
        }
    }
}
