import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main2 {

    // 1. Объявить массив
    // 2. Загадать слово компьютером
    // 3. Спросить игрока записать слово в консоль
    // 4. Сравнить слова из консоли и загаданное
    // 5. Если слова совпали, то игра окончена
    // 6. Если слова не совпали, то запускаем метод сравнения побуквенно
    // 7. Если совпадают буквы, то выносим эти буквы с их индексом в массив отображения
    // остальные буквы и члены массива отображения штрихуем решётками
    // 8. Возвращаемся к пункту 3. для ввода слова до тех пор, пока не будет угадано всё слово
    // 9. Окончание игры, вопрос будем ли продолжать?

    static String[] words = {"apple", "orange", "lemon", "banana", "apricot",
            "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
            "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
            "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    static char[] showChars = new char[15];
    static String inputWord;
    static String wordToGuess;

   public static void theGame2() {
       System.out.println("Игра Угадай слово!");
       System.out.println("Нужно угадать слово из следующих значений: ");
      /* System. out .println(Arrays.toString(words));*/
//Сделал цикл для того, чтобы раскидать массив слов на несколько строчек при печати
       for (int p= 0; p< words.length; p++)
       {
           int n = (p+1)%8;
           int n2 = words.length-1;

           if (p==n2)
           {
               System.out.print(words[p]+" ]");
               System.out.println();
           }
           else if (n==0&&p!=0)
           {
               System.out.print(words[p]+ ", ");
               System.out.println();
           }
           else if (p==0)
           {
               System.out.print("["+words[p]+", ");
           }
           else System.out.print(words[p]+ ", ");
       }

       wordToGuess = newWord();
       startGame();
       System.out.println("Поздравляем! Вы угадали слово " + wordToGuess);
       //Обнуляем значения массива отображения перед началом новой игры
       for (char zero:showChars)
       {
        zero = '#';
       }
   }

    static void startGame () {
        System.out.println("Введите новое слово!");
        inputWord = enterWord();

        do {
            boolean winGame = equalWords(inputWord, wordToGuess);
            if (!winGame) {
                equalChars(inputWord, wordToGuess);
                System.out.println("Вы не угадали слово! Посмотрите угаданные буквы!");
                System.out.print(showChars);
                System.out.println();
                System.out.println("Попробуйте ещё раз!");
                startGame();
            } else break;

        }
        while (true);
    }

    static String enterWord () //Ввод нового слова в консоль
    {

        Scanner input = new Scanner(System.in);
        String inputWord = input.nextLine();  // Записываем значение из консоли в переменную
        return inputWord;
    }

    static String  newWord () // Метод для загадывания слова компьютером
    {
        Random rand = new Random();
        int guessIndex = rand.nextInt(words.length);
        String wordToGuess = words[guessIndex]; //Загаданное число из массива с индексом по функции Random
        return wordToGuess;
    }

    static boolean equalWords (String inputWord, String wordToGuess)   //Метод для сравнения слов и дальнейшей логики программы
    {
        if (inputWord.equals(wordToGuess))
        {

        return true;
        }
           else return false;
        }

    static void equalChars (String inputWord, String wordToGuess )   // Метод сравнения чаров в введённом и загаданном словах и заполения #
    {
        int la = inputWord.length(); // получаем длину введённого слова
        int lb = wordToGuess.length(); // получаем длину загаданного слова
        char [] iWch = new char[la];    // вспомогательный массив char длиной введенного слова
        char [] wTGch = new char[lb];   // вспомогательный массив char длиной загаданного слова

        for (int i =0; i<la; i++)
        {
            iWch[i] = inputWord.charAt(i);
        }

        for (int i =0; i<lb; i++)
        {
            wTGch[i] = wordToGuess.charAt(i);
        }
//Определение границы для сравнения букв в загаданном и введённом словах, выбираем более короткое слово
        int limChars = 0;
        if (la>=lb)
        {
            limChars = lb;
        }
        else {
            limChars = la;
        }
//Если чары равны, то записываем в массив отображения букву загаданного слова
        char grid = '#';
        for (int i=0; i< limChars; i++)   //цикл от 0 до размера минимального слова для проверки букв
        {
            if (iWch[i]==wTGch[i])
            {
                showChars [i]= wTGch[i];

            }
            //Условие, чтобы при последующих заходах не затирались ранее угаданные буквы
            else if (showChars[i]!=wTGch[i])
            {
                showChars[i] = grid;
            }
        }
        for (int i=limChars;i<showChars.length;i++)
            showChars[i] = grid;

    }

}



