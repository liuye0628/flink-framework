package com.atguigu.javase.b_array;
/*
    二维数组
 */
public class $04_TwoDimensionalArray {
    public static void main(String[] args){

        //二维数组动态初始化
        int arrInit[][] = new int[3][4];//表示该二维数组中有三个一维数组,每个一维数组中最多有四个元素
        //二维数组静态初始化
        int [][] arr = {{1,5,7},{2,8,9,0},{2,7}};
        //获取二维数组长度
        System.out.println(arr.length);
        System.out.println(arr[2].length);
        //获取二维数组中的元素
        System.out.println(arr[0][1]);
        //遍历二维数组
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();

        }

    }
}
