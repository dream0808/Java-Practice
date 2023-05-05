package com.java.hpy;

class Account{
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }
    public synchronized void deposit(double amt){
        if(amt > 0){
            balance +=amt;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "存钱成功，余额：" + balance);
        }
    }
}
class Customer extends Thread{
    private Account account ;

    public Customer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.deposit(1000);
        }
    }
}
public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(0);
        Customer customer1 = new Customer(account);
        Customer customer2 = new Customer(account);

        customer1.setName("甲");
        customer2.setName("乙");

        customer2.start();
        customer1.start();
    }
}
