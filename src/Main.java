public class Main
{
    public static void main(String[] args) {
        //Задание 2. Объявление переменных с инициализацией

        byte a1 = 100;
        short a2 = 27984;
        int a3 = 3200000;
        long a4 = 900000000;
        float a5 = 3.56f;
        double a6 = 3.5;
        char a7 = '7';
        boolean a8 = true;

        //вызов метода expression и получение результата вычисления формулы
        float e = expression();
        System.out.println(e); //вывод результата вычисления метода expression

        //вызов метода comparison с параметрами и выдачей результата проверки диапазона суммы аргументов
        boolean h = comparison(3, 10);
        System.out.println(h);

        //вызов метода signNumber с аргументом
        signNumber(0);

        //вызов метода singNumber2 со значением boolean = true если число отрицательное, false - положительное
        boolean k = signNumber2(-5);
        System.out.println(k + " Значение true - число отрицательне, значение false - положительне");

        //вызов метода helloName для выдачи сообщения Привет имя!
        helloName("Василий");

        //вызов метода leapYear для определения високосности года
        leapYear(1904);


    }
//Задание 3. Вычисление выражения  a * (b + (c / d)) и возвращение результата
    static float expression ()
    {
        float a = 3f;
        float b = 4f;
        float c = 5f;
        float d = 12.6f;
        return (a*(b+(c/d)));


    }
// Задание 4. Метод для сравнения входных аргументов
    static boolean comparison(int f, int g)
    {
        if ((f + g) >= 10 && (f + g) <= 20) {
            return (true);
        }
        else
            {
            return (false);
        }
    }

    //Задание 5. Метод для определения знака числа

    static void signNumber(int i)
    {
        if (i>=0)
        {
            System.out.println("Число в задании 5 положительное");
        }
        else
            {
                System.out.println("Число задания 5 отрицательное!");
            }
    }

    //Задание 6. Метод для определения знака числа, но с возвратом значения boolean
    static boolean signNumber2(int j)
    {
        if (j>=0)
        {
            return (false);
        }
        else
        {
            return (true);
        }
    }
    //Задание 7. Вывод сообщения "Привет! входная переменная"
    static void helloName(String name)
    {
        System.out.println("Привет! "+ name + "!" );

    }

    //Задание 8. Определение високосного года

    static void leapYear(int year)
    {
        //по условиям задачи каждый 4-й год, кроме каждого сотого, а также каждый 400-й год являются високосными
        if (year % 400==0)
        {
            System.out.println("Год "+year+" является високосным!");
        }
        else if (year % 100==0 && year % 400!=0)
        {
            System.out.println("Год "+year+" не является високосным!");
        }
        else if (year %4 == 0 && year % 100 !=0)
        {
            System.out.println("Год "+year+" является високосным!");
        }
        else
        {
            System.out.println("Год "+year+" не является високосным!");
        }


    }

    }


