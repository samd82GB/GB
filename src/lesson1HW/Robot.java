package lesson1HW;

public class Robot implements RunwayWall{
    private String name;
    private double maxRun;


    Robot (String name, double maxRun){
        this.name=name;
        this.maxRun = maxRun;
    }

    public boolean run (double l) {
        if (maxRun >= l) {
            System.out.println("Робот " + name + " пробежал дистанцию " + l + " метров");
            return true;
        } else {
            System.out.println("Робот " + name + " недобежал, сел аккумулятор...");
        }
        return false;
    }

    public boolean jump (double h) {
        System.out.println("Роботы не умеют прыгать!");
        return false;
    }
}
