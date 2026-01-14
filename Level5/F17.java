import java.util.Scanner;

// The Task:

// Create a method called greetUser.

// It needs to accept a String input: public static void greetUser(String name).

// Inside the method, print: "Hello, " + name + "!"

// Inside main, ask the user for their name using a Scanner.

// Pass that variable into your method: greetUser(userName);

// Call it again with a hardcoded name: greetUser("Gemini");

public class F17{

    public static void greetUser(String name){
        System.out.println("Hello " + name + "!");
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the name: ");
        String name_e = sc.nextLine();

        greetUser(name_e);

        sc.close();
    }
}
