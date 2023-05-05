package com.day02.hpy;

public class SeasonTest {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);
    }
}
class Season{
    private final String seasonName;
    private final String desc;

    private Season(String seasonName,String desc){
        this.seasonName = seasonName;
        this.desc = desc;
    }
    public static final Season SPRING = new Season("春天","春天");
    public static final Season SUMMER = new Season("夏天","夏天");
    public static final Season AUTUMN = new Season("秋天","秋天");
    public static final Season WINTER = new Season("冬天","冬天");

    public String getSeasonName() {
        return seasonName;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
