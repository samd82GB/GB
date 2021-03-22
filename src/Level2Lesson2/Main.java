package Level2Lesson2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //массив без ошибок. закоментировать для работы с массивами с ошибками
        String [][] ar = {
                {"10", "11", "12", "13"},
                {"20", "21", "22", "23"},
                {"30", "31", "32", "33"},
                {"40", "41", "42", "43"}
        };

        //массив с неправильными размерами. Раскомментировать чтобы поймать исключение по размерам массива, и закомментировать другие массивы
       /* String [][] ar = {
                {"10", "11", "12", "13"},
                {"20", "21", "22", "23"},
                {"30", "31", "32", "33"},
                {"40", "41", "42", "43", "45"},
                {"50"}
        };
        */
        // массив с неправильными данными. Расскомментировать, чтобы поймать исключение по ошибке данных с указанием координат, и закомментировать другие массивы
        /*String [][] ar = {
                {"10", "11", "12", "13"},
                {"20", "21", "22", "23"},
                {"30", "31", "32ss", "33"},
                {"40", "41", "42", "43"}
        };
        */




//вычисляем сумму элементов массива с ловлей исключений по размеру (должен быть 4*4) и ошибке данных (должны быть цифры)
        try {
            System.out.println("Сумма элементов массива: "+sumArray(ar));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
            System.out.println("количество строк "+ e.getqStrings());
            System.out.println("длины строк "+Arrays.toString(e.getqColumns()));
        } catch (MyArrayDataException e1) {
            e1.printStackTrace();
            System.out.println("неверный формат данных "+ e1.getNotNumber() + " по координатам: ");
            System.out.println("строка: "+e1.getNumberString());
            System.out.println("колонка: "+e1.getNumberColumn());
        } finally {
            System.out.println("Рассчёт закончен!");
        }




    }
    /**
     * вычисление суммы члена массива
     * @param ar количество строк должно быть равно 4, длина каждой строки должна быть равна 4
     * @throws MyArraySizeException при нарушении размера массива
     * @throws MyArrayDataException при записи в исходный массив
    */
    public static int sumArray (String [][] ar) throws MyArraySizeException, MyArrayDataException {
        int arCountString = 0;
        int [] arCountColumn = new int[ar.length]; //массив зависящий от размера входящего массива
        int [] arCountColumn2 = new int[ar.length]; //массив зависящий от размера входящего массива
        int arSum = 0;



        for (int i =0; i<ar.length; i++) {
            arCountString++;

            //проверка количества данных в каждой строке
            arCountColumn[i] = ar[i].length;

            if (ar[i].length != 4) {
                throw new MyArraySizeException("Ошибка размера массива по длине строки: " + i, ar.length, arCountColumn);

            }
            for (int j = 0; j < ar[i].length; j++) {

                //расчёт суммы массива, если данные корректны
                //если данные не корректны, то обработка исключения с указание координат ошибки
                try {
                    arSum = arSum + Integer.parseInt(ar[i][j]);
                } catch (NumberFormatException e) { //если имеется исключение NumberFormatException, то пробрасываем наше исключение с координатами
                    throw new MyArrayDataException("Ошибка данных ", ar[i][j], i, j);
                }
            }

            //проверка количества строк и расчёт элементов в каждой строке
            if (ar.length != 4) {
                for (int z=0; z<ar.length; z++) {
                    arCountColumn2[z] = ar[z].length;
                }
                throw new MyArraySizeException("Ошибка размера массива по количеству строк: " + ar.length, ar.length, arCountColumn2);
            }
        }

        System.out.println("Количество строк в массиве: "+arCountString);
        System.out.println("Количество колонок в массиве по строкам: "+ Arrays.toString(arCountColumn));

            return arSum;
    }



}

