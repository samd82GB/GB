public class Main {


    public static void main(String[] args) {

    Arrays arrays = new Arrays();
    arrays.arrayFill1(); // вызов метода с одним потоком

        //вызов метода с двумя потоками
        try {
            arrays.arrayFillFormula();
        } catch (InterruptedException e){
            e.printStackTrace();
        }



    }

}
