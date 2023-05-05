package com.test.hpy;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description: TODO
 */
public class StringTest {
    public static void main(String[] args) {
        String str1 = "Hello World!I amstudent";
        String str2 = "THis is astudent";
      System.out.println(getMaxSameString(str1,str2));
        System.out.println(minWindow(str1, str2));
    }
    public static String getMaxSameString(String str1,String str2){
        String maxStr = (str1.length() > str2.length()) ? str1 : str2;
        String minStr = (str1.length() < str2.length()) ? str1 : str2;
        int length = minStr.length();
        for (int i = 0; i < length; i++) {
            for(int x = 0, y = length - i;y <= length; x++,y++){
                String subStr = minStr.substring(x,y);
                if(maxStr.contains(subStr)){
                    return subStr;
                }
            }
        }

return null;

    }
    public static int minWindow(String s, String t) {
        int[] tFreq = new int[128];
        for (int i = 0; i < t.length(); i++) {
            tFreq[t.charAt(i)]++;
        }

        int left = 0, right = 0;
        int count = t.length();
        int minLen = Integer.MAX_VALUE;

        while (right < s.length()) {
            if (tFreq[s.charAt(right)] > 0) {
                count--;
            }
            tFreq[s.charAt(right)]--;
            right++;

            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                }

                if (tFreq[s.charAt(left)] == 0) {
                    count++;
                }
                tFreq[s.charAt(left)]++;
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
    public String getString(String s1,String s2){
        String maxStr = (s1.length() > s2.length()) ? s1 : s2;
        String minStr = (s1.length() < s2.length()) ? s1 : s2;
        int length = minStr.length();

        for(int i = 0;i < length;++i){
            for(int x = 0,y = length -i; y <= length; x++ ,y++){
                String subStr = maxStr.substring(x,y);
                if(maxStr.contains(subStr)){
                    return subStr;
                }
            }
        }
        return null;
    }
}
