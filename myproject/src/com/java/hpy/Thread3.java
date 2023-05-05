package com.java.hpy;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class NumThread implements Callable{
private int sum = 0;
    @Override
    public Object call() throws Exception {
        for (int i = 1; i <= 100 ; i++) {
            if(i % 2 == 0){
                 sum += i;
            }
        }
        return sum;
    }

}
public class Thread3 {
    public static void main(String[] args) {
        NumThread numThread = new NumThread();
        FutureTask futureTask = new FutureTask(numThread);
        new Thread(futureTask).start();
        try {
            Object sum = futureTask.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
