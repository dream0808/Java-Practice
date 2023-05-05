package com.hpy.day09.socket;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description:
 * 服务端
 */
public class SocketTCP01Server {
    public static void main(String[] args) {
        Socket socket = null;
        InputStream inputStream = null;
        ServerSocket serverSocket = null;
        OutputStream outputStream = null;
        try {
            serverSocket = new ServerSocket(9999);
            socket  = serverSocket.accept();
            inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int len;
            while((len = inputStream.read(buffer)) != -1){
                System.out.println(new String(buffer,0,len));
            }

            outputStream = socket.getOutputStream();
            outputStream.write("hello,client".getBytes());
            socket.shutdownOutput();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if(outputStream != null) outputStream.close();
                if(socket != null) socket.close();
                if(inputStream != null) inputStream.close();
                if(serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Test
    public void test1() {
        try
        {
            ServerSocket serverSocket = new ServerSocket(9089);
            Socket accept = serverSocket.accept();
            OutputStream outputStream = accept.getOutputStream();
            InputStream inputStream = accept.getInputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//            char[] cbuf = new char[15];
//            int len;
//            while((len = bufferedReader.read(cbuf)) != -1){
//                System.out.print(new String(cbuf,0,len));
//            }
            String s = bufferedReader.readLine();
            System.out.print(s);

            bufferedWriter.write("hello,client");
            bufferedWriter.newLine();
            bufferedWriter.flush();//如果使用的字符流，需要手动刷新，否则数据不会写入数据通道

            //accept.shutdownOutput();

            serverSocket.close();
            accept.close();
            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
