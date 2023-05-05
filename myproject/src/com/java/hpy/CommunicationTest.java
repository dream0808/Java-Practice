package com.java.hpy;

class Number implements  Runnable{
    private int number = 1;
    @Override
    public void run() {
        while(true){
            synchronized(this) {

                notify();

                if (number <= 100) {
                    System.out.println(Thread.currentThread().getName()+":" +  number);
                    number++;

                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    break;
                }
            }
        }
    }
}
public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();
            Thread t1 = new Thread(number);
            Thread t2 = new Thread(number);

            t1.setName("线程1");
            t2.setName("线程2");

           t1.start();
           t2.start();
    }
}
