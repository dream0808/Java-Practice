package com.java.hpy;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoll {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new NumberThread());
        executorService.shutdown();
    }
}
class NumberThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if(i % 2 ==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}