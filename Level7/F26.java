class F26{
    public static void main(String[] args){
        Student_g student1 = new Student_g();
        student1.setName("All");
        student1.setgpa(3.8);

        Student_g student2 = new Student_g();
        student2.setName("Bll");
        student2.setgpa(3.9);

        System.out.println("The name of student 1 is: " + student1.getName());
        System.out.println("The name of student 2 is: " + student2.getName());
    }
}

class Student_g{
    private String name;
    private double gpa;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setgpa(double gpa){
        this.gpa = gpa;
    }

    public double getgpa(){
        return this.gpa;
    }
}