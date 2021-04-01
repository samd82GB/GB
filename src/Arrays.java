import java.util.concurrent.LinkedTransferQueue;

public class Arrays {
    static final int SIZE = 10000000;
    static final int HALF = SIZE/2;
    float [] arr = new float[SIZE];


    //заполнение единичками массива
    public void arrayFill1 () {
        long a = System.currentTimeMillis();
        for (int i=0; i <arr.length; i++) {
            arr[i] = 1;

        }
        long b = System.currentTimeMillis();
        long c = b-a;
        System.out.println("Время заполнения массива единицами одним потоком: "+c+" мс");
    }

    //заполняем массив формулой

    public void arrayFillFormula () {

        float [] a1 = new float [HALF];
        float [] a2 = new float [HALF];

        long a = System.currentTimeMillis(); //засекаем исходную точку времени

        //первый поток
        Thread t1 =new Thread(()->{
            System.arraycopy(arr,0, a1,0, HALF); //заполняем первый массив значениями исходного
            for (int i=0; i<HALF; i++) {
                a1[i] = (float) (arr[i] * Math.sin(0.2f+i/5) * Math.cos(0.2f +i/5) * Math.cos(0.4f + i/2));
            }
        });


        //второй поток
        Thread t2 =new Thread(()->{
            System.arraycopy(arr,HALF, a2,0,HALF); // заполняем второй массив значениями исходного
            for (int i=0; i<HALF; i++) {
                a2[i] = (float) (arr[i] * Math.sin(0.2f+i/5) * Math.cos(0.2f +i/5) * Math.cos(0.4f + i/2));
            }
        });
        t1.start(); //запуск первого потока
        t2.start(); //запуск воторого потока

        System.arraycopy(a1,0, arr,0,HALF); //заполняем исходный массив значениями первого расчётного массива
        System.arraycopy(a2,0, arr,HALF,HALF ); //заполняем вторую часть исходного массива значениями второго расчётного массива


        long b = System.currentTimeMillis();
        long c = b-a; //вычисляем время выполнения метода
        System.out.println("Время заполнения массива формулами при помощи 2-х потоков: "+c+" мс");
    }

    }





