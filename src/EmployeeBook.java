import java.util.Arrays;
import java.util.Objects;
public class EmployeeBook {
    private final Employee[] employees;
    private int size;
    private static int id;
    public EmployeeBook(Employee[] employees) {
        this.employees = employees;
    }
    private EmployeeBook filterByDepartment(String department) {
        return new EmployeeBook(Arrays.stream(employees).filter(x -> (x != null) && (Objects.equals(x.getDepartment(), department))).toArray(Employee[]::new));
    }
    public EmployeeBook() {
        this.employees = new Employee[10];
    }
    public void addEmployee(String employeeFullName, String employeeDepartment, int employeeSalary) {
        if (size >= employees.length) {
            System.out.println("Employee Book is full");
        }
        Employee newEmployee = new Employee(employeeFullName, employeeDepartment, employeeSalary);
        employees[size++] = newEmployee;
    }
    public double getMinSalary() {
        double minSalary = employees[0].getSalary();
        for (int i = 0; i < size; i++) {
            if (employees[i].getSalary() < minSalary) {
                minSalary = employees[i].getSalary();
            }
        }
        return minSalary;
    }
    public double getMaxSalary() {
        double maxSalary = employees[0].getSalary();
        for (int i = 0; i < size; i++) {
            if (maxSalary < employees[i].getSalary()) {
                maxSalary = employees[i].getSalary();
            }
        }
        return maxSalary;
    }
    public double getAverageSalary() {
        int sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum / employees.length;
    }
    public double getAverageSalaryOfDepartment(String employeeDepartment) {
        return this.filterByDepartment(employeeDepartment).getAverageSalary();
    }
    public double getSumOfSalaries() {
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            sum += employees[i].getSalary();
        }
        return sum;
    }
    public double findMinSalaryOfDepartment(String employeeDepartment) {
        return this.filterByDepartment(employeeDepartment).getMinSalary();
        }
    public double findMaxSalaryOfDepartment(String employeeDepartment) {
        return this.filterByDepartment(employeeDepartment).getMaxSalary();
    }
    public double indexSalaries(double index) {
        System.out.println("Проиндексировали зарплату всех сотрудников на "+index + " процентов");
        index = index/100+1;
        for (int i = 0; i < size; i++) {
            employees[i].setSalary(index * employees[i].getSalary());
            System.out.println(employees[i].getFullName() + ": " + employees[i].getSalary());
        }
        return index;
    }
    public double indexDepartmentSalaries(String employeeDepartment, double index) {
        System.out.println("Проиндексировали зарплату всех сотрудников отдела "+employeeDepartment+" на "+index+" процентов");
        index = index/100+1;
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee.getDepartment().equals(employeeDepartment)) {
                employees[i].setSalary(index * employees[i].getSalary());
                System.out.println(employees[i].getFullName() + ": " + employees[i].getSalary());
            }
        }
        return index;
    }
    public void getNamesOfEmployees() {
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            System.out.println(employee.getFullName());
        }
    }
    public void getNamesOfEmployeesFromDepartment(String employeeDepartment) {
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee.getDepartment().equals(employeeDepartment)) {
                System.out.println(employee.getFullName());
            }
        }
    }
    public void getSalariesIfSalaryLessThanNumber(int Number){
        System.out.println("Зарплата меньше "+Number+" рублей у сотрудников: ");
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if(employee.getSalary()<Number){
                System.out.println(employee.getFullName() + " " + employee.getSalary());
            }
        }
    }
    public void getSalariesIfSalaryMoreThanNumber(int Number){
        System.out.println("Зарплата больше "+Number+" рублей у сотрудников: ");
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if(employee.getSalary()>Number){
                System.out.println(employee.getFullName() + " " + employee.getSalary());
            }
        }
    }
    public void getAllInfoAboutEmployees() {
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            System.out.println(employee.getInfo());
        }
    }
}