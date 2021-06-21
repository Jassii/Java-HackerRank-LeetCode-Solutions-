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
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) 
    {
      // Write your code here
      //create a map for original list that is for brr..
      Map<Integer,Integer> M = new HashMap<>();
      int i;
      
      //it will store the count of each number in brr list..
      for(i=0;i<brr.size();i++)
      {
          if(M.containsKey(brr.get(i)))
          {
              M.put(brr.get(i),M.get(brr.get(i))+1);
          }
          else
          {
              M.put(brr.get(i),1);
          }
      }
      
      //traverse the list arr..and for each value in arr..subtract its value in map by 1.
      for(i=0;i<arr.size();i++)
      {
          int val = arr.get(i);  
          M.put(val,M.get(val)-1);  //decrease its count..
      }
      //final list..
      List<Integer> result = new ArrayList<>();  //this will store the missing numbers.
      
      //those whose count is not 0..that will be the missing numberss...
      for(Map.Entry<Integer,Integer> entry:M.entrySet())
      {
          if(entry.getValue()!=0)
          {
              result.add(entry.getKey());
          }
      }
      return result;  //return the final result list..
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

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.missingNumbers(arr, brr);

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
