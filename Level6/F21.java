// import java.util.*;

class F21{
    public static void main(String[] args){
        Student_c student1 = new Student_c();
        student1.name = "Alice";
        student1.gpa = 3.8;

        Student_c student2 = new Student_c();
        student2.name = "Kalu";
        student2.gpa = 1.0;

        System.out.println("The name of student 1 is: " + student1.name);
        System.out.println("The name of student 2 is: " + student2.name);

        student1.printProfile();
        student2.printProfile();
    }
}


class Student_c{
    String name;
    double gpa;

    void printProfile(){
        System.out.println(name + " has a GPA of " + gpa);
    }

}