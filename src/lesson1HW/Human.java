package lesson1HW;

public class Human implements RunwayWall{
    private String name;
    private double maxRun;
    private double maxJump;


    public Human (String name, double maxRun, double maxJump) {
        this.name = name;
        this.maxJump = maxJump;
        this.maxRun = maxRun;

    }


    public boolean run (double l) {
        if (maxRun >= l) {
            System.out.println("Человек " + name + " пробежал дистанцию " + l + " метров");
            return true;
        } else {
            System.out.println("Человек " + name + " не добежал...");
        }
        return false;
    }

    public boolean jump (double h) {
        if (this.maxJump >= h) {
            System.out.println("Человек " + name + " перепрыгнул стену высотой " + h + " метров");
            return true;
        } else {
            System.out.println("Человек " + name + " не смог перепрыгнуть стену " + h + " метров...");
        }
        return false;
    }


}
