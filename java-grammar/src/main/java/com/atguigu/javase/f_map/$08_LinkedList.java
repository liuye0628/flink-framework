package com.atguigu.javase.f_map;

import org.junit.Test;

import java.util.LinkedList;

/**
 * LinkedList是List接口的另一个常用实现类,底层存储数据使用链表结构(双向链表,特点:增删快,查询慢)
 */
public class $08_LinkedList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("刘备");// void addFirst(Object obj)
        list.add("关羽");//等同于addLast()
        list.addLast("张飞");// void addLast(Object obj)
        System.out.println(list);
        System.out.println(list.get(1));
        System.out.println(list.getFirst());//Object getFirst()
        System.out.println(list.getLast());//Object getLast()
        list.removeFirst();//Object removeFirst()
        list.removeLast();//Object removeLast()
        System.out.println(list);
    }


    /**
     * LinkedList也实现了Deque接口(双端队列),此接口提供了实现
     *      队列:是一种抽象的数据结构,数据存取特点是先进先出(FIFO),LinkedList中的队列方法
     *          · boolean offer(Object obj): 入队
     *          · Object poll(): 出队
     *          · Object peek(): 检查
     *      栈:是一种抽象的数据结构,数据存取的特点是后进先出(LIFO),LinkedList中的栈方法
     *          · void push(E e): 压栈
     *          · E pop(): 弹栈
     */
    @Test
    public void test(){
        System.out.println("--------队列----------");
        LinkedList<String> list1 = new LinkedList<>();
        list1.offer("刘备");
        list1.offer("关羽");
        list1.offer("张飞");
        System.out.println(list1);
        System.out.println(list1.poll());
        System.out.println(list1);
        String peek = list1.peek();
        System.out.println(peek);

        System.out.println("----------栈----------");
        LinkedList<String> list2 = new LinkedList<>();
        list2.push("刘备");
        list2.push("关羽");
        list2.push("张飞");
        System.out.println(list2);
        String pop = list2.pop();
        System.out.println(pop);
        System.out.println(list2);


    }

}
