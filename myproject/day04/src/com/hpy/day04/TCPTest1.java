package com.hpy.day04;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description:
 *
 * 实现Tcp的网络编程
 * 例子1：
 */
public class TCPTest1 {

    //客户端
    @Test
    public void client() {
        Socket socket = null;
        OutputStream out = null;
        try {
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet,8899);
            out = socket.getOutputStream();
            out.write("hello World".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
    //服务端
    @Test
    public void server() {
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream bos = null;
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(8899);
            socket = ss.accept();

            is = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int len;
            bos = new ByteArrayOutputStream();
            while((len = is.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
            System.out.println(bos.toString());
//            while((len = is.read(buffer)) != -1){
//    //            is.read(buffer,0,len);
//                String result = new String(buffer, 0, len);
//                System.out.println(result);
//            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(ss != null){
                try {
                    ss.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }
}
