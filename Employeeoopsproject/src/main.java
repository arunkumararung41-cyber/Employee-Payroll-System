package Employeeoopsproject.src;
import java.util.ArrayList;

abstract class Employee{   //abstraction class
    private String name;
    private int id;
    public Employee(String name,int id){ //parametrized constructor 
        this.name=name;
        this.id=id;
    }
    public String GetName(){   // getter method     // we are not giving direct access of data
        return name;
    }
    public int GetId(){   // getter method
        return id;
    }
    abstract double CalculateSalary();   //abstract method 
    @Override
    public String toString(){
        return " Employee:-name: "+name+" | Id: "+id+" | salary: "+ CalculateSalary()+"";
    }


}
class FullTimeEmployee extends Employee{  // showing error if we did not implement abstract class method
    private double monthlysalary;
    public FullTimeEmployee (String name, int id , double monthlysalary){ //constructor
        super(name, id);  // super methord help to run the supperclass oonstructor
        this.monthlysalary=monthlysalary;

    }
    @Override
    public double CalculateSalary(){

        return monthlysalary;
    }

    
} 
class PartTimeEmployee extends Employee{
    private int hourswork;
    private double hourlyrate;
    public PartTimeEmployee(String name, int id, int hourswork,double hourlyrate){
        super(name, id); // call superclass constructor
        this.hourswork=hourswork;
        this.hourlyrate=hourlyrate;
    }
    @Override
    public double CalculateSalary(){
        return hourswork*hourlyrate;
    }

}
class PayRollSystem{
    private ArrayList<Employee> employeeList;   // initialization of arraylist   Employee data type
    public PayRollSystem(){
        employeeList = new ArrayList<>();  

    }
    public void AddEmployee(Employee employee){      // employee is the object of Employee
        employeeList.add(employee);
    }
    public void RemoveEmployee(int id){
        Employee employetoremove = null ;
        for (Employee employee : employeeList){  //  employee == i   (for each loop)
            
            if (employee.GetId()==id){
                employetoremove = employee;
                break;
            }
            
        }
        if(employetoremove!=null){
            employeeList.remove(employetoremove);
        }
    }

        
        public void DisplayEmployees(){
        for(Employee employee : employeeList){
            System.out.println(employee);

        }
        }
    }


    

public class Main {
    public static void main(String[] args) {
        PayRollSystem payrollsystem= new PayRollSystem();  // object payrollsystem is created
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee("arun",1 , 90000);
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee("sanjay", 2, 50, 2000);
        payrollsystem.AddEmployee(fullTimeEmployee);
        payrollsystem.AddEmployee(partTimeEmployee);
        System.out.println("initial employee details: ");
        payrollsystem.DisplayEmployees();
        System.out.println(" Remove employee id 2");
        payrollsystem.RemoveEmployee(2);
        System.out.println("Remaining employee details are");
        payrollsystem.DisplayEmployees();
    }
    
}
