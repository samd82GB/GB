public class Dog extends Animal{

    Dog (String name, String color) {
        super(name, color);

    }

    //переопределение абстрактного метода swim для задания ограничения для собак
    void swim (int distance) {

       super.limSwim = 10;
       if (distance<=limSwim) {
        System.out.println(name + " "+color +" проплыл(а) " + distance + " метров");}
       else System.out.println(name+" "+color+" утонул(а)");

    }
    //переопределение абстрактного метода run для задания ограничения для собак
    void run (int distance) {

        super.limRun = 500;
        if (distance<=limRun){
            System.out.println(name + " "+color +" пробежал(а) " + distance + " метров");
        }
        else System.out.println(name+" "+color+ " споткнулся(лась) и упал(а)");

    }
}
