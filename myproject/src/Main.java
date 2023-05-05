import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
//        getYangHui(10);
//        String str = "abc123中国";
//        byte[] gbks = str.getBytes("GBK");
//        byte[] gbks2 = str.getBytes("utf-8");
//        System.out.println(Arrays.toString(gbks));
//        System.out.println(Arrays.toString(gbks2));
//
//        String str2 = new String(gbks,"gbk");
//        System.out.println(str2);
//        String str3 = new String(gbks2,"utf-8");
//        System.out.println(str3);
        System.out.println(getMaxSameString("dcdhelloworld","qwdfllowodcew"));
    }
@Test
public void testSimpleDateFormat()  {
//    SimpleDateFormat sdf = new SimpleDateFormat();
//    String format = sdf.format(new Date());
//    System.out.println(format);
//    String str ="2023/3/8 上午10:55";
//    Date parse = sdf.parse(str);
//    System.out.println(parse);


    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
   Date date =new Date("2022/01/03");
    String format1 = sdf1.format(date);
    System.out.println(format1);
}
@Test
public void testExer() throws ParseException {
        String str = "2014-03-14";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date parse = simpleDateFormat.parse(str);
    java.sql.Date birthdayDate =  new java.sql.Date(parse.getTime());
    System.out.println(birthdayDate);
}
@Test
public void test(){
        String str1 = "1990/01/01";
        String str2 = "2020/09/08";
    Date date1 = new Date(str1);
    Date date2 = new Date(str2);
    long l = (date2.getTime() - date1.getTime()) - (1000 * 60 * 60 * 24);
    if(l == 0 || l ==4){
        System.out.println("晒网");
    }else{
        System.out.println("打渔");
    }
}    public static String getMaxSameString(String str1,String str2){
        if(str1 != null && str2 != null){
            String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
            String minStr = (str1.length() < str2.length()) ? str1 : str2;
            int length = minStr.length();
            for (int i = 0; i < length; i++) {
                for (int x = 0,y = length - i; y <= length; x++,y++) {
                    String subStr = minStr.substring(x,y);
                    if(maxStr.contains(subStr)){
                        return subStr;
                    }
                }
            }
        }
        return null;
    }


    public static void getYangHui(int  num){
        int[][] arrays = new int[num][];

        for (int i = 0; i < num; i++) {

            arrays[i] = new int[i+1];
            arrays[i][0] = arrays [i][i] = 1;

            for (int j = 1; j < arrays[i].length-1; j++) {
                arrays[i][j] = arrays[i-1][j-1] + arrays[i-1][j];
            }
        }

        for (int i = 0; i < arrays.length; i++) {
            System.out.format("%" + (arrays.length - i) * 2 + "s", "");
            for (int j = 0; j < arrays[i].length; j++) {

                System.out.format("%4d",arrays[i][j]);
            }
            System.out.println();
        }
    }
}