package com.atguigu.javase.f_map;

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * java.util.map<k,v>:java提供的专门存放映射关系的集合
 * map与collection的不同:
 *  ①collection中的集合,元素是孤立存在的(理解为单身),向集合中存储元素采用一个个元素的方式存储
 *  ②map中的集合,元素是成对存在的(理解为夫妻),每个元素由键和值两部分组成,通过键可以找到对应的值
 *  ③collection中的集合称为单列集合,map中的集合称为双列集合
 *  ④需要注意的是,map集合中不能包含重复的键,值可以重复,每个键只能对应一个值,这个值可以是单个值,也可以是数组或集合值
 */
public class $14_Map {


    /**
     * map常用方法
     */
    @Test
    public void Test01(){
        //创建map对象
        HashMap<Integer, String> map = new HashMap<>();
        /*
        添加操作:
            · V put(K key ,V value)
            · void putAll(Map<? extends K,? extends V> m)
            ①使用put方法时,若指定的键(key)在集合中没有,则没有这个键对应的值,返回null,并把指定的键值添加到集合中
            ②若指定的键(key)在集合中存在,则返回值为集合中键对应的值(该值为替换前的值),并把指定的键所对应的值,替换成指定的新值
         */
        map.put(1,"刘备");
        map.put(2,"关羽");
        map.put(3,"张飞");
        map.put(4,"张飞");
        System.out.println(map);

        /*
        删除元素操作:
            · void clear()
            · V remove(Object key)
         */
        map.remove(2);
        System.out.println(map);

        /*
        元素查询操作:
            · V get(Object key)
            · boolean containsKey(Object key)
            · boolean containsValue(Object value)
            · boolean isEmpty()
         */
        String s = map.get(1);
        boolean s1 = map.containsKey(1);
        boolean s2 = map.containsValue("刘备");
        boolean s3 = map.isEmpty();
        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        /*
        元视图操作的方法:
            · Set keySet()
            · Collection values()
            · Set<Map.Entry<K,V>> entrySet()
         */
        Set<Integer> keySet = map.keySet();
        System.out.println(keySet);
        Collection<String> values = map.values();
        System.out.println(values);
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        System.out.println(entries);
        /*
        其他方法:
            · int size()
         */
        System.out.println(map.size());
    }


    /**
     * map集合的遍历
     *  map的遍历不能支持foreach,因为map接口没有继承java.lang.Iterable接口,也没有实现Iterator iterator(),只能由如下方式遍历:
     *      ①分开遍历:单独遍历所有key,在单独遍历所有value
     *      ②成对遍历:遍历Map.Entry类型的对象
     */
    @Test
    public void Test02(){
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"刘备");
        map.put(2,"关羽");
        map.put(3,"张飞");
        //map.forEach((k,v)-> System.out.println(k+"->"+v));
        //①分开遍历
        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            System.out.println(key +"->"+map.get(key));
        }
        //②成对遍历
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        for (Map.Entry<Integer, String> entry : entrySet) {
            System.out.println(entry.getKey()+"->"+entry.getValue());
        }

    }
}
