import java.util.concurrent.LinkedTransferQueue;

public class Arrays {
    static final int SIZE = 10000000;
    static final int HALF = SIZE/2;
    float [] arr = new float[SIZE];


    //заполнение формулами по первому методу массива
    public void arrayFill1 () {
        long a = System.currentTimeMillis();
        for (int i=0; i <arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f+i/5) * Math.cos(0.2f +i/5) * Math.cos(0.4f + i/2));
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
        System.arraycopy(arr,0, a1,0, HALF); //заполняем первый массив значениями исходного
        System.arraycopy(arr,HALF, a2,0,HALF); // заполняем второй массив значениями исходного
        long g = System.currentTimeMillis(); //время окончания разделения массива и начала первого потока
        //первый поток
        Thread t1 =new Thread(()->{

            for (int i=0; i<HALF; i++) {
                a1[i] = (float) (arr[i] * Math.sin(0.2f+i/5) * Math.cos(0.2f +i/5) * Math.cos(0.4f + i/2));
            }
        });
        long d = System.currentTimeMillis(); //время окончания первого потока и начала второго

        //второй поток
        Thread t2 =new Thread(()->{

            for (int i=0; i<HALF; i++) {
                a2[i] = (float) (arr[i] * Math.sin(0.2f+i/5) * Math.cos(0.2f +i/5) * Math.cos(0.4f + i/2));
            }
        });
        t1.start(); //запуск первого потока
        t2.start(); //запуск воторого потока

        long e = System.currentTimeMillis(); // время начала склейки


        System.arraycopy(a1,0, arr,0,HALF); //заполняем исходный массив значениями первого расчётного массива
        System.arraycopy(a2,0, arr,HALF,HALF ); //заполняем вторую часть исходного массива значениями второго расчётного массива


        long b = System.currentTimeMillis();
        long h = g-a; //вычисляем время разделения массива
        long i = d-g; //вычисляем время первого потока
        long j = e-d; //вычисляем время второго потока
        long o = b-e; //вычисляем время склейки
        long f = b-a; //вычисляем время выполнения метода


        System.out.println("Время разделения массива: "+h+" мс");
        System.out.println("Время первого потока: "+i+" мс");
        System.out.println("Время 2-го потока: "+j+" мс");
        System.out.println("Время склейки: "+o+" мс");
        System.out.println("Время метода: "+f+" мс");
    }

    }





