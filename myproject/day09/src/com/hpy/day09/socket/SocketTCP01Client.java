package com.hpy.day09.socket;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description:
 * 客户端
 */
public class SocketTCP01Client {
    public static void main(String[] args) {
        OutputStream outputStream = null;
        InputStream inputStream = null;
        Socket socket = null;
        try {
            socket = new Socket(InetAddress.getLocalHost(), 9999);
            outputStream = socket.getOutputStream();
            outputStream.write("Hello,Server".getBytes());
            System.out.println("客户端退出");

            socket.shutdownOutput();//设置写入结束标记
            inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int len;
            while((len = inputStream.read(buffer)) != -1){
                System.out.print(new String(buffer, 0, len));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if(inputStream != null) inputStream.close();
                if(socket != null) socket.close();

                if(outputStream != null) outputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Test
    public void test1()  {
        try{
            Socket socket = new Socket(InetAddress.getLocalHost(), 9089);
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            bufferedWriter.write("hello,server");
            bufferedWriter.newLine();//插入一个换行符，表示写入的内容结束，注意，要求对方使用readLine()
            bufferedWriter.flush();//如果使用的字符流，需要手动刷新，否则数据不会写入数据通道

            //socket.shutdownOutput();

//            char[] cbuf = new char[15];
//            int len;
//            while((len = bufferedReader.read(cbuf)) != -1){
//                System.out.print(new String(cbuf,0,len));
//            }
            String s = bufferedReader.readLine();
            System.out.print(s);

            socket.close();
            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
