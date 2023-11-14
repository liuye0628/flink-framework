package com.atguigu.javase.f_map;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 底层结构:里面维护了一个TreeMap,都是基于红黑树实现的,红黑树是二叉树的一种,查询效率高于链表
 * 特点:
 *      ①元素唯一
 *      ②实现排序(取出的元素是经过排序的)
 *  TreeSet实现唯一和排序:里面的元素必须是可以进行比较的,要么元素本身实现Comparable接口,要么给TreeSet容器传入一个实现了Comparable接口的比较器,使其可以对存入的元素进行对比
 *  ------------------------------------------------
 *  Java提供的核心类很多都实现了Comparable接口比如常见的String类，包装类，日期类等
 *      BigDecimal、BigInteger 以及所有的数值型对应的包装类：按它们对应的数值大小进行比较
 *      Character：按字符的 unicode值来进行比较
 *      Boolean：true 对应的包装类实例大于 false 对应的包装类实例
 *      String：从第一个字符开始，比较每一个字符，如果字符都相同再比较长度。
 *      Date、Time：比较毫秒值，后边的时间、日期比前面的时间、日期大
 */
public class $13_TreeSet {
    /**
     * 一.元素实现Comparable接口
     * 例如:按照字符串Unicode编码值排序
     */
    @Test
    public void Test01(){
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("zhangsan");
        treeSet.add("lisi");
        treeSet.add("wangwu");
        treeSet.add("zhangsan");
        System.out.println("元素个数:"+treeSet.size());
        for (String name : treeSet) {
            System.out.println(name);
        }
    }

    /**
     * 二.TreeSet传入实现Comparator实现类
     * 如果元素类型没有实现Comparable接口,那么在创建TreeSet时,可以单独指定一个Comparator的对象,使用定制排序判断两个元素相等的标准
     * 是:通过Comparator比较两个元素返回了0
     */
    @Test
    public void Test02(){
        TreeSet<A> treeSet = new TreeSet<>(new Comparator<A>() {
            @Override
            public int compare(A o1, A o2) {
                return o1.getId() - o2.getId();
            }
        });
        treeSet.add(new A(1,"刘备"));
        treeSet.add(new A(3,"关羽"));
        treeSet.add(new A(2,"张飞"));
        treeSet.add(new A(1,"刘玄德"));
        System.out.println("元素个数:"+treeSet.size());
        for (A a : treeSet) {
            System.out.println(a);
        }
        /**
         * TreeSet存取元素规则:
         *  TreeSet存储元素时根据当前加入元素与已有元素比较的结果决定元素加入的位置:
         *      ①结果为负数,元素放左边
         *      ②结果为整数,元素放右边
         *      ③结果为0,则覆盖原值
         *  取元素时,采用中序遍历的方式,季左中右顺序取出二叉树中元素
         */

    }
}
