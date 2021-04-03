import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution
 {
     private static final Scanner scanner = new Scanner(System.in);
     
    //Complete the hourglassSum function below..
    static int hourglassSum(int arr[][])
    {
        //calculating the length of the row.
        int rows = arr.length;
        //calculating the columns of the row..
        int columns = arr[0].length;
        
        int max_hourglass_sum = Integer.MIN_VALUE;//storing the mimimum value..
        
        for(int i=0;i<rows-2;i++)//here we are subtracting 2 bcoz of array exception.
        {
            for(int j=0;j<columns-2;j++)//same with this loop ...
            {
                //calculating the sum of the current hourglass sum...
                    int current_hourglass_sum = arr[i][j] + arr[i][j+1] + arr[i][j+2]+arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                //checking whether the current sum is greater than max sum or not..
                max_hourglass_sum = Math.max(max_hourglass_sum,current_hourglass_sum);   
            }
                 
        }
         return max_hourglass_sum; //returning the maximum hourglass value..
    }
    
    

    public static void main(String[] args) 
    {
        int[][] arr = new int[6][6];
        for (int i = 0; i < 6; i++) 
        {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        
        int result = hourglassSum(arr);  //calling the function..
        System.out.println(result); 
        scanner.close();
    }
}
