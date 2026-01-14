public class F30 {
    public static void main(String[] args){
        Student_i s1 = new Student_i("abb", 1.9);
        System.out.println(s1.SCHOOL_NAME);

        //We don't need a student object to use static method!
        System.out.println(Student_i.convertToPercentage(2.4));

        //Why Static? Math.random() and System.out.println() are examples of static methods you have been using all along! You didn't need to create a new Math() object to do math.
        
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
    //static method that converts a GPA to a percentage
    //It takes a number as input, not a Student object.
    public static double convertToPercentage(double inputGpa) {
        return (inputGpa / 4.0) * 100;
    }

}