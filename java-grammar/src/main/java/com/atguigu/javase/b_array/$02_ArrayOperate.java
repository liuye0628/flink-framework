package com.atguigu.javase.b_array;

public class $02_ArrayOperate {
    public static void main(String[] args){
        int[] arr1 = new int[]{14,25,34,49,57};
        //数组拷贝
        int[] arr2 = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }
        for(int m : arr2){
            System.out.print(m + "\t");
        }
        System.out.println();
        //数组翻转
        int[] arr3 = new int[arr1.length];
        int i =1;
        for(int n : arr1){
            arr3[arr1.length-i]=n;
            i++;
        }
        for (int i1 = 0; i1 < arr3.length; i1++) {
            System.out.print(arr3[i1] +"\t");
        }


    }
}
