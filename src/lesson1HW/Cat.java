package lesson1HW;

public class Cat implements RunwayWall{
    private String name;
    private double maxRun;
    private double maxJump;

    Cat (String name, double maxRun, double maxJump){
        this.name=name;
        this.maxJump = maxJump;
        this.maxRun = maxRun;

    }
    public boolean run (double l) {
        if (maxRun >= l) {
            System.out.println("Кот " + name + " пробежал дистанцию " + l + " метров");
            return true;
        } else {
            System.out.println("Кот " + name + " недобежал");
        }
        return false;
    }

    public boolean jump (double h) {
        if (maxJump >= h) {
            System.out.println("Кот " + name + " перепрыгнул стену высотой " + h + " метров");
            return true;
        } else {
            System.out.println("Кот " + name + " не смог перепрыгнуть стену " + h + " метров...");
        }
        return false;
    }


}
