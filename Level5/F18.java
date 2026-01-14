import java.util.Scanner;

// This is the most important concept. Sometimes you don't want the method to print; you want it to give you a number so you can use it later.

// The Concept:

// Bad: Method calculates 2+2 and prints 4. (You can't use the 4 for anything else).

// Good: Method calculates 2+2, returns 4. (Now you can save it, multiply it, or print it).

// The Task:

// Create a method called calculateSquare.

// It should return an int: public static int calculateSquare(int number).

// Inside, calculate the square (number∗number) and return it. Do not print inside this method.

// Inside main, call the method: int result = calculateSquare(5);

// Print the result.

public class F18 {

    public static int calculateSquare(int number){
        int square = (number*number);
        return square;
    }    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number for which square have to calculated: ");
        int number_e = sc.nextInt();

        int result = calculateSquare(number_e);

        System.out.println("Result: " + result);   

        sc.close();
    }
}
