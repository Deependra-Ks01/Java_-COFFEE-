import java.util.*;
import java.util.Scanner;

public class F5 {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int number = s.nextInt();
        
        if (number > 0)
            System.out.println("Number is positive!!!");
        else if (number < 0)
            System.out.println("Number is negative!!!");
        else
            System.out.println("Number is 0");

        s.close();
    }  
}
