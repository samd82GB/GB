import java.util.Random;
import java.util.Scanner;

public class Main {

    public static char[][] map;
    public static final int size = 5;
    public static final int dotsToWin = 4;
    public static final char dot_X = 'X';
    public static final char dot_0 = '0';
    public static final char emptyDot = '.';
    public static int x;
    public static int y;


    public static void main(String[] args) {
        initMap();
        printMap();
        startTheGame();

        System.out.println("Игра закончена!");
    }

    static  void startTheGame ()
    {
        while (true) {
            chekHuman();  //ход человека
            printMap();   //отрисовка поля игры в консоле
            //проверка победы человека
            if (checkToWin(dot_X, x, y)) {
                System.out.println("Победу одержал человек!");
                break;
            }
            //проверка на ничью после хода человека
            if (chekDraw()) {
                System.out.println("Ничья!");
                break;
            }

            checkPC(); //проверка хода ПК
            printMap(); //отрисовка поля игры после хода ПК
            //проверка на победу после хода ПК
            if (checkToWin(dot_0, x, y)) {
                System.out.println("Победу одержал компьютер");
                break;
            }
            //проверка на ничью после хода ПК
            if (chekDraw()) {
                System.out.println("Ничья!");
                break;
            }

        }
    }
    //инициализация поля
    static void initMap() {
        map = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = emptyDot;
            }
        }
    }

    //вывод поля в консоль с текущими значениями
    static void printMap() {
        //заполняем первую строчку значениями координаты X
        for (int i = 0; i <= size; i++) {
            if (i == 0) {
                System.out.print("  ");
            } else System.out.print(i + " ");
        }
        System.out.println();

        // заполняем следующие строки данными номера строки и значением поля
        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < size; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean isCellOK(int x, int y) {
        if (x < 0 || x > size || y < 0 || y > size) {
            return false;
        }
        if (map[y][x] == emptyDot) {
            return true;
        } else return false;
    }

    // проверка хода человека
    static void chekHuman() {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Введите координаты X и Y для хода!");
            x = sc.nextInt() - 1; //человек вводит значение от 1 до 3, поэтому для определния положения в массиве вычитаем 1
            y = sc.nextInt() - 1;

        }
        while (!isCellOK(x, y));
        map[y][x] = dot_X; //записываем в массив сначала y, потом x, потому что в массивах первый индекс - номера строк,
                           // второй индекс - номера столбцов
    }

    // проверка хода ПК
    static void checkPC() {
        Random rand = new Random();
        do {
            x = rand.nextInt(size);
            y = rand.nextInt(size);
        }
        while (!isCellOK(x, y));
        System.out.println("Компьютер сделал ход по координатам X: " + (x + 1) + "; Y: " + (y + 1));
        map[y][x] = dot_0;
    }

    //проверка на ничью. если поле имеет хотя бы одну пустую клеточку, то играем дальше
    static boolean chekDraw() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == emptyDot) {
                    return false;
                }

            }
        }
        return true;
    }

    //проверка на победу
    //имеем для каждой координаты 8 направлений, считаем по ним количество символов подряд
    static boolean checkToWin(char dot, int x, int y) {

        int cx = 0; //счётчик символов по х
        int cy = 0; //счётчик символов по y

        for (int i = x; i >= 0; i--) //считаем символы от х до 0
        {
            if (map[y][i] == dot) {
                cx += 1;
            }
        }
        int lx = x + 1;
        for (int i = lx; i < size; i++) //считаем символы от x+1 до size
        {
            if (map[y][i] == dot) {
                cx += 1;
            }
        }
        if (cx == dotsToWin) //количество символов игрока достигло необходимого для победы по оси Х
        {
            return true;
        }

        for (int i = y; i >= 0; i--) //считаем символы от y до 0
        {
            if (map[i][x] == dot) {
                cy += 1;
            }
        }
        int ly = y + 1;
        for (int i = ly; i < size; i++) //считаем символы от y+1 до size
        {
            if (map[i][x] == dot) {
                cy += 1;
            }
        }
        if (cy == dotsToWin) //количество символов игрока достигло необходимого для победы по оси Y
        {
            return true;
        }


        //проверяем диагонали относительно координат последнего хода

        int cd1 = 0; //счётчик символов по диагонали 1

        for (int i = x; i >= 0; i--) {  //считаем от х вниз по диагонали 1 влево
            for (int j = y; j < size; j++) {
                if (map[j][i] == dot) {
                    cd1 += 1;
                }
            }
        }
        for (int i = lx; i < size; i++) {  //считаем от х вверх по диагонали 1 вправо
            for (int j = ly; j > 0; j--) {
                if (map[j][i] == dot) {
                    cd1 += 1;
                }
            }
        }
        if (cd1 == dotsToWin) //количество символов игрока достигло необходимого для победы по диагонали 1
        {
            return true;
        }

        //проверяем диагональ 2 относительно координат

        int cd2 = 0;
        for (int i = x; i >= 0; i--) {  //считаем от х вверх по диагонали 2 влево
            for (int j = y; j >= 0; j--) {
                if (map[j][i] == dot) {
                    cd2 += 1;
                }
            }
        }
        for (int i = lx; i < size; i++) {  //считаем от х вниз по диагонали 2 вправо
            for (int j = ly; j < size; j++) {
                if (map[j][i] == dot) {
                    cd2 += 1;
                }
            }
        }
        if (cd2 == dotsToWin) //количество символов игрока достигло необходимого для победы по диагонали 1
        {
            return true;
        }
        return false;
    }
}


