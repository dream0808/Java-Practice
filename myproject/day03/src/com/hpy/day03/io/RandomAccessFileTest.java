package com.hpy.day03.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description:
 *
 *  RandomAccessFile的使用
 * 1.RandomAccessFile直接继承于java.Lang.Object类，实现了DataInput DataOutput接口
 * 2.RandomAccessFile既可以作为一个输入流，又可以作为一个输出流
 */
public class RandomAccessFileTest {

    @Test
    public void test0(){
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("a.jpg"), "r");
            raf2 = new RandomAccessFile(new File("E:\\a.jpg"), "rw");
            byte[] buffer = new byte[1024];
            int len;
            while((len = raf1.read(buffer)) != -1){
                raf2.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(raf1 != null){
                try {
                    raf1.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(raf2 != null){
                try {
                    raf2.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
    @Test
    public void test1(){
        RandomAccessFile raf1 = null;
        try {
            raf1 =new RandomAccessFile(new File("test.txt"),"rw");
            raf1.seek(3);
            raf1.write("cxk666".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally{
            if(raf1 != null){
                try {
                    raf1.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
    @Test
    public void test2() {
        RandomAccessFile raf1 = null;
        try {
            raf1 = new RandomAccessFile(new File("test.txt"),"rw");
            raf1.seek(3);
            StringBuilder sb = new StringBuilder((int) new File("test.txt").length());
            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf1.read(buffer)) != -1){
                sb.append(new String(buffer,0,len));
    ;        }
            raf1.seek(3);
            raf1.write("cxk".getBytes());
            raf1.write(sb.toString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(raf1 != null){
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }

    }
    @Test
    public void test3(){

    }
}