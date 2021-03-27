import java.util.*;
import java.util.function.BiConsumer;

public class PhoneBook {


    Map<String, List<String>> phoneBook = new HashMap<>();

   //метод для добавления номера и имени в телефонный справочник,

    public void add (String name, String num ) {
        List<String> list = new ArrayList<>(); //новый пустой лист строк
        List<String> l = phoneBook.getOrDefault(name, list); //считываем лист номеров из мапы, если нет листа, то ставим пустой лист
        l.add(num); //добавляем в считанный лист номер телефона
        phoneBook.put(name, l); //заменяем значение листа с номерами телефонов
        }

    public void printBook () {
        System.out.println("Распечатка всего справочника (имя, список телефонов):");
        phoneBook.forEach((k,v) -> {
            System.out.println(k+" = "+v);});
        System.out.println();

    }

    //метод для считывания номера телефона из коллекции по имени

    public void getPhone (String name) {
       List <String> telFromBook = phoneBook.get(name);   //создаём лист телефонов из справочника по ключу имя
       if (!phoneBook.containsKey(name)) {                 //если имя отсутствует в справочнике, то сообщение, что его нет
           System.out.println("Нет такого имени в списке!");
           }
       else {
        System.out.println("Номер(а) телефона контакта по запросу: "+ name);}
        System.out.println(telFromBook);
    }







    }




