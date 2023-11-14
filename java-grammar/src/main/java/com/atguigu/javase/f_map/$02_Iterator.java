package com.atguigu.javase.f_map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Iterator迭代器相关api
 *      在程序开发中,经常需要遍历集合中的所有元素,针对这种需求,jdk专门提供了一个接口 java.util.Iterator Iterator也是java集合中的一员,与Collection和Map
 *      不同的是,Collection与Map接口主要用于存储元素,而Iterator主要用于迭代访问(遍历)Collection中的元素,因此Iterator对象也被称为迭代器
 */
public class $02_Iterator {

    public static void main(String[] args) {
        /*
        迭代:即Collection集合元素通用的获取方式,在取元素之前先判断集合中有没有元素,如果有,就把元素取出来,继续再判断,如果还有就再取出来,一直把集合中的
        所有元素都取出来,这种取出方式专业术语称为迭代
         */

        Collection<String> list = new ArrayList<>();
        //添加元素到集合
        list.add("孙悟空");
        list.add("齐天大圣");
        list.add("猪八戒");
        //使用迭代器遍历,每个集合对象都有自己的迭代器
        Iterator<String> iterator = list.iterator();// public Iterator iterator():获取集合对应的迭代器,用来遍历集合中的元素
        while(iterator.hasNext()){//判断是否存在迭代元素
            String next = iterator.next();
            System.out.println(next);
        }
        //iterator对象在遍历集合时,内部采用指针的方式来跟踪集合中的元素,在调用iterator的next()方法之前,迭代器的索引位于第一个元素之前,指向第一个元素,当第一次调用迭代器的next()
        //方法时,返回第一个元素,然后迭代器的索引会向后移动一位,指向第二个元素
    }
}
