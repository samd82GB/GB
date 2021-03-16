package lesson1HW;

public class Working {

public void working () {

    RunwayWall[] runwayWalls = {

            new Cat("Барсик", 500, 2.5),
            new Cat("Мурзик", 450, 3.0),
            new Human("Иван-царевич", 5000, 2),
            new Human("Елена-прекрасная", 3000, 5),
            new Robot("Бэндер", 2000),
            new Robot("R2D2", 4000)

    };

    for (RunwayWall r : runwayWalls) {
       if (r.run(2500)) {
           if (r.jump(4.0)) {
               System.out.println("Участник успешно прошёл все препятствия!!!");
               System.out.println();
           } else {
               System.out.println("Участник не смог преодолеть второе препятствие...");
               System.out.println();
           }
       } else {
           System.out.println("Участник сошёл после первого препятствия...");
           System.out.println();
       }

    }

}
}
