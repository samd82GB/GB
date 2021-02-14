public class Main {
    public static void main(String[] args) {

    //Вызов метода для задания 1.
        integerMassive1();

    //Вызов метода для задания 2.
        integerMassive2();

    // Вызов метода для задания 3.
        integerMassive3();

    // Вызов метода для задания 4.
        twoArr1();

    //Вызов метода для задания 5.
        minmaxArr();

    }
//Задание 1. Задать массив. Инвертировать значения.
    static void integerMassive1()
    {
        int[] arr= new int[10];
        arr[0]=1;
        arr[1]=1;
        arr[2]=0;
        arr[3]=1;
        arr[4]=1;
        arr[5]=0;
        arr[6]=1;
        arr[7]=1;
        arr[8]=0;
        arr[9]=1;


        for (int index=0; index < arr.length; index++)
        {
            if (arr[index]==1)
            {
                arr[index]=0;
            }
            else arr[index]=1;
            System.out.println("Массив1 "+"["+index+"] = "+ arr[index]);
        }
    }
//Задание 2. Задать массив размером 8. Заполнить рядом чисел.
    static void integerMassive2()
    {
        int[] arr= new int[8];


        for (int index=0; index < arr.length; index++)
        {
            if (index==0)
            {
                arr[index]=0;
            }
            else
            arr[index]=arr[index-1]+3;

            System.out.println("Массив2 "+"["+index+"] = "+ arr[index]);
        }
    }
//Задание 3. Создать массив. Значения массива меньше 6 умножить на 2
    static void integerMassive3()
    {
        int[] arr= {1,5,3,2,11,4,5,2,4,8,9,1};

        for (int index=0; index < arr.length; index++)
        {
            if (arr[index]<6)
            {
                arr[index]=arr[index]*2;
            }

            System.out.println("Массив3 "+"["+index+"] = "+ arr[index]);
        }
    }

//Задание 4. Двумерный квадратный массив. Диагональ заполнить единичками
    static void twoArr1()
    {
        int twoArr[][] = new int[5][5];

        for (int i = 0; i < twoArr.length; i++ )
        {
            for (int j = 0; j < twoArr[i].length;j++)
            {
                int y = twoArr[i].length-1 - j; //вычисляем координату i второй диагонали

                if (i==j||i==y)
                {
                    twoArr[i][j]=1;
                }
                System.out.print(twoArr[i][j]+" ");
            }
            System.out.println();
        }
    }

//Задание 5**. Одномерный массив с вычислением минимального и максимального числа
    static void minmaxArr()
    {
        int[] arr = {16, 3, 5, 7, 100, 0, 9, 15, 11, 40};
        int maximumVal = arr[0];
        int minimumVal = arr[0];

        for (int i = 0; i < arr.length; i++)
        {

       if (i != 0)
        {
                int j = i - 1;

                if (arr[i] > arr[j] && arr[i] > arr[0]) //Вычисление максимального значения члена массива
                {
                    maximumVal = arr[i];
                }
                if (arr[i] < arr[j] && arr[i] < arr[0]) // Вычисление минимального значения члена массива
                {
                    minimumVal = arr[i];
                }
            }

            }
        System.out.println(maximumVal);
        System.out.println(minimumVal);

    }
}

