package com.atguigu.javase.f_map;

import java.util.ArrayList;

/**
 * ①modCount与fail-fast机制
 *      当使用foreach或iterator迭代器遍历集合时,同时调用迭代器自身以外的方法修改了集合的结构,例如调用集合的add和remove方法,就会报Concurr
 *  entModificationException,因此面对并发的修改,迭代器很快就完全失败,而不是冒着将来不确定的时间任意发生不确定行为的风险
 *      这样设计是因为,迭代器代表集合中某个元素的位置,内部会存储某些能代表该位置的信息,当集合发生改变时,该信息的含义可能会发生变化,这时操作迭代器就可能
 *  会造成不可预料的事情,因此,果断抛异常阻止,是最好的方法,这就是Iterator迭代器的快速失败(fail-fast)机制
 *      注意:迭代器的快速失败行为不能得到保证,一般来说,存在不同步的并发修改时,不可能做出任何坚决的保证,快速失败迭代器尽最大努力抛出Concurr
 * entModificationException,因此,编写依赖于异常的程序的方式是错误的,正确做法是:迭代器的快速失败的行为应该仅用于检测bug
 *
 *
 * ②如何实现快速失败(fail-fast)机制呢
 *      ·在ArrayList等集合类中都有一个modCount变量,它用来记录集合的结构被修改的次数
 *      ·当我们给集合添加和删除操作时,会导致modCount++
 *      ·然后当我们用Iterator迭代器遍历集合时,创建集合迭代器的对象时,用一个变量来记录当前集合的modCount,例如: int expectedModCount,
 *      并且在迭代器每次next()迭代元素时,都要检查expectedModCount != modCount;如果不相等了,那么说明你调用的Iterator迭代器以外的Collection
 *      的add,remove方法,修改了集合结构,使得modCount++,值变了,就会抛出ConcurrentModificationException
 *
 */
public class $04_FailFast {

    //ArrayList的Itr迭代器
    /**
     *  private class Itr implements Iterator<E> {
     *         int cursor;       // index of next element to return
     *         int lastRet = -1; // index of last element returned; -1 if no such
     *         int expectedModCount = modCount;//在创建迭代器时,expectedModCount初始化为当前集合的modCount的值
     *
     *         Itr() {}
     *
     *         public boolean hasNext() {
     *             return cursor != size;
     *         }
     *
     *         @SuppressWarnings("unchecked")
     *         public E next() {
     *             checkForComodification();//检验expectedModCount与modCount是否相等
     *             int i = cursor;
     *             if (i >= size)
     *                 throw new NoSuchElementException();
     *             Object[] elementData = ArrayList.this.elementData;
     *             if (i >= elementData.length)
     *                 throw new ConcurrentModificationException();
     *             cursor = i + 1;
     *             return (E) elementData[lastRet = i];
     *         }
     *
     *         public void remove() {
     *             if (lastRet < 0)
     *                 throw new IllegalStateException();
     *             checkForComodification();
     *
     *             try {
     *                 ArrayList.this.remove(lastRet);
     *                 cursor = lastRet;
     *                 lastRet = -1;
     *                 expectedModCount = modCount;
     *             } catch (IndexOutOfBoundsException ex) {
     *                 throw new ConcurrentModificationException();
     *             }
     *         }
     *
     *         @Override
     *         @SuppressWarnings("unchecked")
     *         public void forEachRemaining(Consumer<? super E> consumer) {
     *             Objects.requireNonNull(consumer);
     *             final int size = ArrayList.this.size;
     *             int i = cursor;
     *             if (i >= size) {
     *                 return;
     *             }
     *             final Object[] elementData = ArrayList.this.elementData;
     *             if (i >= elementData.length) {
     *                 throw new ConcurrentModificationException();
     *             }
     *             while (i != size && modCount == expectedModCount) {
     *                 consumer.accept((E) elementData[i++]);
     *             }
     *             // update once at end of iteration to reduce heap write traffic
     *             cursor = i;
     *             lastRet = i - 1;
     *             checkForComodification();
     *         }
     *
     *         final void checkForComodification() {
     *             if (modCount != expectedModCount)//检验expectedModCount与modCount是否相等
     *                 throw new ConcurrentModificationException();//不相等,抛异常
     *         }
     *     }
     */
}
