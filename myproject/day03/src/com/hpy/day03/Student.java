package com.hpy.day03;

import java.util.Objects;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/23 23:22
 * @description: TODO
 */
public class Student implements Comparable{
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int compareTo(Object o) {
       if(o instanceof  Student){
           Student stu = (Student) o;
           int compareResult = this.getName().compareTo(stu.getName());
           if(compareResult != 0){
               return compareResult;
           }else{
               return Integer.compare(this.getAge(),stu.getAge());
           }
       }else{
           throw new RuntimeException("error");
       }
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name, age);
//    }
}
