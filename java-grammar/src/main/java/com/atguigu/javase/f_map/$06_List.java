package com.atguigu.javase.f_map;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * java.util.List 接口继承自Collection接口,是单列集合的一个重要分支
 * List接口特点:
 *      ①List集合中所有的元素是以一种线性方式进行存储的,例如,存元素的顺序是11,22,33,那么集合中,元素的存储就是按照11,22,33的顺序完成的
 *      ②它是一个元素存取有序的集合,即元素的存入顺序和取出顺序有保证
 *      ③它是一个带有索引的集合,通过索引可以精确的操作集合中的元素
 *      ④集合中可以有重复的元素,通过元素的equals方法,来比较是否为重复的元素
 * List除了从Collection集合继承的方法外,List集合中添加了一些根据索引来操作集合元素的方法
 */
public class $06_List {
    /**
     * 添加元素
     *  · void add(int index,E ele)
     *  · boolean addAll(int index,Collection<? extends E> eles)
     */
    @Test
    public void Test01(){
        List<String> list = new ArrayList<>();
        list.add("刘备");
        list.add("诸葛亮");
        list.add("关羽");
        System.out.println(list);
        list.add(1,"张飞");//往指定位置添加
        System.out.println(list);
    }

    /**
     * 删除和替换元素
     *  ·E remove(int index)
     *  ·E set(int index,E ele)
     */
    @Test
    public void Test02(){
        List<String> list = new ArrayList<>();
        list.add("刘备");
        list.add("诸葛亮");
        list.add("关羽");
        System.out.println(list);
        String s = list.remove(1);//删除索引位置为1的元素
        System.out.println(s);
        System.out.println(list);
        list.set(1,"赵云");//修改指定位置元素
        System.out.println(list);

    }


    /**
     * 获取元素/元素索引
     *  ·E get(int index)
     *  ·E subList(int fromIndex,int toIndex)
     *  ·int indexOf(Object obj)
     *  ·int LastIndexOf(Object obj)
     */
    @Test
    public void Test03(){
        List<String> list = new ArrayList<>();
        list.add("刘备");
        list.add("诸葛亮");
        list.add("关羽");
        list.add("刘备");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+"\t");
        }
        System.out.println();
        List<String> subList = list.subList(1, 3);//[1,3)
        System.out.println(subList);
        System.out.println(list.indexOf("刘备"));
        System.out.println(list.lastIndexOf("刘备"));


    }
}
