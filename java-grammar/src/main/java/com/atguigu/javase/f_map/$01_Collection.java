package com.atguigu.javase.f_map;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 *Collection:相关api
 */
public class $01_Collection {
    public static void main(String[] args) {

    }
    @Test
    public void test01(){
        Collection<Object> coll = new ArrayList<>();
        coll.add(1);
        coll.add(2);
        System.out.println("coll集合元素个数:"+coll.size());//add(Object j):添加元素对象到集合中
        Collection other = new ArrayList();
        other.add(1);
        other.add(2);
        other.add(3);
        //coll.add(other);
        coll.addAll(other);//addAll(Collection other):添加other集合中的所有元素对象到当前集合中
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
