import java.util.*;

class Student_b{
    String name;
    double gpa;

}

class F20{
    public static void main(String[] args){
        Student_b student1 = new Student_b();
        student1.name = "Alice";
        student1.gpa = 3.8;

        Student_b student2 = new Student_b();
        student2.name = "Kalu";
        student2.gpa = 1.0;

        System.out.println("The name of student 1 is: " + student1.name);
        System.out.println("The name of student 2 is: " + student2.name);
    }
}