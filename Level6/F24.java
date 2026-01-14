

class F24{
    public static void main(String[] args){
        Student_f student1 = new Student_f("Data");
        Student_f student2 = new Student_f("Science", 2.44);

        student1.printProfile();
        student2.printProfile();

    }
}

class Student_f{
    String name;
    double gpa;
    
    // Constructor 1
    Student_f(String name, double gpa){
        this.name = name;
        this.gpa = gpa;
    }

    //Constructor 3
    Student_f(String name){
        this.name = name;
        this.gpa = 5.0;
    }

    void printProfile(){
        System.out.println(name + " has a GPA of " + gpa);
    }

}