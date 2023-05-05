package com.java.hpy;

class Window implements  Runnable{
    private static int ticket = 100;
    Object obj = new Object();
    @Override
    public void run() {
        while (true){
            synchronized(obj) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "票号为：" + ticket--);
                } else {
                    System.out.println("卖光了");
                    break;
                }
            }
    }
    }
}
//class Window extends Thread{
//    private static int ticket = 100;
//
//    @Override
//    public void run() {
//    while (true){
//        if(ticket > 0){
//            System.out.println(Thread.currentThread().getName() + "票号为：" + ticket--);
//        }else{
//            System.out.println("卖光了");
//            break;
//        }
//    }
//    }
//}
public class WindowTest {
    public static void main(String[] args) {
//        Window t1 = new Window();
//        Window t2 = new Window();
//        Window t3 = new Window();
//
//        t1.setName("窗口1");
//        t1.setName("窗口2");
//        t1.setName("窗口3");
//
//        t1.start();
//        t2.start();
//        t3.start();

//        Window window = new Window();
//        Thread t1 = new Thread(window);
//        Thread t2 = new Thread(window);
//        Thread t3 = new Thread(window);
//
//        t1.start();
//        t2.start();
//        t3.start();
    }
}
class Bank{
    private Bank(){

    }
   private static  Bank instance = null;
    public static  Bank getinstance(){
     if(instance == null){
         synchronized(Bank.class){
             if(instance == null){
                 instance = new Bank();
             }
         }
     }
     return instance;
    }
}
