public class Cat extends Animal{

int countCat;

Cat (String name, String color) {
    super(name, color);
    }
void countCat(){
    countCat++;
}

//переопределяем метод swim, потому что коты не умеют плавать
    void swim (int distance) {
        System.out.println(name + " "+color +" не умеет плавать! ");
    }
//переопределение метода run для задания ограничения по дистанции
    void run (int distance) {

    super.limRun = 200;
        if (distance<=limRun){
            System.out.println(name + " "+color +" пробежал(а) " + distance + " метров");
        }
        else System.out.println(name+" "+color+ " споткнулся(лась) и упал(а)");

    }
}






