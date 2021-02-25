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
    public static int xR;
    public static int yR;


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
        if (x < 0 || x >= size || y < 0 || y >= size) {
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
    //если есть условие для сопротивления, то выставялем координаты сопротивления, если нет, то Рандом
    static void checkPC() {

       if (!checkTheManTurn(dot_X, x, y)){
       Random rand = new Random();
        do {
            x = rand.nextInt(size);
            y = rand.nextInt(size);
        }
        while (!isCellOK(x, y));
       } else {
           x = xR;
           y = yR;
       }

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

        //проверяем горизонталь и вертикаль на предмет победы
        boolean checkX = checkAxes(dot, x, y);
        if (checkX){System.out.println("Выигрыш по оси X");}
        boolean checkY = checkAxes2(dot, x, y);
        if (checkY){System.out.println("Выигрыш по оси Y");}

        //проверяем диагонали относительно координат последнего хода
        boolean checkD1 = checkDiagonal1(dot, x, y);
        if (checkD1){System.out.println("Выигрыш по диагонали 1");}

        //проверяем диагональ 2 относительно координат
        boolean checkD2 = checkDiagonal2(dot, x, y);
        if (checkD2){System.out.println("Выигрыш по диагонали 2");}

        //определение выигрыша
        if (checkX||checkY||checkD1||checkD2)
        {
            return true;
        }
        return false;
    }

//проверка выигрыша по оси X
    static boolean checkAxes (char dot, int cAx1, int cAx2) {

        int counterAx =0;
        int axLim = cAx1-1;

         for (int i = cAx1; i <size; i++) {
            if (map[cAx2][i]==dot){
                counterAx = counterAx+1;}
                else break;
            }

         for (int i = axLim; i>=0 ; i--) {
                if (map[cAx2][i] == dot) {
                    counterAx = counterAx+1;}
                else break;
            }

         if (counterAx >= dotsToWin) //количество символов игрока достигло необходимого для победы по оси
            {
                return true;
            }
         return false;
        }
//проверка выигрыша по оси Y
    static boolean checkAxes2 (char dot, int cAx1, int cAx2) {

        int counterAx = 0;
        int axLim = cAx2 - 1;

        for (int i = cAx2; i < size; i++) {
            if (map[i][cAx1] == dot) {
                counterAx = counterAx + 1;
            } else break;
        }

        for (int i = axLim; i >= 0; i--) {
            if (map[i][cAx1] == dot) {
                counterAx = counterAx + 1;
            } else break;
        }
        if (counterAx >= dotsToWin) //количество символов игрока достигло необходимого для победы по оси
        {
            return true;
        }
        return false;
    }


//проверка выигрыша по диагонали 1 (слева направо)
    static boolean checkDiagonal1 (char dot, int cAx1, int cAx2) {

        int counterD1 =0;
        int dLim1 = cAx1-1;
        int dLim2 = cAx2-1;
//перебираем вверх по диагонали

        for (int i = cAx1; i <size; i++) {
            if (cAx2 >= size) {
                break;
            }
            if (map[cAx2][i] == dot) {
                counterD1 = counterD1 + 1;
            } else {
                break;
            }
            cAx2=cAx2+1;
        }

//перебираем вниз по диагонали

        for (int i = dLim1; i>=0 ; i--) {
            if (dLim2 <0) {
                break;
            }
            if (map[dLim2][i] == dot) {
                counterD1 = counterD1 + 1;
            } else {
                break;
            }
            dLim2=dLim2-1;
        }

        if (counterD1>=dotsToWin) //количество символов игрока достигло необходимого для победы по оси
        {
            return true;
        }
        return false;
    }

    //проверка выигрыша по диагонали 2 (справа налево)
    static boolean checkDiagonal2 (char dot, int cAx1, int cAx2) {

        int counterD1 =0;
        int dLim1 = cAx1-1;
        int dLim2 = cAx2-1;
//перебираем вверх по диагонали

        for (int i = cAx1; i <size; i++) {
            if (cAx2 < 0) {
                break;
            }
            if (map[cAx2][i] == dot) {
                counterD1 = counterD1 + 1;
            } else {
                break;
            }
            cAx2=cAx2-1;
        }

//перебираем вниз по диагонали

        for (int i = dLim1; i>=0 ; i--) {
            if (dLim2 < size) {
                break;
            }
            if (map[dLim2][i] == dot) {
                counterD1 = counterD1 + 1;
            } else {
                break;
            }
            dLim2=dLim2+1;
        }

        if (counterD1>=dotsToWin) //количество символов игрока достигло необходимого для победы по оси
        {
            return true;
        }
        return false;
    }

    //алгоритм сопротивления

    static boolean checkTheManTurn (char dot, int cAx1, int cAx2) {
        int counterX1 =0;
        int counterX2 =0;
        int dotsToResist =dotsToWin-2; //количество символов подряд в направлении для сопротивления
        int x1 =0;
        int x2 =0;
        int y1 = 0;
        int y2 = 0;
        boolean axeX1 = false;
        boolean axeX2 = false;
        boolean axeY1 = false;
        boolean axeY2 = false;
        boolean axeD11 = false;
        boolean axeD12 = false;
        boolean axeD21 = false;
        boolean axeD22 = false;

        //проверка игры человека по оси X
        for (int i = cAx1; i <size; i++) {
            if (map[cAx2][i]==dot){
                counterX1 = counterX1+1;}
            else break;
        }

        for (int i = cAx1; i>=0 ; i--) {
            if (map[cAx2][i] == dot) {
                counterX2 = counterX2+1;}
            else break;
        }


        if (counterX1>=dotsToResist){
            x1=cAx1+counterX1;
            x2=cAx1-counterX2;
            axeX1 = true;

        }
        if (counterX2>=dotsToResist){
            x2=cAx1-counterX2;
            x1=cAx1+counterX1;
            axeX2 = true;
        }


    //проверка условий сопротивления по оси Y
        int counterY1 =0;
        int counterY2 =0;



        for (int i = cAx2; i < size; i++) {
            if (map[i][cAx1] == dot) {
                counterY1 = counterY1 + 1;
            } else break;
        }

        for (int i = cAx2; i >= 0; i--) {
            if (map[i][cAx1] == dot) {
                counterY2 = counterY2 + 1;
            } else break;
        }
        if (counterY1>=dotsToResist){
            y1=cAx1+counterY1;
            y2=cAx1-counterY2;
            axeY1 = true;
        }
        if (counterY2>=dotsToResist){
            y2=cAx1-counterY2;
            y1=cAx1+counterY1;
            axeY2 = true;
        }

    //проверка сопротивления по диагонали 1

        int counterD11 = 0;
        int counterD12 = 0;
        int x3 = 0;
        int x4 = 0;
        int y3 = 0;
        int y4 = 0;

    //перебираем вверх по диагонали
        int j = cAx2;
        for (int i = cAx1; i <size; i++) {
            if (j >= size) {
                break;
            }
            if (map[j][i] == dot) {
                counterD11 = counterD11 + 1;
            } else {
                break;
            }
            j=j+1;
        }

    //перебираем вниз по диагонали
        int j1 = cAx2;
        for (int i = cAx1; i>=0 ; i--) {
            if (j1 <0) {
                break;
            }
            if (map[j1][i] == dot) {
                counterD12 = counterD12 + 1;
            } else {
                break;
            }
            j1=j1-1;
        }

        if (counterD11>=dotsToResist){
            x3 = cAx1+counterD11;
            y3 = cAx2+counterD11;
            x4 = cAx1-counterD12;
            y4 = cAx2-counterD12;
            axeD11 = true;
        }
        if (counterD12>=dotsToResist){
            x3 = cAx1+counterD11;
            y3 = cAx2+counterD11;
            x4 = cAx1-counterD12;
            y4 = cAx2-counterD12;

            axeD12 = true;

        }

    //проверка сопротивления по диагонали 2

        int counterD21 = 0;
        int counterD22 = 0;
        int x5 = 0;
        int x6 = 0;
        int y5 = 0;
        int y6 = 0;
    //перебираем вверх по диагонали
        int j2 = cAx2;
        for (int i = cAx1; i <size; i++) {
            if (j2 < 0) {
                break;
            }
            if (map[j2][i] == dot) {
                counterD21 = counterD21 + 1;
            } else {
                break;
            }
            j2=j2-1;
        }

    //перебираем вниз по диагонали
        int j3 = cAx2;
        for (int i = cAx1; i>=0 ; i--) {
            if (j3 >= size) {
                break;
            }
            if (map[j3][i] == dot) {
                counterD22 = counterD22 + 1;
            } else {
                break;
            }
            j3=j3+1;
        }
        if (counterD21>=dotsToResist){
            x5 = cAx1+counterD21;
            y5 = cAx2-counterD21;
            x6 = cAx1-counterD22;
            y6 = cAx2+counterD22;
            axeD21 = true;
        }
        if (counterD22>=dotsToResist){
            x6 = cAx1-counterD22;
            y6 = cAx2+counterD22;
            x5 = cAx1+counterD21;
            y5 = cAx2-counterD21;
            axeD22 = true;
        }

    //выбираем координаты для хода

    if (axeX1||axeX2||axeY1||axeY2||axeD11||axeD12||axeD21||axeD22){
        if (isCellOK(x1, y)&&axeX1){
            xR=x1;
            yR=y;
        } else if (isCellOK(x2, y)&&axeX1){
            xR=x2;
            yR=y;
        }
        if (isCellOK(x2, y)&&axeX2){
            xR=x2;
            yR=y;
        } else if (isCellOK(x1, y)&&axeX2){
            xR=x1;
            yR=y;
        }
        if (isCellOK(x, y1)&&axeY1){
            xR=x;
            yR=y1;
        } else if (isCellOK(x, y2)&&axeY1){
            xR=x;
            yR=y2;
        }
        if (isCellOK(x, y2)&&axeY2){
            xR=x;
            yR=y2;
        } else if (isCellOK(x, y1)&&axeY2){
            xR=x;
            yR=y1;
        }
        if (isCellOK(x3, y3)&&axeD11){
            xR=x3;
            yR=y3;
        } else if (isCellOK(x4, y4)&&axeD11){
            xR=x4;
            yR=y4;
        }
        if (isCellOK(x4, y4)&&axeD12){
            xR=x4;
            yR=y4;
        } else if (isCellOK(x3, y3)&&axeD12){
            xR=x3;
            yR=y3;
        }
        if (isCellOK(x5, y5)&&axeD21){
            xR=x5;
            yR=y5;
        } else if (isCellOK(x6, y6)&&axeD21){
            xR=x6;
            yR=y6;
        }
        if (isCellOK(x6, y6)&&axeD22) {
            xR = x6;
            yR = y6;
        } else if (isCellOK(x5, y5)&&axeD22){
            xR=x5;
            yR=y5;
        }

       if (isCellOK(xR, yR)) {
           return true;
       }
    }
    return false;
    }


}





