// import java.util.*;

class F22{
    public static void main(String[] args){
        Student_d student1 = new Student_d("Red", 2.2);

        Student_d student2 = new Student_d("Blue", 9.9);

        System.out.println("The name of student 1 is: " + student1.name);
        System.out.println("The name of student 2 is: " + student2.name);

        student1.printProfile();
        student2.printProfile();
    }
}


class Student_d{
    String name;
    double gpa;
    // The Constructor
    Student_d(String inputName, double inputGpa) {
        name = inputName;
        gpa = inputGpa;
    }

    void printProfile(){
        System.out.println(name + " has a GPA of " + gpa);
    }

}