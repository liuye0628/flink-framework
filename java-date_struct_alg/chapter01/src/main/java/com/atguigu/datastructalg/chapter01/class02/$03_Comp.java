package com.atguigu.datastructalg.chapter01.class02;

/**
 * 对数器
 */

public class $03_Comp {

    public static void main(String[] args) {
        int maxLen=20;
        int maxValue=1000;
        int textTime=10000;
        for (int i = 0; i < textTime; i++) {
            int[] arr1 = lenRandomValueRandom(maxLen, maxValue);
            int[] temp = copyArray(arr1);
            selectionSort(arr1);
            if(!isSorted(arr1)){
                for(int j =0;j< temp.length;j++){
                    System.out.println(temp[j] +" ");
                }
                System.out.println();
                System.out.println("选择排序错了");
                break;
            }

        }
    }

    public static void selectionSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for(int i = 0; i< arr.length-1; i++){
            int minIndex = i;
            for(int j= i+ 1;j< arr.length;j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            swap(arr,i,minIndex);
        }
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
     * 返回一个数组arr,arr长度[0,maxLen-1],arr中每个值[0,maxValue-1]
     * @param maxLen
     * @param maxValue
     * @return
     */
    public static int[] lenRandomValueRandom(int maxLen,int maxValue){
        int len = (int) (Math.random() * maxLen);
        int[] ans = new int[len];
        for (int i =0;i<ans.length;i++){
            ans[i] = (int)(Math.random() * maxValue);
        }
        return ans;

    }

    /**
     * 判断数组是否有序
     * @param arr
     * @return
     */

    public static boolean isSorted(int[] arr){
        if(arr.length <2) return true;
        int max = arr[0];
        for(int i =1;i<arr.length;i++){
            if(max>arr[i]){
                return false;
            }
            max = Math.max(max,arr[i]);
        }
        return true;

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
}
