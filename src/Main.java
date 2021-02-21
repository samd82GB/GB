import java.util.Random;
import java.util.Scanner;

public class Main {

    static int newGame =0;

    static int intfromConsole()  //Метод проверки введённых значений на int
    {
       do {
           Scanner sc = new Scanner(System.in);
            if (sc.hasNextInt())
            {
                return sc.nextInt();
            }
           System.out.println("Требуется ввести целое число!");

                sc.nextLine();
      }
        while (true);
    }

    static int theEndOrNot()   //Метод окончания работы программы и выхода из игры
    {
        System.out.println("Повторить игру ещё раз? да -1, нет - любое число");
        int newGame = intfromConsole();
        return (newGame);

            }

    static void theGame()   // Метод проведения игры Угадай число!
    {

        int range = 10;
        Random rand = new Random();
        int number = rand.nextInt(range);
        int counter = 3;

        int diffRange = range - 1;
        System.out.println("Угадайте число от 0 до " + diffRange);
        System.out.println("У вас " + counter + " попытки");

        while (counter>0) {
            int input_number = intfromConsole();
            if (number == input_number) {
                System.out.println("Вы угадали число!!! Поздравляем, вы победитель!!!");
                break;
            }
            else if (input_number > number) {
                counter -= 1;
                System.out.println("Указанное число больше, чем загаданное!");
                System.out.println("Оставшееся количество попыток " + counter);

            }
             else if (input_number < number) {
                counter -= 1;
                System.out.println("Указанное число меньше, чем загаданное!");
                System.out.println("Оставшееся количество попыток " + counter);

            }
        }
    if (counter==0) {
       System.out.println("Вы проиграли!");
       }

    int selection = theEndOrNot();
        if (selection==1)
        {
            Main.theGame();
        }
        else
        {
            Main.selectTheGame();
        }



    }

    static void selectTheGame() {
        do {
            System.out.println("Выбери игру! 1 - Угадай число/2 - Угадай слово/0 - Выйти");
            int selectGame = intfromConsole();
            if (selectGame == 1) {
                Main.theGame();

            } else if (selectGame == 2) {
                Main2.theGame2();
                int selection = theEndOrNot();
                if (selection==1)
                {
                    Main2.theGame2();
                }
                else
                {
                    Main.selectTheGame();
                }

            }
            else if (selectGame == 0)
            {
                System.exit(0);
            }
            else selectTheGame();
        }
        while (true);
    }

    public static void main (String[] args) {

        selectTheGame(); //Метод выбора игры





    }


    }






