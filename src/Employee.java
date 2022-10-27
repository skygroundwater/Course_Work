public class Employee {
    private String fullName;
    private String department;
    private double salary;
    private static int counter = 0;
    private final int id;
    public Employee(String fullName, String department, int salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        id = ++counter;
    }
    public int getId(){
        return id;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public double getSalary() {
        return salary;
    }
    public String getDepartment() {
        return department;
    }
    public String getFullName() {
        return fullName;
    }
    public String getInfo() {
        return fullName + ", " + department + ", " + salary;
    }
    public String getInfoWithoutDepartment(){
        return fullName + ", " + salary;
    }
    public  boolean equals(Object other){
        if(other == null || this.getClass() != other.getClass()){
            return false;
        }
        if (this == other){
            return true;
        }
        Employee employee = (Employee) other;
        return fullName.equals(employee.fullName) && department.equals(employee.department) && salary == employee.salary&& id == employee.id;
    }
    public String toString(){
        return fullName + ", " + department + ", " + salary + " id сотрудника" + id;
    }
    public int hashCode(){
        return java.util.Objects.hash(fullName,department,salary,id);
    }
}



