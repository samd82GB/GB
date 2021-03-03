public class Main {

    public static void main (String[] args) {

        //создание собак
        Dog dogRex = new Dog ("Рекс", "рыжий");
        Dog dogTuz = new Dog ("Тузик", "белый");
        Dog dogBobik = new Dog ("Бобик", "чёрный");
        Dog dogBarbos = new Dog ("Барбос", "серый");
        Dog dogJack = new Dog ("Джек", "коричневый");

        dogRex.run(400);
        dogTuz.run(188);
        dogBobik.run(745);
        dogBarbos.run(45);
        dogJack.run(349);
        dogRex.swim(15);
        dogTuz.swim(7);
        dogBobik.swim(5);
        dogBarbos.swim(9);
        dogJack.swim(11);

        //создание котов
        Cat catMurz = new Cat("Мурзик", "серый");
        Cat catArt = new Cat("Артуро", "чёрно-белый");
        Cat catMisha = new Cat("Миша", "серый");
        Cat catBars = new Cat("Барсик", "черепаховый");

        catBars.run(50);
        catArt.run(199);
        catMisha.run(14);
        catMurz.run(250);
        catBars.swim(10);
        catArt.swim(15);
        catMisha.swim(5);
        catMurz.swim(2);


        //подсчёт созданных объектов котов и собак
        int countCat = 0;
        int countDog = 0;
        int countAnimals = 0;
        Animal[] animals = {dogBarbos, dogBobik, dogJack, dogTuz, dogRex, catArt, catBars, catMisha, catMurz};
        for (int i=0; i<animals.length; i++) {
            if (animals[i] instanceof Cat) {
                countCat++;
                }
            if (animals[i] instanceof Dog) {
                countDog++;
            }
            if (animals[i] instanceof Animal) {
                countAnimals++;
            }
        }
        System.out.println("Создано "+countCat+" котов");
        System.out.println("Создано "+countDog+" собак");
        System.out.println("Создано "+countAnimals+" животных");




    }


}
