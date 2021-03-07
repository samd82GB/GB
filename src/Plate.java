public class Plate {

    private int food;


    Plate (int food) {
        this.food = food;
    }

    public void info ()
    {
        System.out.println("В тарелке: "+food + " грамм корма");
        if (food == 0) {
            System.out.println("Весь корм съеден!");
        }
    }

    //метод для уменьшения еды в тарелке во время кормёжки котов
    void decreaseFood (int appetite) {
        if (appetite>food){
           return;
        }
        this.food-=appetite;
    }

    //метод для передачи данных о еде в класс Cat для определения сытости кота
    void satiety (Cat cat) {
       cat.fullness(food);

    }

    //метод добавления еды в тарелку
    void addFood (int food){
        this.food+=food;
        System.out.println("В тарелку добавили "+food+ " грамм корма");
    }

}
