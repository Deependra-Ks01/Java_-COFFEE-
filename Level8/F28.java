class F28{
    public static void main(String[] args){
        Student_h s1 = new Student_h("lol", 1.8);
        System.out.println(Student_h.getStudentCount());
        Student_h s2 = new Student_h("loo", 1.9); 
        System.out.println(Student_h.getStudentCount());
        Student_h s3 = new Student_h("lop", 1.7);
        System.out.println(Student_h.getStudentCount());
    }
}

class Student_h{
    private String name;
    private double gpa;
    private static int studentCount = 0;

    Student_h(String name, double gpa){
        this.name = name;
        this.gpa = gpa;
        studentCount++;
    }

    public static int getStudentCount(){
        return studentCount;
    }
}
