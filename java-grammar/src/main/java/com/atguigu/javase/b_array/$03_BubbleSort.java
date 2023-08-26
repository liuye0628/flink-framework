package com.atguigu.javase.b_array;

public class $03_BubbleSort {
    /*
    冒泡排序
    */
    int maxSize = 5;
    int maxValue = 100;
    public static void main(String[] args) {
        $03_BubbleSort sort = new $03_BubbleSort();
        int[] arr2 = sort.generateArray(sort.maxSize, sort.maxValue);
        for (int i : arr2) {
            System.out.print(i + "\t");
        }
        System.out.println();
        System.out.println("=====排序后=====");

        //  a b c d e
        for(int i = 0; i < arr2.length -1;i++){
            for(int j = 0; j < arr2.length -1 -i;j++){
                if(arr2[j] > arr2[j+1]){
                    int temp = arr2[j];
                    arr2[j] = arr2[j+1];
                    arr2[j+1] = temp;
                }
            }
        }
        for (int i : arr2) {
            System.out.print(i + "\t");
        }

    }

    public int[] generateArray(int maxSize, int maxValue){

        int[] arr = new int[maxSize];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * maxValue +1);
        }
        return arr;
    }
}
