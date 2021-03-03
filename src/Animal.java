public abstract class Animal {

protected String name;
protected String color;
int limSwim;
int limRun;

    Animal (String name, String color) {
        this.name = name;
        this.color = color;
     }

    abstract void swim (int distance);

    abstract  void run (int distance);

}
