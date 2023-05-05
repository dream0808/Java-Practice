package com.hpy.day03.io.exer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description: TODO
 */
public class MyInput {

    public static String readString(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String result = "";
        try {
             result = br.readLine();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    public static Integer readInt(){
        return Integer.parseInt(readString());
    }
    public static Double readDouble(){
        return Double.parseDouble(readString());
    }
    public static Long readLong(){
        return Long.parseLong(readString());
    }
}
