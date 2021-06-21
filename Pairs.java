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
     * Complete the 'pairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY arr
     */

    public static int pairs(int k, List<Integer> arr) 
    {
      // Write your code here
      
      //below two methods are there...But here is the best method..
      Set<Integer> set = new HashSet<>();  //creating a set.
      int i;
      for(i=0;i<arr.size();i++)
      {
          set.add(arr.get(i));
      }
      
      int count=0;
      //now will traverse the arr..and will calculate the count.
      for(int number : arr)
      {
          if(set.contains(number+k))
          {
              count++;
          }
      }
      return count;

      /*
      //two pointer approach
      //sort the list first.
      Collections.sort(arr);  
      
      //now traverse the sorted list..taking the help of two pointer method..
      int n = arr.size();
      int i=0,j=1,count=0;
      while(j<n)
      {
          int dif = arr.get(j)-arr.get(i);  //difference..
          if(dif==k)  //if difference matches with the target.
          {
              count++;  //increase the count..
              j++;   
          }
          else if(dif>k)
          {
              i++;
          }
          else if(dif<k)
          {
              j++;
          }
      }
      return count;  //return the count..*/
          
      //BRUTE FORCE APPROACH..
      /*int i,j;
      int dif = 0;
      int count=0;
      for(i=0;i<arr.size()-1;i++)
      {
          for(j=i+1;j<arr.size();j++)
          {
              dif = Math.abs(arr.get(i)-arr.get(j));
              if(dif==k)
              {
                  count++;
              }
          }
      }
      return count;*/
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
