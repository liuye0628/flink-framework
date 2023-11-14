package com.atguigu.javase.f_map;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ArrayList是List接口的典型实现类,底层使用长度可变的数组实现,具有查询快,增删慢的特点
 * 底层源码分析:
 *  ArrayList底层实现:可变长的数组,有索引,查询效率高,增删效率低
 *  构造方法:
 *      new ArrayList():
 *          jdk6中,空参构造直接创建10长度的数组
 *          jdk8之后:默认初始容量为0,在添加第一个元素时初始化容量为10
 *      new ArrayList(int initialCapacity):
 *          指定初始化容量
 *  添加元素: add(E e)
 *      首次添加元素,初始容量为10
 *      每次添加,修改modCount属性值
 *      每次添加检查容量是否足够,容量不足时需要扩容,扩容大小是原容量的1.5倍
 *  移除元素: remove(E e)
 *      每次成功移除元素,修改modCount值
 *      每次成功移除,需要移动元素,以保证所有元素是连续存储的(删除操作效率低的原因)
 */
public class $07_ArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("刘备");
        list.add("关羽");
        list.add("张飞");
        //需求:对list进行遍历(普通for,增强for,迭代器)

        //方式一:普通for
        System.out.println("普通for遍历");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + "\t");
        }
        System.out.println();
        //方式二:增强for
        System.out.println("增强for遍历");
        for (String name : list) {
            System.out.print(name + "\t");
        }
        System.out.println();
        //方式三:迭代器
        System.out.println("迭代器遍历");
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            System.out.print(next+"\t");
        }
    }

}
