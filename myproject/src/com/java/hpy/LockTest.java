package com.java.hpy;

import java.util.concurrent.locks.ReentrantLock;

class Window2 implements  Runnable{
    private  int ticket = 100;
    private ReentrantLock lock =  new ReentrantLock();
    @Override
    public void run() {

        while (true) {
          try{
              lock.lock();
              if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + "票号为：" + ticket--);
                } else {
//                    System.out.println("卖光了");
                    break;
                }
          }finally{
              lock.unlock();
          }
            }

    }
}
public class LockTest {
    public static void main(String[] args) {
        Window2 w1 = new Window2();

        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.start();
        t2.start();
        t3.start();
    }
}
