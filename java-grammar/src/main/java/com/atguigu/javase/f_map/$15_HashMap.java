package com.atguigu.javase.f_map;




import java.util.HashMap;
import java.util.Hashtable;

/**
 * HashMap是map接口使用频率最高的实现类
 * 构造方法:
 *  · HashMap();
 *  · HashMap(int initialCapacity):指定初始化容量
 */
public class $15_HashMap {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"刘备");
        map.put(2,"关羽");
        map.put(3,"张飞");
        System.out.println(map);
        map.put(3,"赵云");//key相同,新的value会覆盖原来的value
        System.out.println(map);
        map.put(null,null);//HashMap支持key和value为null值
        System.out.println(map);


        /*
        HashMap与Hashtable的区别与联系:
            ①HashMap与Hashtable都是哈希表
            ②HashMap与Hashtable判断两个key相等的标准是:两个key的hashCode值相等,并且equals()方法也返回true,因此,为了成功的在哈希表中存储
            和获取对象,用作键的对象必须重写hashCode方法和equals
            ③Hashtable是线程安全的,key和value不允许为null
            ④HashMap是线程不安全的,key和value允许为null
         */
    }
}
