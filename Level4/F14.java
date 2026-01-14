// Problem 14: The Filter (Sum of Even Numbers)

// This requires combining an if statement inside a for loop. You will look at every number, but only do math on some of them.

// The Task:

// Create an array: {1, 5, 2, 8, 11, 14, 9}.

// Create a variable sumOfEvens set to 0.

// Loop through the array.

// Inside the loop, check if the current number is even (remember the % operator?).

// Only if it is even, add it to sumOfEvens.

// Print the result. (For this array, it should be 2+8+14=24).
public class F14 {
    public static void main(String[] args){
        int[] array = {1, 5, 2, 8, 11, 14, 9};

        int sumOfEvens = 0;
    
        for(int i=0; i< array.length; i++){
            if(array[i] % 2 == 0){
                sumOfEvens += array[i];
            }
        }
    
        System.out.println("For given array the sum of even numbers is: "+ sumOfEvens); 
    }
}
