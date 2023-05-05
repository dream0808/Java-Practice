package com.day01.hpy;

public class Student implements Comparable {
    private String name;
    private int id;
    private double score;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getScore() {
        return score;
    }

    public Student(String name, int id, double score) {
        this.name = name;
        this.id = id;
        this.score = score;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof  Student){
            Student stu = (Student) o;
            if(this.getScore() > stu.getScore()){
                return -1;
            }else  if(this.getScore() < stu.getScore()){
                return 1;
            }else{
                return 0;
            }
        }
        throw new RuntimeException("error");
    }
}
