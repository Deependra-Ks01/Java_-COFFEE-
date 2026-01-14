// import java.util.*;

class F23{
    public static void main(String[] args){
        Student_e student1 = new Student_e("Red", 2.2);

        Student_e student2 = new Student_e("Blue", 9.9);

        System.out.println("The name of student 1 is: " + student1.name);
        System.out.println("The name of student 2 is: " + student2.name);

        student1.printProfile();
        student2.printProfile();
    }
}

class Student_e{
    String name;
    double gpa;
    // The Constructor
    Student_e(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    void printProfile(){
        System.out.println(name + " has a GPA of " + gpa);
    }

}