package com.hpy.day03.io;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description: TODO
 */

import org.junit.Test;

import java.io.*;

/**
 * 处理流之一：缓冲流的使用
 * 1.缓冲流：
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 *
 * 2.作用：提高流的读取、写入的速度
 *        提高读写速度的原因：内部提供了一个缓冲区
 *
 * 3.处理流，就是“套接”在已有的流的基础上。
 */
public class BufferedTest {

    @Test
    public void test() {
        File srcfile = new File("a.jpg");
        File destfile = new File("b.jpg");
        FileInputStream fis;
        FileOutputStream fos;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            fis = new FileInputStream(srcfile);
            fos = new FileOutputStream(destfile);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            byte[] buffer = new byte[5];
            int len;
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if(bis != null) bis.close();
                if(bos != null) bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
    @Test
    public void testBufferedReaderBufferedWriter(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader("test.txt"));
            bw = new BufferedWriter(new FileWriter("D:\\a.txt"));
            char[] cbuf = new char[1024];
            int len;
//            while((len = br.read(cbuf)) != -1){
//                bw.write(cbuf,0,len);
//            }
            String data;
            while((data = br.readLine()) != null){
                bw.write(data);//data中不包含换行符
                bw.newLine();//换行
            }
        } catch (IOException e) {
           e.printStackTrace();
        }finally{
            try {
                if(br != null) br.close();
                if(bw != null) bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
