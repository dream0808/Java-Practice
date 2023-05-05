abstract class Equiment{
    private String name;
    public String getName() {
        return this.name;
    }
    public Equiment(String name) {
        this.name = name;
    }
}
class Fan extends Equiment{
    private double power;
    public Fan(String name, double power) {
        super(name);
        this.power = power;
    }
    public String toString() {
        return "电扇:"+this.getName()+"，power:"+this.power;
    }
}
class Refrigerator extends Equiment{
    private double volume;
    public Refrigerator(String name, double volume) {
        super(name);
        this.volume = volume;
    }
    public String toString() {
        return "冰箱:"+this.getName()+"，容量:"+this.volume;
    }
}
class MyFactory{
    public static Equiment getInstance(String equimentName) {
        if(equimentName.equals("电扇"))
            return new Fan("格力电扇",100);
        else if(equimentName.equals("冰箱"))
            return new Refrigerator("格力冰箱",200);
        else
            return null;
    }
}
class Demo5{
    public static void main(String [] args) {
        Equiment e=MyFactory.getInstance("电扇");
        System.out.println(e);
    }
}