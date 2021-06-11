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
     * Complete the 'countingSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> countingSort(List<Integer> arr) 
    {
       // Write your code here
       List<Integer> count = new ArrayList<>();
       List<Integer> output = new ArrayList<>();  //output list.. 
       int i;
       
       for(i=0;i<arr.size();i++)
       {
           output.add(0);
       }
       
       for(i=0;i<arr.size();i++)
       {
           count.add(0);
       }
       
       for(i=0;i<arr.size();i++)
       {
           int index = arr.get(i);
           int val2 = count.get(index);
           count.set(index,val2+1);
       }
      // System.out.println(count);
       //now update the count of the arrays by the sum of the previous count..
       
       for(i=1;i<arr.size();i++)
       {
           int sum = count.get(i)+count.get(i-1);
           count.set(i,sum);
       }
       
       for(i=0;i<arr.size();i++)
       {
           int index = arr.get(i);
           int val = count.get(index);
           output.set(val-1,index);
           count.set(index,val-1);
       }
       //System.out.println(count);
       for(i=0;i<arr.size();i++)
       {
           arr.set(i,output.get(i));
       }
       return arr;
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

        List<Integer> result = Result.countingSort(arr);

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
