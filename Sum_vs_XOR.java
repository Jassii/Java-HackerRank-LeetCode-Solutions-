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
     * Complete the 'sumXor' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER n as parameter.
     */

    public static long sumXor(long n) 
    {
      // Write your code here
      
      //remember one formula..
      // a+b = aXORb + a&b..(a&b has to be equal to 0.)
      if(n==0)
      {
          return 1;
      }
      
      //convert long n into binary number..
      String s = Long.toBinaryString(n);
      int i;
      int count=0;
      //calculating the number of 0's..
      for(i=0;i<s.length();i++)
      {
          if(s.charAt(i)=='0')
          {
              count++;  //ways of conveting it into 0..
          }
      }
      
      return (long)Math.pow(2,count);
      
      //brute force approach(Time limit exceeded)...
      /*int count=0;
      for(i=0;i<=n;i++)
      {
          long sum = i+n;
          long xor = (i|n)&(~i|~n);
          if(sum==xor)
          {
              count++;
          }
      }
      return count;*/
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.sumXor(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
