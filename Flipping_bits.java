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
     * Complete the 'flippingBits' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER n as parameter.
     */

    public static long flippingBits(long n) 
    {
      // Write your code here 
      
      //first converting the long into binary string of 32 bits..
      String s = String.format("%32s",Long.toBinaryString(n)).replaceAll(" ","0"); 
      
      //now flipping the bits..     
      char ch[] = s.toCharArray();
      int i;
      for(i=0;i<ch.length;i++)
      {
          if(ch[i]=='1')
          {
              ch[i]='0';
          }
          else
          {
              ch[i]='1';
          }
      }
      //as bits are flipped..
      
      s = new String(ch);  //updated binary string 
      return Long.parseLong(s,2);  //returning the long value of that 32 bit binary string..
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                long n = Long.parseLong(bufferedReader.readLine().trim());

                long result = Result.flippingBits(n);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
