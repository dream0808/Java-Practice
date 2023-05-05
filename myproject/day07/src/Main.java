import com.hpy.day07.Boy;
import com.hpy.day07.Girl;
import org.junit.Test;

import java.io.*;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
//        Girl girl = new Girl();
//        Optional<Girl> optional = Optional.of(girl);
//        System.out.println(optional);
//
//        Girl g = null;
//        Optional<Girl> optional1 = Optional.ofNullable(g);
//        System.out.println(optional1
//        );

        //java8中资源关闭操作：Java8中，可以实现资源的自动关闭
//        try(InputStreamReader in = new InputStreamReader(System.in)){
//            char[] cbuf = new char[20];
//            int len;
//            if((len = in.read(cbuf)) != -1){
//                String str = new String(cbuf, 0, len);
//                System.out.println(str);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        //java9中资源关闭操作：需要自动关闭的资源的实例化可以放在try的一对小括号外。
        //此时的资源属性是常量，声明为final的，不可修改
        InputStreamReader in = new InputStreamReader(System.in);
        try(in){//多个用分号隔开
            char[] cbuf = new char[20];
            int len;
            if((len = in.read(cbuf)) != -1){
                String str = new String(cbuf, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void test1(){
        Boy boy = null;
        String name = getName(boy);
        System.out.println(name);
        String a;
    }
    public String getName(Boy boy){
        Optional<Boy> optional = Optional.ofNullable(boy);
        //orELse(Tt:如果当前的optional内部封装的t是非空的，则返回内部的t
        //如果内部的t是空的，则返回orElse()方法中的参数t1
        Boy boy1 = optional.orElse(new Boy(new Girl("cxk")));

        Girl girl = boy1.getGirl();

        Optional<Girl> girl1 = Optional.ofNullable(girl);
        Girl girl2 = girl1.orElse(new Girl("cxk1"));

        return girl2.getName();

    }
    @Test
    public void test()  {

        try( FileInputStream fis = new FileInputStream("a.txt");
             FileOutputStream fos = new FileOutputStream("b.txt")){
            fis.transferTo(fos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test4(){
        var str = "hello";

    }
}