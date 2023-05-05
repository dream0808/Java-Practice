package com.hpy.day03.io;

import org.junit.Test;

import java.io.*;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description: TODO
 */
public class OtherStreamTest {

    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        while(!scanner.hasNext("exit")){
//            System.out.println(scanner.next().toUpperCase());
//        }
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        while(true){
            String data= br.readLine();
            if("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)){
                System.out.println("exit");
                break;
            }
            System.out.println(data.toUpperCase());
        }
        br.close();
    }

    /**
     * 1.标准的输入、输出流
     * System.in:标准的输入流，默认从键盘输入
     * System.out:标准的输出流，默认从控制台输出
     *
     * System类的setIn(InputStream s) / setOut(PrintStream ps)方式重新指定输入和输出的流。
     */
    @Test
    public void test1() throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
        dos.writeUTF("蔡徐坤");
        dos.writeInt(23);
        dos.writeBoolean(true);

        dos.close();

    }

    /**
     * 注意点：读取不同类型的数据的顺序要与当初写入文件时，保存的数据的顺序一致！
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        DataInputStream dit = new DataInputStream(new FileInputStream("data.txt"));
        String name = dit.readUTF();
        int age = dit.readInt();
        boolean isWoman = dit.readBoolean();

        dit.close();
        System.out.println(name);
        System.out.println(isWoman);
        System.out.println(age);
    }
}
