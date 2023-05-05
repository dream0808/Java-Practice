import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        try {
            InetAddress name = InetAddress.getByName("182.90.220.81");
            System.out.println(name);
            System.out.println(name.getHostName());
            InetAddress name2 = InetAddress.getByName("www.mi.com");
            System.out.println(name2);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}