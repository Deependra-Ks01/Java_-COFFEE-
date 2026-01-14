import java.util.*;
import java.util.Scanner;

public class F8 {
    public static void main(String[] args){
        int sum = 0;
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the number: ");
        int num = s.nextInt();

        for(int i=0; i <= num; i++){
            sum += i;
        }

        System.out.println("The sum is: " + sum);

        s.close();
    }    
}
