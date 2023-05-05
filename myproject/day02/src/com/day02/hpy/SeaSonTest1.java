package com.day02.hpy;

public class SeaSonTest1 {
    public static void main(String[] args) {
        Season1 spring = Season1.SPRING;
//        System.out.println(spring);

        Season1[] values = Season1.values();
        for (Season1 season: values) {
            System.out.println(season);
        }
    }

}
enum Season1{
    SPRING("春天","穿暖花开"),
    SUMMER("夏天","夏日炎炎"),
    AUTUMN("秋天","秋高气爽"),
    WINTER("冬天","冰天雪地");

    private final String seasonName;
    private final String desc;

    private Season1(String seasonName, String desc) {
        this.seasonName = seasonName;
        this.desc = desc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getDesc() {
        return desc;
    }

//    @Override
//    public String toString() {
//        return "Season1{" +
//                "seasonName='" + seasonName + '\'' +
//                ", desc='" + desc + '\'' +
//                '}';
//    }
}
