package com.atguigu.datastructalg.chapter01.class02;

/**
 * 实现数组arr索引从L到R的累加和
 */

public class $01_PreSum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(RangeSum(arr,2,4));
        System.out.println(RangeSum2(arr,2,4));

    }

    /**
     * 实现方式一:对数组遍历从L到R累计求和
     * @param arr
     * @param L
     * @param R
     * @return
     */
    public static int RangeSum(int[] arr,int L,int R){
        int sum = 0;
        for(int i = L; i<=R;i++){
            sum+=arr[i];
        }
        return sum;
    }

    /**
     * 实现方式二:前缀和数组
     * @param arr
     * @param L
     * @param R
     * @return
     */
    public static int RangeSum2(int[] arr,int L,int R){
        int[] preSum= new int[arr.length];
        preSum[0] = arr[0];
        for(int i =1;i< arr.length;i++){
            preSum[i] = preSum[i-1] + arr[i];
        }
        return L==0 ? preSum[R]:preSum[R]-preSum[L-1];

    }
}
