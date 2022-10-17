import java.util.Arrays;
import java.util.Objects;
public class EmployeeBook {
    private final Employee[] employees;
    private EmployeeBook(Employee[] employees) {
        this.employees = employees;
    }
    private EmployeeBook filterByDepartment(String department) {
        return new EmployeeBook(Arrays.stream(employees).filter(x -> (x != null) && (Objects.equals(x.getDepartment(), department))).toArray(Employee[]::new));
    }
    EmployeeBook() {
        this.employees = new Employee[10];
        employees[0]= new Employee("Дуравкин Алексей", "Руководящий отдел", 134000);
        employees[1]= new Employee("Метелев Олег", "Руководящий отдел", 124500);
        employees[2]= new Employee("Федоров Максим", "Отдел связи", 118350);
        employees[3]= new Employee("Витюк Григорий", "Отдел связи", 104800);
        employees[4]= new Employee("Куриш Виктор", "Палубная команда", 96700);
        employees[5]= new Employee("Давитадзе Тариел", "Палубная команда", 91300);
        employees[6]= new Employee("Каширский Сергей", "Инженерный отдел", 109700);
        employees[7]= new Employee("Горчаков Александр", "Инженерный отдел", 102800);
        employees[8]= new Employee("Некрасов Дмитрий", "Машинное отделение", 100300);
        employees[9]= new Employee("Говоров Александр", "Машинное отделение", 98600);
    }
    public void addEmployee(String employeeFullName, String employeeDepartment, int employeeSalary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                Employee newEmployee = new Employee(employeeFullName, employeeDepartment, employeeSalary);
                employees[i] = newEmployee;
                return;
            }
        }
    }
    public void removeEmployee(String employeeFullName){
        for (int i = 0; i < employees.length; i++) {
            if(employees[i].getFullName().equals(employeeFullName)){
                employees[i]=null;
                return;
            }
        }
    }
    public double getMinSalary() {
        double minSalary = employees[0].getSalary();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < minSalary) {
                minSalary = employees[i].getSalary();
            }
        }
        return minSalary;
    }
    public double getMaxSalary() {
        double maxSalary = employees[0].getSalary();
        for (int i = 0; i < employees.length; i++) {
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
    public double getSumSalariesforDepartment(String employeeDepartment){
        return this.filterByDepartment(employeeDepartment).getSumOfSalaries();
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
        for (int i = 0; i < employees.length; i++) {
            employees[i].setSalary(index * employees[i].getSalary());
        }
        return index;
    }
    public double indexDepartmentSalaries(String employeeDepartment, double index) {
        System.out.println("Проиндексировали зарплату всех сотрудников отдела "+employeeDepartment+" на "+index+" процентов");
        index = index/100+1;
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if(employees[i]==null)continue;
            if (employee.getDepartment().equals(employeeDepartment)) {
                employees[i].setSalary(index * employees[i].getSalary());
            }
        }
        return index;
    }
    public void getNamesOfEmployees() {
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if(employees[i]==null)continue;
            System.out.println(employee.getFullName());
        }
    }
    public void getNamesOfEmployeesFromDepartment(String employeeDepartment) {
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if(employees[i]==null)continue;
            if (employee.getDepartment().equals(employeeDepartment)) {
                System.out.println(employee.getFullName());
            }
        }
    }
    public void getSalariesIfSalaryLessThanNumber(int Number){
        System.out.println("Зарплата меньше "+Number+" рублей у сотрудников: ");
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if(employees[i]==null)continue;
            if(employee.getSalary()<Number){
                System.out.println("ID "+ employee.getId() + ": " + employee.getFullName() + " " + employee.getSalary());
            }
        }
    }
    public void getSalariesIfSalaryMoreThanNumber(int Number){
        System.out.println("Зарплата больше "+Number+" рублей у сотрудников: ");
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if(employees[i]==null)continue;
            if(employee.getSalary()>Number){
                System.out.println("ID "+ employee.getId() + ": " + employee.getFullName() +" "+ employee.getSalary());
            }
        }
    }
    public void getAllInfoAboutEmployees() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null)continue;
            Employee employee = employees[i];
            System.out.println("ID "+employee.getId()+": "+employee.getInfo());
        }
    }
    public void getAllInfoAboutEmployeesFromDepartment(String employeeDepartment){
        System.out.println("Все сотрудники отдела "+employeeDepartment+" и их данные");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            Employee employee = employees[i];
            if (employee.getDepartment().equals(employeeDepartment)) {
                System.out.println("ID "+employee.getId() + ": " + employee.getInfoWithoutDepartment());
            }
        }
    }
    public double replaceSalaryForEmployee(String employeeFullName, double newSalary){
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if(employees[i]==null)continue;
            if(employee.getFullName().equals(employeeFullName)){
                employees[i].setSalary(newSalary);
            }
        }
        return newSalary;
    }
    public String replaceDepartmentForEmployee(String employeeFullName, String newDepartmentForEmployee) {
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (employees[i] == null) continue;
            if(employee.getFullName().equals(employeeFullName)){
                employees[i].setDepartment(newDepartmentForEmployee);
            }
        }
        return newDepartmentForEmployee;
    }
}