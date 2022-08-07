package com.atguigu.datastructalg.chapter01.class01;

import java.util.Arrays;

/**
 * 实现插入排序
 */
public class $06_InsertionSort {
    public static void main(String[] args) {
        int testTime = 10;
        int maxSize = 10;
        int maxValue = 10;
        boolean succeed = true;
        /*for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            bubbleSort(arr1);
            comparator(arr2);
            if(!isEqual(arr1,arr2)){
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
            System.out.println(succeed ? "Nice!":"Fucking Fucked!");
        }*/
        int[] arr1 = generateRandomArray(maxSize, maxValue);
        printArray(arr1);
        InsertionSort(arr1);
        printArray(arr1);


    }

    /**
     * 插入排序
     * @param arr
     */
    public static void InsertionSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for (int end = 1;end<arr.length;end++){
            int newNumIndex = end;
            while(newNumIndex-1>=0 && arr[newNumIndex-1]>arr[newNumIndex]){
                swap(arr,newNumIndex-1,newNumIndex);
                newNumIndex--;
            }
        }
    }
    //for test
    public static void comparator(int[] arr){
        Arrays.sort(arr);
    }

    /**
     * 生成随机数组
     * @param maxSize
     * @param maxValue
     * @return
     */
    public static int[] generateRandomArray(int maxSize, int maxValue){
        int[] arr = new int[(int)((maxSize +1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)((maxValue+1) * Math.random()) - (int)((maxValue+1) * Math.random());
        }
        return arr;

    }

    /**
     * 数组复制
     * @param arr
     * @return
     */
    public static int[] copyArray(int[] arr){
        if(arr == null){
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;

    }

    /**
     * 判断两个数组中各个位置的元素是否相等
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isEqual(int[] arr1,int[] arr2){
        if((arr1==null && arr2!= null)||(arr1!=null && arr2== null)){
            return false;
        }
        if(arr1 == null && arr2 == null){
            return false;
        }
        if(arr1.length != arr2.length){
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;

    }


    /**
     * 交换数组对应下标的值
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i,int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    /**
     * 将数组进行遍历打印
     * @param arr
     */
    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
