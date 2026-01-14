import java.util.*;

// The Task:

// Outside of main, create a method called sayHello.

// It should look like: public static void sayHello().

// Inside it, put System.out.println("Welcome to Java!");.

// Now, inside your main method, call sayHello(); three times.

// Goal: You should see the welcome message printed 3 times, but you only wrote the print statement once.

public class F16 {

    public static void sayHello(){
        System.out.println("Welcome to Java!");
    }
    public static void main(String[] args){
        for(int i = 0; i < 3;i++){
            sayHello();
        }
    }  
}
