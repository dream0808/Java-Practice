import com.day01.hpy.Student;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    @Test

    public void test(){
//        LocalDate localDate = LocalDate.now();
//        LocalTime localTime = LocalTime.now();
//        LocalDateTime localDateTime = LocalDateTime.now();
//        System.out.println(localDate);
//        System.out.println(localTime);
//        System.out.println(localDateTime);
        LocalDateTime time = LocalDateTime.of(2023, 2, 10, 5, 4, 45);
        System.out.println(time);
    }
    public static void main(String[] args) {
        Student[] stu = new Student[4];
        stu[0] = new Student("zs",1,13);
        stu[1] = new Student("ls",2,10);
        stu[2] = new Student("ww",3,100);
        stu[3] = new Student("sw",4,89);

        Arrays.sort(stu);

        for (int i = 0; i < stu.length; i++) {
            System.out.println(stu[i].getScore()+"," + stu[i].getName());
        }
    }
    @Test
    public void test2(){
        Student[] stu = new Student[4];
        stu[0] = new Student("zs",1,13);
        stu[1] = new Student("ls",2,10);
        stu[2] = new Student("ww",3,100);
        stu[3] = new Student("sw",4,89);

        Arrays.sort(stu,new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
               if(o1 instanceof  Student && o2 instanceof  Student){
                   Student s1 = (Student) o1;
                   Student s2 = (Student) o2;
                   return -Double.compare(s1.getScore(),s2.getScore());
               }
               throw new RuntimeException("error");
            }
        });

        for (int i = 0; i < stu.length; i++) {
            System.out.println(stu[i].getScore()+"," + stu[i].getName());
        }
    }
}
