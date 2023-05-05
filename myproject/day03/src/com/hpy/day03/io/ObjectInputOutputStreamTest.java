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
public class ObjectInputOutputStreamTest {

    @Test
    public void test() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
        oos.writeObject(new String("test"));
        oos.flush();

        oos.close();

    }
    @Test
    public void test2() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.dat"));
        Object object = ois.readObject();
        System.out.println(object.toString());
        ois.close();
    }
}
