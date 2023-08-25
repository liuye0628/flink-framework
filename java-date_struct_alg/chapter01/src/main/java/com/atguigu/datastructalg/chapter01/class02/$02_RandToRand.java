package com.atguigu.datastructalg.chapter01.class02;

/**
 * 随机函数
 */
public class $02_RandToRand {
    public static void main(String[] args) {
        System.out.println("测试开始");
        int testTimes = 10000000;
        int count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (Math.random()<0.8) {
                count++;
            }
        }
        System.out.println((double)count/(double)testTimes);
        System.out.println("-------------------------");

        int K = 9;
        int[] counts = new int[K];
        for (int i =0;i<testTimes;i++){
            int ans = (int)(Math.random() * K); //[0,8]
            counts[ans]++;
        }
        for (int i = 0; i < K; i++) {
            System.out.println(i + "这个数出现了" + counts[i] + "次");
        }
        System.out.println("-------------------------");
        count = 0;
        double x = 0.23;
        for (int i = 0; i < testTimes; i++) {
            if(xtoXPower2()<x){
                count++;
            }
        }
        System.out.println((double)count/(double)testTimes);
        System.out.println(Math.pow(x,2));
    }

    /**
     * 返回[0,1)的一个小数,任意的x,x属于[0,1),出现的概率为x的平方
     * @return
     */
    public static double xtoXPower2(){
        return Math.max(Math.random(),Math.random());
    }
}
