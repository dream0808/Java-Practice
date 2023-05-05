package com.java.hpy;

class MyThread1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}
public class ThreadTest {
    public static void main(String[] args) {
        MyThread1 m1 = new MyThread1();
        new Thread(m1).start();
    }
}
