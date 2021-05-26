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
     * Complete the 'fairRations' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY B as parameter.
     */

    public static String fairRations(List<Integer> B) 
    {
      // Write your code here
      int i,count=0;
      for(i=0;i<B.size()-1;i++)
      {
          if(B.get(i)%2==0)  //if the number at that index is even then skip..kindly.
          {
              continue;
          }
          else
          {
            int v = B.get(i);
            B.set(i,v+1);  //increase the value..
            int m = B.get(i+1);
            B.set(i+1,m+1);  //increase the next value as well..
            count = count+2;    
          }
      }
      //afte all this the array must have been updated..
      
      boolean flag = true;  //this will check if all the values present is even or not.
      for(i=0;i<B.size();i++)
      {
          if(B.get(i)%2!=0)
          {
              flag=false;
              break;
          }
      }
      String value = String.valueOf(count);  //converting the count value into string value..
      
      if(flag==true)
      {
          return value;
      }
      return "NO";
    }
}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> B = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        String result = Result.fairRations(B);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
