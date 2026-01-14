import java.util.*;

public class F12 {
    public static void main(String[] args){
        int[] arr = {12, 45, 2, 99, 56, 3};

        int max = arr[0];

        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max)
                max = arr[i];
        }

        System.out.println("The max number in the array is: " + max);
    }
    
}
