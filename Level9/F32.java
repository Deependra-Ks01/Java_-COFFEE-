// Problem 34: The Interview Logic Puzzle (String Manipulation)

// Let's take a break from structure and do a "hard" logic problem commonly asked in interviews. This tests your loops and logic skills without any fancy classes.

// Question: Check if a word is a Palindrome. (A palindrome is a word that reads the same forwards and backwards, like "MOM", "RADAR", or "LEVEL").

// The Task:

// Create a static method: public static boolean isPalindrome(String text).

// The Logic:

// You need two pointers (variables). One starts at the beginning (index 0), one starts at the end (index text.length() - 1).

// Use a while loop. Run it as long as the start pointer is less than the end pointer.

// Inside the loop, check: if (text.charAt(start) != text.charAt(end)).

// If they don't match, return false immediately.

// If they do match, move the pointers: start++ and end--.

// If the loop finishes without returning false, return true.

// Test: In main, print the result of isPalindrome("racecar") and isPalindrome("java").
import java.util.Scanner;

public class F32 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string to check for palindrome: ");
        String word = sc.nextLine();

        if (isPalindrome(word) == true){
            System.out.println("Entered word is palindrome!!!");
        }else{
            System.out.println("Entered word is not palindrome!!!");
        }

    }

    public static boolean isPalindrome(String text){
        int start = 0;
        int end = text.length()-1;

        while(start < end){
            if ((text.charAt(start) != text.charAt(end))){
                return false;
            }else{
                start++;
                end--;
            }
        }
        return true;
    }
}
