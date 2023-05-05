 public class StringDemo {
    public static void main(String[] args) {
        String str = "abc123";
//        System.out.println(reverse(str,1,5));
//        System.out.println(reverse1(str, 1, 5));
//        System.out.println(reverse2(str, 1, 5));
        System.out.println( Math.ceil(3.1415) );
       //System.out.println(getCount("hello hello", "he"));
    }
   public static String reverse(String str,int startIndex,int endIndex){
      if(str != null && !str.isEmpty()){
          char[] chars = str.toCharArray();
          for(int x = startIndex,y = endIndex ; x < y ; x++,y --){
              char temp = chars[x];
              chars[x] = chars[y];
              chars[y] = temp;
          }
          return new String(chars);
      }
      return null;
    }
    public static String reverse1(String str,int startIndex,int endIndex){
        if(str != null && !str.isEmpty()){
            String reverseString = str.substring(0,startIndex);
            for (int i =endIndex; i >= startIndex ; i--) {
                reverseString +=str.charAt(i);
            }
            reverseString +=str.substring(endIndex+1);
            return reverseString;
        }
        return null;
    }
    public static String reverse2(String str,int startIndex,int endIndex){
        if(str != null && !str.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder(str.length());
            stringBuilder.append(str.substring(0, startIndex));
            for (int i = endIndex; i >= startIndex; i--) {
                stringBuilder.append(str.charAt(i));
            }
            stringBuilder.append(str.substring(endIndex + 1));
            return stringBuilder.toString();
        }
        return null;
    }
    public static int getCount(String mainString , String subString){
        int mainLength = mainString.length();
        int subLength = subString.length();
        int count = 0;
        int index = 0;
        if(mainLength >= subLength) {
            while ((index = mainString.indexOf(subString,index)) != -1) {
                count++;
                index +=subLength;
            }
        }
        return count;
    }
    public static String getMaxSameString(String str1, String str2){

        return null;
    }
}
