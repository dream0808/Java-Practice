package com.hpy.day03.io.exer;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description: TODO
 */
public class PicTest {
    @Test
    public void test() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("E:\\a.jpg");
            fos = new FileOutputStream("E:\\b.jpg");
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    @Test
    public void test1() throws IOException {
        Map<Character, Integer> map = new HashMap<>();
        FileReader br = new FileReader("test.txt");
        int c = 0;
        while((c = br.read()) != -1){
            char ch = (char) c;
            if(map.get(ch) == null){
                map.put(ch,1);
            }else{
                map.put(ch,map.get(ch) + 1);

            }
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\wordCount.txt"));
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for(Map.Entry<Character, Integer> entry :entries){
            switch (entry.getKey()){
                case ' ':
                    bw.write("空格=" + entry.getValue());
                    break;
                case '\t':
                    bw.write("tab键=" + entry.getValue());
                    break;
                case '\r':
                    bw.write("回车=" + entry.getValue());
                    break;
                case '\n':
                    bw.write("换行=" + entry.getValue());
                    break;
                default:
                    bw.write(entry.getKey() + "=" + entry.getValue());
            }
            bw.newLine();
        }
        br.close();
        bw.close();
    }
    @Test
    public void test2(){

    }

    public static void main(String[] args) {
        String s = MyInput.readString();
        System.out.println(s);
    }
}
