import java.util.Scanner;
// The Task:

// Ask the user: "How many numbers do you want to enter?"

// Save that number in a variable (e.g., size).

// Create an int[] array with that size.

// Create a loop that runs size times. Inside the loop, ask the user to enter a number and save it into the array at index i (e.g., myArray[i] = scanner.nextInt();).

// After they are done entering numbers, print the last number they entered.


public class F15 {
   public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("How many numbers do you want to enter?");
        int size = sc.nextInt();

        int[] array = new int[size];

        for(int i=0; i< array.length;i++){
            System.out.println("Enter the number to be added in array: ");
            int num_ent = sc.nextInt();

            array[i] = num_ent;
        }

        System.out.print("The number of the array is: "+ array[array.length - 1]);

        sc.close();
   } 
}
