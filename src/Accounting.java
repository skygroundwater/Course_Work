import java.util.*;
import java.util.stream.IntStream;

public class Accounting {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();

        //Базовая сложность
        employeeBook.getAllInfoAboutEmployees();

        System.out.println(employeeBook.getMaxSalary());

        System.out.println(employeeBook.getMinSalary());

        System.out.println(employeeBook.getSumOfSalaries());

        System.out.println(employeeBook.getAverageSalary());

        employeeBook.getNamesOfEmployees();

        //Повышенная сложность
        employeeBook.indexSalaries(10);

        employeeBook.getAllInfoAboutEmployees();

        System.out.println(employeeBook.findMaxSalaryOfDepartment("Инженерный отдел"));

        System.out.println(employeeBook.findMinSalaryOfDepartment("Руководящий отдел"));

        System.out.println(employeeBook.getSumSalariesforDepartment("Палубная команда"));

        System.out.println(employeeBook.getAverageSalaryOfDepartment("Машинное отделение"));

        employeeBook.indexDepartmentSalaries("Отдел связи", 5);

        employeeBook.getAllInfoAboutEmployeesFromDepartment("Отдел связи");
        System.out.println();

        employeeBook.getSalariesIfSalaryLessThanNumber(120000);
        System.out.println();

        employeeBook.getSalariesIfSalaryMoreThanNumber(120000);
        System.out.println();

        //Очень сложно
        employeeBook.removeEmployee("Федоров Максим");

        employeeBook.addEmployee("Евстафий Евстафиевич", "Палубная команда", 79400);

        employeeBook.getAllInfoAboutEmployeesFromDepartment("Палубная команда");
        System.out.println();

        employeeBook.replaceSalaryForEmployee("Евстафий Евстафиевич", 85400);
        employeeBook.replaceDepartmentForEmployee("Евстафий Евстафиевич", "Машинное отделение");

        employeeBook.getAllInfoAboutEmployeesFromDepartment("Машинное отделение");
        System.out.println();

        employeeBook.getAllInfoAboutEmployees();
    }
}
