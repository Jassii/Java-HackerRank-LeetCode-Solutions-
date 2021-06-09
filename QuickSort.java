import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'quickSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
     
     //quiclk sort..
    public static List<Integer> quickSort(List<Integer> arr,int low,int high) 
    {
       // Write your code here
       if(low<high)
       {
           int pi = partition(arr,low,high);
           quickSort(arr,low,pi-1);
           quickSort(arr,pi+1,high);
       }
       return arr;
    }
    //partition function..
    public static int partition(List<Integer> arr, int low, int high)
    {
        int pivot = arr.get(high);
        int i = low-1;
        for(int j=low;j<=high-1;j++)
        {
            if(arr.get(j)<pivot)
            {
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,high);
        return (i+1);
    }
    //swap the array..
    public static void swap(List<Integer> arr,int i,int j)
    {
        int temp = arr.get(i);
        int temp2 = arr.get(j);
        arr.set(i,temp2);
        arr.set(j,temp);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.quickSort(arr,0,arr.size()-1);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
