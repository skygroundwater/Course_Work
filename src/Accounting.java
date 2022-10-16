import java.util.*;
import java.util.stream.IntStream;

public class Accounting {
    public static void main(String[] args) {

        EmployeeBook employeeBook = new EmployeeBook();

        employeeBook.addEmployee("Дуравкин Алексей", "Руководящий отдел", 134000);
        employeeBook.addEmployee("Метелев Олег", "Руководящий отдел", 124500);
        employeeBook.addEmployee("Федоров Максим", "Отдел связи", 118350);
        employeeBook.addEmployee("Витюк Григорий", "Отдел связи", 104800);
        employeeBook.addEmployee("Куриш Виктор", "Палубная команда", 96700);
        employeeBook.addEmployee("Давитадзе Тариел", "Палубная команда", 91300);
        employeeBook.addEmployee("Каширский Сергей", "Инженерный отдел", 109700);
        employeeBook.addEmployee("Горчаков Александр", "Инженерный отдел", 102800);
        employeeBook.addEmployee("Некрасов Дмитрий", "Машинное отделение", 100300);
        employeeBook.addEmployee("Говоров Александр", "Машинное отделение", 98600);

        employeeBook.getAllInfoAboutEmployees();
        employeeBook.indexSalaries(30);




        }
    }
