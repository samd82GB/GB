import java.util.concurrent.LinkedTransferQueue;

public class Arrays {
    static final int SIZE = 10000000;
    static final int HALF = SIZE/2;
    float [] arr = new float[SIZE];
    boolean t1Done = false;
    boolean t2Done = false;

    public void arrayInit (){
        for (int i=0; i <arr.length; i++) {
            arr[i] = 1;
        }
    }

    //заполнение формулами по первому методу массива
    public void arrayFill1 () {
        arrayInit(); //метод заполнения массива единичками
        long a = System.currentTimeMillis();
        for (int i=0; i <arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f+i/5) * Math.cos(0.2f +i/5) * Math.cos(0.4f + i/2));
        }
        long b = System.currentTimeMillis();
        long c = b-a;
        System.out.println("Время заполнения массива формулами одним потоком: "+c+" мс");
    }

    //заполняем массив формулой

    public void arrayFillFormula () throws InterruptedException {
        arrayInit(); //метод заполнения единичками массива
        float [] a1 = new float [HALF];
        float [] a2 = new float [HALF];

        long a = System.currentTimeMillis(); //засекаем исходную точку времени

        System.arraycopy(arr,0, a1,0, HALF); //заполняем первый массив значениями исходного
        System.arraycopy(arr,HALF, a2,0,HALF); // заполняем второй массив значениями исходного

        long b = System.currentTimeMillis(); //время окончания разделения массива
        long h = b-a; //вычисляем время разделения массива
        System.out.println("Время разделения массива: "+h+" мс");

        //первый поток
        Thread t1 =new Thread(()->{
            long c1 = System.currentTimeMillis(); //время начала первого потока
            for (int i=0; i<HALF; i++) {
                a1[i] = (float) (arr[i] * Math.sin(0.2f+i/5) * Math.cos(0.2f +i/5) * Math.cos(0.4f + i/2));
            }
            long c2 = System.currentTimeMillis(); //время окончания первого потока
            long c0 = c2-c1; //вычисляем время первого потока
            System.out.println("Время первого потока: "+c0+" мс");

           });

        //второй поток
        Thread t2 =new Thread(()->{
            long c1 = System.currentTimeMillis(); //время начала второго потока
            for (int i=0; i<HALF; i++) {
                a2[i] = (float) (arr[i] * Math.sin(0.2f+i/5) * Math.cos(0.2f +i/5) * Math.cos(0.4f + i/2));
            }
            long c2 = System.currentTimeMillis(); //время окончания второго потока вычислений
            long c0 = c2-c1;
            System.out.println("Время второго потока: "+c0+" мс");

        });

        t1.start(); //запуск первого потока
        t2.start(); //запуск воторого потока

//ждём выполнения обоих потоков
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//после выполения потоков делаем склейку
           long c1 = System.currentTimeMillis(); //время начала склейки

            System.arraycopy(a1,0, arr,0,HALF); //заполняем исходный массив значениями первого расчётного массива
            System.arraycopy(a2,0, arr,HALF,HALF ); //заполняем вторую часть исходного массива значениями второго расчётного массива
            long c2 = System.currentTimeMillis(); //время окончания склейки

            long c3 = c2-c1; //вычисляем время второго потока
            System.out.println("Время склейки массивов: "+c3+" мс");


    }
}





