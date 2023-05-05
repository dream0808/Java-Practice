package com.hpy.day09.upload;

import com.hpy.day09.utils.StreamUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description:
 * 文件上传的客户端
 */
public class TCPFileUpLoadClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),8888);
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\836.jpg"));

        //bytes : 文件内容
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);
        bis.close();
        socket.shutdownOutput();

        InputStream is = socket.getInputStream();

        String s = StreamUtils.streamToSTring(is);
        System.out.println(s);

        is.close();

        bos.close();
        socket.close();

    }
}
