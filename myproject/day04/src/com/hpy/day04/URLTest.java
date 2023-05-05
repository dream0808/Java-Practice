package com.hpy.day04;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description:
 *
 */
public class URLTest {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://yun.itheima.com/Upload/Images/20230327/64214a0840b3d.jpg");
            int port = url.getPort();
            System.out.println(port);

            String host = url.getHost();
            System.out.println(host);

            String protocol = url.getProtocol();
            System.out.println(protocol);

            String path = url.getPath();
            System.out.println(path);

            String file = url.getFile();
            System.out.println(file);

            String query = url.getQuery();
            System.out.println(query);


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
