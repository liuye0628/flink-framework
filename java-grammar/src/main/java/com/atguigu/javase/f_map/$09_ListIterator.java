package com.atguigu.javase.f_map;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * List集合额外提供了一个listIterator()方法,该方法返回一个ListIterator对象,ListIterator接口继承了Iterator接口,提供了专门操作List的方法
 *  void add()：通过迭代器添加元素到对应集合
 *  void set(Object obj)：通过迭代器替换正迭代的元素
 *  void remove()：通过迭代器删除刚迭代的元素
 *  boolean hasPrevious()：如果以逆向遍历列表，往前是否还有元素。
 *  Object previous()：返回列表中的前一个元素。
 *  int previousIndex()：返回列表中的前一个元素的索引
 *  boolean hasNext()
 *  Object next()
 *  int nextIndex()
 */
public class $09_ListIterator {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("刘备");
        list.add("关羽");
        list.add("张飞");
        //从指定的位置往前遍历
        ListIterator<String> listIterator = list.listIterator(list.size());
        while(listIterator.hasPrevious()){
            String previous = listIterator.previous();
            System.out.println(previous);
        }
    }
}
