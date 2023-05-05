package com.hpy.day03.io;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 20:37
 * @description:
 */

import org.junit.Test;

import java.io.*;

/**
 * 一、流的分类：
 * 1.操作数据单位：字节流、字符流
 * 2.数据的流向：输入流、输出流
 * 3.流的角色：节点流、处理流
 * <p>
 * <p>
 * 二、流的体系结构
 * 抽象基类                     节点流(文件流)            缓冲流（缓存流的一种）
 * InputStream                  FileInputStream         BufferedInputStream
 * OutputStream                 FileOutputStream        BufferedOutputStream
 * Reader                       FiLeReader              BufferedReader
 * Writer                       FileWriter              BufferedWriter
 */
public class FileReaderWriterTest {

    @Test
    public void testFileReader() {
        File file = new File("test.txt");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            int data;
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != fileReader) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Test
    public void testFileReader1() {
        File file = new File("test.txt");
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
//                for(int i = 0; i < len; ++i){
//                    System.out.print(cbuf[i]);
//                }
                String string = new String(cbuf, 0, len);
                System.out.print(string);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (null != fr) {
                try {
                    fr.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Test
    public void testFileWriter() {
        File file = new File("test1.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file, true);
            fw.write("\nHello World!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test()  {
        File srcfile = new File("test.txt");
        File destfile = new File("test1.txt");

        FileReader fr = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter(destfile);
            fr = new FileReader(srcfile);
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
              fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if(null != fr)
                fr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if(null != fw)
                    fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
