public class Main {
public static void main(String [] args) {
//   Employee employee = new Employee("Иванов Иван Иванович", "инженер", "ivanovii@ivanov.com", "89009009090", 50000, 45 );
  //  employee.printEmpl();

    Employee[] employeeArray = new Employee[5];
    employeeArray[0] = new Employee("Иванов Иван Иванович", "инженер", "ivanovii@mail.ru", "+79009009090", 50000, 45);
    employeeArray[1] = new Employee("Петров Пётр Петрович", "инженер", "petrovpp@mail.ru", "+79009009091", 50000, 35);
    employeeArray[2] = new Employee("Сидоров Сидор Сидорович", "начальник отдела", "sidorovss@mail.ru", "+79009009092", 70000, 40);
    employeeArray[3] = new Employee("Равшанов Равшан Равшанович", "ведущий дизайнер", "ravshanovrr@mail.ru", "+79009009093", 85000, 50);
    employeeArray[4] = new Employee("Гиков Гик Гикович", "java junior developer", "gikovgg@mail.ru", "+79009009094", 30000, 25);

    //выводим в консоль сотрудников старше 40 лет
    System.out.println("Список сотрудников компаниии Сделай Сам, старше 40 лет: ");
    System.out.println();

      for (int i=0; i<employeeArray.length; i++ ){
        if (employeeArray[i].age >40) {
            employeeArray[i].printEmpl();
            System.out.println("____________________________________________");
        }


    }
}

}
