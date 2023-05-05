package com.java.hpy;

class MyThread extends Thread{
    @Override
    public void run() {

    }
}
public class ThreadDemo {
    public static void main(String[] args) {
        new MyThread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if(i % 2 == 0){
                        System.out.println(i);
                    }
                }
            }
        }.start();
        new MyThread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if(i % 2 != 0){
                        System.out.println(i);
                    }
                }
            }
        }.start();
    }
}
