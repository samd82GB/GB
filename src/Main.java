import java.util.Arrays;

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

    //Вызов метода для задания 6.

    int [] massBalance = {2, 3, 8, 1, 1, 7, 3, 3};
    boolean balance = checkBalance(massBalance);
    System.out.println("Результат логической обработки задания 6: "+balance);
    System.out.println("-----------------");


    // Вызов метода для задания 7.
        int[] shiftArr = {5,6,9,1};
        int n = 2; //если число n положительное, то сдвиг массива вправо, если отрицательное, то влево
        shiftNumbers(shiftArr, n);




    }
//Задание 1. Задать массив. Инвертировать значения.
    static void integerMassive1()
    {
        System.out.println("Задание 1:");
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
        System.out.println("Исходное значение массива:");
        System. out .println(Arrays. toString (arr));
        System.out.println("Полученное значение массива:");
        System.out.print("[ ");

        for (int index=0; index < arr.length; index++)
        {
            if (arr[index]==1)
            {
                arr[index]=0;
            }
            else arr[index]=1;
            System.out.print(arr[index] + ", ");
        }
        System.out.println("]");
        System.out.println("-----------------");
    }
//Задание 2. Задать массив размером 8. Заполнить рядом чисел.
    static void integerMassive2()
    {
        int[] arr= new int[8];
        System.out.println("Задание 2:");
        System.out.println("Исходное значение массива:");
        System. out .println(Arrays. toString (arr));
        System.out.println("Полученное значение массива:");
        System.out.print("[ ");

        for (int index=0; index < arr.length; index++)
        {
            if (index==0)
            {
                arr[index]=0;
            }
            else
            arr[index]=arr[index-1]+3;

            System.out.print(arr[index] + ", ");
        }
        System.out.println("]");
        System.out.println("-----------------");
    }
//Задание 3. Создать массив. Значения массива меньше 6 умножить на 2
    static void integerMassive3()
    {
        int[] arr= {1,5,3,2,11,4,5,2,4,8,9,1};
            System.out.println("Задание 3:");
        System.out.println("Исходное значение массива:");
        System. out .println(Arrays. toString (arr));
        System.out.println("Полученное значение массива:");
        System.out.print("[ ");

        for (int index=0; index < arr.length; index++)
        {
            if (arr[index]<6)
            {
                arr[index]=arr[index]*2;
            }

            System.out.print(arr[index]+", ");
        }
        System.out.println("]");
        System.out.println("-----------------");
    }

//Задание 4. Двумерный квадратный массив. Диагональ заполнить единичками
    static void twoArr1()
    {
        int twoArr[][] = new int[5][5];
            System.out.println("Задание 4: Заполняем диагонали единичками");
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
        System.out.println("-----------------");
    }

//Задание 5**. Одномерный массив с вычислением минимального и максимального числа
    static void minmaxArr()
    {
        System.out.println("Задание 5**:");

        int[] arr = {5, 2, 5, 7, 44, 1, 200, 5, 11, 40};
        int maximumVal=arr[0];
        int minimumVal=arr[0];

        System.out.println("Исходное значение массива:");
        System. out .println(Arrays. toString (arr));


        for (int i = 0; i < arr.length; i++)
        {
            //прогоняем вложенным циклом сравнение каждого с каждым
            for (int j = 0; j< arr.length; j++)
            {
                if (arr[j] > arr[i] && arr[j]>maximumVal) //двойное условие для фиксации максимального значения
                {
                maximumVal = arr[j];
                }

                if (arr[j] < arr[i] && arr[j] < minimumVal) //двойное условие для фиксации минимального значения
                {
                    minimumVal = arr[j];
                }
            }

        }
        System.out.println("Максимальное значение архива: "+maximumVal);
        System.out.println("Минимальное значение архива: "+minimumVal);
        System.out.println("-----------------");
        }


    // Задание 6**. Массив с проверкой сумм двух частей массива

    static boolean checkBalance(int[] a)
    {
        System.out.println("Задание 6**:");
        int y=a.length -1; //длина массива -1, определение номера последнего члена массива

        boolean equal = false;

        for (int i = 0; i<a.length; i++) //рассматриваем (длина массива - 1) случаев возможных комбинаций
        {
            int sumLeft = 0;
            int sumRight = 0;
            int j = 0;
            while (j<=i)
            {
               sumLeft = a[j] + sumLeft;
               j++;
            }

            int z = i+1;
            for (int rightInd = z; rightInd<a.length; rightInd++ )
            {
                sumRight = a[rightInd]+sumRight;
            }
            if (sumLeft == sumRight)
            {
                System.out.println("Суммы левой и правой части равны");
                System.out.println("Крайний индекс левой части массива: "+i);
                System.out.print("[ ");
                for (int p = 0; p <=i; p++)
                {
                    System.out.print(a[p]+ " ");

                }
                System.out.print("|| ");
                for (int p2 = i; p2<a.length; p2++)
                {
                    System.out.print(a[p2]+ " ");
                }
                System.out.print("]");
                System.out.println();
               equal = true;

            }
        }



        return (equal);
    }

// Задание 7***. Сдвиг членов массива на значение n

static void shiftNumbers(int[] a, int n)
    {
        System.out.println("Задание 7***: Сдвинуть члены массива на n позиций");
        System.out.println("n = "+n);
        System.out.println("Исходное значение массива:");
        System. out .println(Arrays. toString (a));
        System.out.println("Полученное значение массива:");


        int y = a.length -1; //определение крайнего правого положения в массиве
        int newPos =0;

    if (n>0) //сдвиг вправо
    {
           for (int j = 1; j<=n; j++)
            {
                int tempVal = a[y]; //записываем крайний правый член массива во временную переменную
                for (int i=y; i>0; i--)
                {
                    a[i] = a[i-1]; //сдвиг на одну позицию
                }
                a[0] = tempVal; // запись нулевого члена из временной переменной

            }
    }
    else if (n<0) //сдвиг влево
    {
        for (int j = -1; j >= n; j--)
        {
            int tempVal = a[0]; //записываем крайний правый член массива во временную переменную
            for (int i = 0; i < y; i++)
            {
                a[i] = a[i + 1]; //сдвиг на одну позицию
            }
            a[y] = tempVal; // запись нулевого члена из временной переменной
        }
    }
        System. out .println(Arrays. toString (a));
        System.out.println("-----------------");
    }


    }












