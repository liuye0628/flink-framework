package com.atguigu.javase.f_map;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 *Collection:相关api
 * Collection:表示一组对象,这些对象也称为collection的元素,jdk不提供此接口的任何直接实现,它提供更具体的子接口(如set,list,queue)实现
 * Collection是所有单列集合的父接口(集合根接口,存储一组对象)
 *     一. List:接口特点是元素可重复,有序(存取顺序一致)
 *          ①ArrayList:底层结构为数组,查询快,增删慢,线程不安全
 *          ②LinkedList:底层结构为链表,查询慢,增删快
 *          ③Vector:底层结构是数组,线程安全,效率低,不推荐使用
 *     二.Set:接口特点是元素唯一
 *          ①HashSet:底层结构是Hash表,查询和增删效率都高
 *          ②LinkedHashSet:底层结构为Hash表+链表,链表保证元素的有序
 *          ③TreeSet:底层结构是红黑树,查询效率高于链表,增删效率高于数组,元素实现排序
 *
 */
public class $01_Collection {
    public static void main(String[] args) {

    }
    @Test
    public void test01(){
        Collection<Object> coll = new ArrayList<>();
        coll.add(1);
        coll.add(2);
        coll.add(3);
        System.out.println("coll集合元素个数:"+coll.size());//add(Object j):添加元素对象到集合中
        Collection other = new ArrayList();
        other.add(1);
        other.add(2);
        other.add(4);

        //coll.add(other);
        coll.addAll(other);//addAll(Collection other):添加other集合中的所有元素对象到当前集合中
        System.out.println("coll集合元素个数:"+coll.size());
        coll.retainAll(other);//retainAll(Collection other):保留交集
        System.out.println("coll集合元素个数:"+coll.size());

    }
    @Test
    public void test02(){
        Collection<String> coll = new ArrayList<>();
        coll.add("李白");
        coll.add("李白");
        coll.add("鲁班七号");
        coll.add("荆轲");
        System.out.println(coll);
        System.out.println("集合中有"+coll.size()+"个元素");//size():集合中有几个元素
        System.out.println("判李白是否在集合中:"+coll.contains("李白"));//boolean contains(Object obj):判断当前集合中是否存在一个与obj对象equals返回turn的元素
        System.out.println("删除荆轲:"+coll.remove("荆轲"));//boolean remove(Object obj):从当前集合中删除第一个找到与obj对象equals返回trun的元素
        System.out.println("操作之后的元素:"+coll);
        Object[] objects = coll.toArray();//toArray():转换为数组
        for (int i = 0; i < objects.length; i++) {
            System.out.print(objects[i]+"\t");
        }
        System.out.println();
        coll.clear();//clear():清空集合
        System.out.println("集合中的内容为:"+coll);
        System.out.println(coll.isEmpty());//isEmpty();判断集合是否为空

    }

}
