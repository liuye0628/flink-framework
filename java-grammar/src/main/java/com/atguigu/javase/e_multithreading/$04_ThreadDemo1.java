package com.atguigu.javase.e_multithreading;

import java.util.Scanner;

/**
 * demo1:强行加塞
 * ①主线程:打印[1,10],每隔10ms打印一个数字
 * ②自定义线程类:不停的问是否结束,输入Y或N
 * ③现在当主线程打印完5之后,就让自定义线程类加塞,直到自定义线程类结束,主线程再结束
 */
public class $04_ThreadDemo1 {
    public static void main(String[] args) {
        ChatThread t = new ChatThread();
        t.start();
        for(int i = 1; i <= 10; i++){
            System.out.println(i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i == 5){
                try {
                    t.join();//当main线程打印到5之后,需要等join进来的线程停止后才会继续了
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class ChatThread extends Thread{
    @Override
    public void run() {
        //super.run();
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("是否结束? (Y、N)");
            String next = scanner.next();
            if(("Y").equals(next) || ("y").equals(next)){
                break;
            }
        }
        scanner.close();
    }
}
