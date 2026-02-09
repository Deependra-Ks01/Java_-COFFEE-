// The Task:

// Create a class Employee.

// Give it private fields: name (String) and baseSalary (double).

// Create a Constructor to initialize them.

// Create a method void displayInfo() that prints: "Employee: [Name], Salary: $[Salary]".

// Now, the Magic: Create a new class (separate file or below Employee) called Manager.

// Make it inherit from Employee: class Manager extends Employee { }.

// The Test: In main, create a Manager object. You will realize you can't yet because of the constructor. (See Problem 32).





// Problem 32: The Super Constructor

// If the Parent (Employee) demands a name to be born, the Child (Manager) must pass that information up the chain.

// The Concept: super(...) calls the parent's constructor. It must be the very first line of the child's constructor.

// The Task:

// Inside the Manager class, add a private field double bonus.

// Create a constructor for Manager that takes 3 inputs: name, salary, and bonus.

// Inside the constructor:

// First line: super(name, salary); (Passes data to Employee).

// Second line: this.bonus = bonus; (Handles the Manager-specific data).

// Test in Main:

// Manager boss = new Manager("Sarah", 80000, 5000);

// boss.displayInfo(); (Notice: Manager can use displayInfo even though you didn't write it inside Manager! That is inheritance.)





// Problem 33: The Overrule (Method Overriding)

// The displayInfo method we inherited prints the salary, but it ignores the bonus! The Manager class needs to replace (override) the parent's method with a better version.

// The Task:

// Inside Manager, write the displayInfo() method again exactly as it appears in Employee.

// Add the annotation @Override above it (optional but good practice).

// Inside this new method, print the name, the base salary, AND the bonus.

// Note: You might find you cannot access name or baseSalary because they are private in the parent.

// The Fix: Go back to Employee and change private to protected. (Protected means: "Private to the world, but visible to my children").

// Test: Run boss.displayInfo() again. It should now use the Manager's specific version.

class Employee{
    protected String name;
    protected double baseSalary;

    Employee(String name, double baseSalary){
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public void displayInfo(){
        System.out.println("Employee: "+ this.name +" Salary: "+ this.baseSalary);
    }
}

class Manager extends Employee{
    private double bonus;

    Manager(String name, double baseSalary, double bonus){
        super(name, baseSalary);
        this.bonus = bonus;
    }

    @Override 
    public void displayInfo(){
        System.out.println("Employee: "+ name +" Salary: "+ baseSalary + " Bonus: "+ this.bonus);
    }

}

public class F31{
    public static void main(String[] args){

        Manager boss = new Manager("Sarah", 80000, 5000);
        boss.displayInfo();
    }
    
}