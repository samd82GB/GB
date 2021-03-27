import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Задача 1. Массив слов
        String [] strings = {"Первоуральск", "Ревда", "Каменск-Уральский",
                "Екатеринбург", "Нижний Тагил", "Полевской", "Первоуральск",
                "Богданович", "Первоуральск", "Серов", "Невьянск", "Реж"};

        //Вывод уникальных значений массива при помощи коллекции HashSet
        Set<String> set = new HashSet<>(Arrays.asList(strings));
        //Вывод список уникальных слов по заданию 1
        System.out.println("Массив уникальных слов: ");
        System.out.println(set);
        System.out.println("Уникальных слов в массиве: "+set.size());
        System.out.println();

        //Запись в Map содержимого массива слов для подсчёта суммы использования каждого слова
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<strings.length; i++) {
            String nameOfTown = strings [i];
           //подсчёт количества каждого элемента в массиве
            map.put(nameOfTown, map.getOrDefault(nameOfTown, 0)+1);
        }
        //вывод в консоль подсчитанных значений количества элементов массива
        map.forEach((k,v) -> {System.out.println("город ["+k+"] упоминается "+v+" раз");});
        System.out.println("----------------------------------------------------");
        System.out.println();


        // Задание 2. Телефонный справочник

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Холмс","+79998887766" );
        phoneBook.add("Холмс","+79998887765" );
        phoneBook.add("Ватсон","+79997776655");
        phoneBook.add("Мисс Марпл","+79996665544" );
        phoneBook.add("Мисс Марпл","+79996665545" );
        phoneBook.add("Мисс Марпл","+79996665546" );
        phoneBook.add("Флетчер Джессика","+79995554433" );
        phoneBook.add("Пуаро","+79994443322");
        phoneBook.printBook();

        //получение номера по имени запроса, если номеров много у одного адресата, то выводим все
        phoneBook.getPhone("Мисс Марпл");






    }


}
