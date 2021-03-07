public class Cat {

    private String name;
    private int appetite;
    protected boolean satiety;


    Cat (String name, int appetite)
    {
        this.name = name;
        this.appetite = appetite;

    }

    //метод для передачи данных об аппетите в класс Plate
    void eat (Plate plate) {
        plate.decreaseFood(appetite);
        }

    //метод для определения возможности поесть по данным о еде из класса Plate
    void fullness (int food) {
        if (food >= appetite) {
            this.satiety = true;
            System.out.println("Кот " + name + " съел: " + appetite + " грамм корма");
        } else {
            this.satiety = false;
            System.out.println("Нужно добавить в тарелку еды!!!");
            System.out.println();

        }
    }
}
