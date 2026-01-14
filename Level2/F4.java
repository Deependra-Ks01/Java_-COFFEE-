import java.util.*;
import java.util.Scanner;

public class F4 {
    public static void main(String[] args) {
        // Taking inputs for name as text from the user
        Scanner s = new Scanner(System.in);
        System.out.println("What is your name?");
        
        // Taking inputs for age as int from the user
        String text = s.nextLine();
        System.out.println("How old are you?");
        
        // Printing the final string with name and age 
        int num = s.nextInt();
        System.out.println("Hello " + text + ", your age is "+ num +".");

        s.close();
    }
    
}
