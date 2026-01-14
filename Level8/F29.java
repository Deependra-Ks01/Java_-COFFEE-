public class F29 {
    public static void main(String[] args){
        Student_i s1 = new Student_i("abb", 1.9);
        System.out.println(s1.SCHOOL_NAME);
        // s1.SCHOOL_NAME = "Python University";
        // cannot assign a value to static final variable SCHOOL_NAME
    }
}

class Student_i{
    private String name;
    private double gpa;
    private static int studentCounter = 0;
    public static final String SCHOOL_NAME = "Java University";

    Student_i(String name, double gpa){
        this.name = name;
        this.gpa = gpa;
        studentCounter++;
    }

    public static int studentCount(){
        return studentCounter;
    }

}