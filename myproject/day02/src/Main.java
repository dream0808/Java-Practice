import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    @Test
    public void test(){
        String[] strings = {"ZZ","BB","CC","GG","OO","QQ","AA"};
        Arrays.sort(strings, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof  String && o2 instanceof  String ){
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return s1.compareTo(s2);
                }
                throw  new RuntimeException("error");
            }
        });
        for (String msg: strings) {
            System.out.println(msg);
        }
    }

}