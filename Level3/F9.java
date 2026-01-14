import java.util.*;
import java.util.Scanner;

public class F9 {
    public static void main(String[] args){
        String secretPassword = "Java101";

        Scanner s = new Scanner(System.in);

        System.out.println("Enter the Password: ");
        String enteredPassword = s.nextLine();

        while(!enteredPassword.equals(secretPassword)){
            System.out.println("Wrong Password, Enter again: ");
            enteredPassword = s.nextLine();   
        }

        System.out.println("Access Granted!!!");

        s.close();
    }    
}