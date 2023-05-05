package com.test.hpy;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description: TODO
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
        System.out.println(reverse(1534236469));
    }
    public static int mySqrt(int a){
        long x = a;
        while(x*x > a){
            x = (x + a/x) /2;
        }
        return (int) x;
    }
    public static int reverse(long x){
        long digit = 0;
        long sum = 0;

        while(x  != 0){
            if(x >= 214748364  || x <= -214748364){
                return 0;
            }
            digit = x%10;
            sum=sum*10 + digit;
            x/=10;
        }
        return (int) sum;
    }
}
