import java.util.*;
import java.util.Scanner;

public class F6 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the number: ");
        int number = s.nextInt();

        if (number % 2 == 0)
            System.out.println("Number is even number!!!");
        else
            System.out.println("Number is odd number!!!");

        s.close();
    }    
}
