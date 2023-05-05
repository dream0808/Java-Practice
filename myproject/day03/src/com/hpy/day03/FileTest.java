package com.hpy.day03;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 15:44
 * @description: TODO
 */
public class FileTest {

    @Test
    public void test1(){
        File file = new File("test.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
                System.out.println("y");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else {
            System.out.println("exist");
        }
        System.out.println(file);

    }
    @Test
    public void test2(){
        File file = new File("test.txt");
//        System.out.println(file.getAbsoluteFile());
//        System.out.println(file.getParent());
//        System.out.println(file.getParentFile());
//        System.out.println(file.getPath());
//        System.out.println(file.getName());
//        System.out.println(file.length());
//        System.out.println(new Date(file.lastModified()));


        File file1 = new File("D:\\");

        File[] files = file1.listFiles();
        for(File f : files){
            System.out.println(f.toString());
        }
    }
    /*
    public boolean renameTo(File dest):把文件重命名为指定的文件路径
    比如：file1.renameTo(file2)为例：
    要想保证返回true,需要file1在硬盘中是存在的，且file2不能在硬盘中存在。
*/

    @Test
    public void test3(){
        File file = new File("test.txt");
        File file1 = new File("D:\\a.txt");
        boolean b = file.renameTo(file1);
        System.out.println(b);

    }
    @Test
    public void test4(){
        File file = new File("test.txt");
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isHidden());

    }
    @Test
    public void test5() throws IOException {
        File file = new File("test.txt");
        if(!file.exists()){
            boolean isCreate = file.createNewFile();
            if(isCreate){
                System.out.println("创建成功");
            }else{
                System.out.println("创建失败");
            }
        }else{
            boolean isDelete = file.delete();
            if(isDelete){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }
        }
    }
    @Test
    public void test6(){
        File file = new File("E:\\test\\test");
        if(!file.exists()){
            boolean isMkdirs = file.mkdirs();
            if(isMkdirs){
                System.out.println("success");
            }
        }
    }
    @Test
    public void test7(){
        File file = new File("C:\\Users\\ASUS\\Pictures\\Camera Roll");
        if(file.exists()){
            String[] list = file.list();
            for(String str : list){
                if(str.endsWith(".jpg")){
                    System.out.println(str);
                }
            }
        }

    }
    @Test
    public void test8(){
        File file = new File("E:\\test");
        deleteDirectory(file);
    }
    public void deleteDirectory(File file){
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(File f : files){
                deleteDirectory(f);
            }

        }
        file.delete();
    }
    @Test
    public void test9(){
        FileTest.printPascalTriangle(10);
    }

    public static void printPascalTriangle(int n) {
        for(int i = 0; i < n; i++) {
            int number = 1;
            System.out.printf("%" + (n - i) * 2 + "s", "");
            for(int j = 0; j <= i; j++) {
                System.out.printf("%4d", number);
                number = number * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }

}

