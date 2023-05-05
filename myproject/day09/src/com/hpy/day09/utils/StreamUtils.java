package com.hpy.day09.utils;

import java.io.*;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description: TODO
 */
public class StreamUtils {


    /**
     * 功能：将输入流转换成byte[],即可以把文件的内容读入到byte[]
     * @param is
     * @return
     * @throws IOException
     */
    public static byte[] streamToByteArray(InputStream is) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while((len = is.read(buffer)) != -1){
            bos.write(buffer,0,len);
        }
        byte[] arrays = bos.toByteArray();
        bos.close();
        return arrays;
    }

    public static String streamToSTring(InputStream is) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder builder = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null){
            builder.append(line+"\r\n");
        }
        return builder.toString();
    }
}
