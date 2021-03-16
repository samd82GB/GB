import lesson1HW.DayOfWeeks;
import lesson1HW.Working;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       // Уровень 2. Домашнее задание 1. п. 1-4
        // Робот, кошка и человек пытаются пробежать и перепрыгнуть препятствия
        // если кто-то из участников не преодолел первое препятствие, то уже не может преодолевать второе
        Working working = new Working();
        working.working();

        // Уровень 2. Домашнее задание 1. п. 5 Перечисления
        // Вывод оставшегося до конца недели рабочего времени.
        // Принято, что в каждом буднем дне одинаковое количество рабочих часов, и рабочих дней 5
        // не разобрался как суммировать данные (рабочие часы) всех объектов в перечислении,
        // непонятно, как вводить в консоль через сканнер название дня недели, чтобы обработать его в программе

        System.out.println(getWorkingHours(DayOfWeeks.Воскресенье)+" час.");
    }

    public static int getWorkingHours (DayOfWeeks d) {
        int number = d.ordinal();
        int workingHoursOfDay = d.getWorkingHours();
        int hoursToTheEndOfWeek = 0 ;
        if (number>=5) {
            System.out.println("Сегодня выходной! ");
        } else {
            hoursToTheEndOfWeek = workingHoursOfDay*daysToTheEndOfWeek(number);
        }
        System.out.print("Остаток рабочего времени: ");
        return hoursToTheEndOfWeek;
    }

    public static int daysToTheEndOfWeek (int number) {
        int count = 0;
        for (int i = number; i<5; i++) {
            count++;
        }
        return count;
    }
}
