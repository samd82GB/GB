public class Employee {
    String name;
    String post;
    String email;
    String phone;
    int tax;
    int age;

    Employee(String name, String post, String email, String phone, int tax, int age) {
    this.name = name;
    this.post = post;
    this.email = email;
    this.phone = phone;
    this.tax = tax;
    this.age = age;

}

void printEmpl () {
    System.out.println("ФИО сотрудника: "+this.name);
    System.out.println("должность: "+this.post);
    System.out.println("e-mail: "+this.post);
    System.out.println("телефон: "+this.phone);
    System.out.println("оклад: "+this.tax);
    System.out.println("возраст: "+this.age);

}

}
