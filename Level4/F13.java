
import java.util.*;
import java.util.Scanner;

public class F13 {
    public static void main(String[] args){
        int[] arr = {22, 33, 44, 55, 66, 77, 88};

        Scanner s = new Scanner(System.in);

        System.out.print("Enter the number to search in the array: ");
        int Number = s.nextInt();

        Boolean flag = false;

        for(int i=0; i<arr.length; i++){
            if( arr[i] == Number){
                flag = true;
                break; 
            }
        }

        if(flag == false)
            System.out.println("Grrrr! Number not found...!");
        else
            System.out.println("Number Found!!!");

        s.close();
    }
    
}
