public class Main {

    public static void main (String [] args) {
        Cat catKsu = new Cat("Ксюша" , 200);
        Cat catMurz = new Cat("Мурзик", 150);
        Cat catBars = new Cat("Барсик", 250);
        Cat catTikhon = new Cat("Тихон", 120);
        Plate plate = new Plate(650);

        plate.info();
        System.out.println("Котов позвали кушать из одной тарелки!");




        Cat[] cats = {catBars, catMurz, catKsu, catTikhon};
        for (int i =0; i <cats.length; i++)
        {
            //вызываем метод определения сытости кота
            plate.satiety(cats[i]);
            //если кот не может поесть, то добавляем в тарелку корм
            if (!cats[i].satiety)
            {plate.addFood(200);
            plate.satiety(cats[i]);}
            //вызываем метод уменьшения еды в тарелке
            cats[i].eat(plate);
            //запрос информации об остатке еды в тарелке
            plate.info();


        }







    }


}
