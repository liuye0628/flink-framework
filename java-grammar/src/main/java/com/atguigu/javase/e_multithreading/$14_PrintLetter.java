package com.atguigu.javase.e_multithreading;

/**
 * 需求:要求两个线程,同时打印字母,每个线程都能连续打印3个字母,两个线程交替打印,一个线程打印字母的小写形式,一个线程打印字母的大写形式,
 * 但是字母是连续的,当字母循环到z之后,回到a
 */
public class $14_PrintLetter {
    public static void main(String[] args) {
        //2.创建资源对象
        PrintLetter letter = new PrintLetter();
        //创建两个线程打印
        new Thread("小写字母"){
            @Override
            public void run() {
                //super.run();
                while(true){
                    letter.printLower();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        new Thread("大写字母"){
            @Override
            public void run() {
                //super.run();
                while(true){
                    letter.printUpper();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
//1.定义资源类
class PrintLetter{
    private char letter = 'a';
    public synchronized void printLower(){
        for(int i = 1;i<=3;i++){
            System.out.println(Thread.currentThread().getName()+"->"+letter);
            letter++;
            if(letter > 'z'){
                letter = 'a';
            }
        }
        this.notify();
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public synchronized void printUpper(){
        for(int i = 1;i<=3;i++){
            System.out.println(Thread.currentThread().getName()+"->"+(char)(letter-32));
            letter++;
            if(letter > 'z'){
                letter = 'a';
            }
        }
        this.notify();
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
