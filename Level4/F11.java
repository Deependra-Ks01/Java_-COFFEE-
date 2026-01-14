import java.util.*;

public class F11 {
    public static void main(String[] args){
        double[] arr = {95.5, 40.0, 70.2, 85.0, 100.0};

        double sum = 0;

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }

        double average = sum / arr.length;
        System.out.println("The average is: " + average);
    }
    
}
