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
     * Complete the 'theLoveLetterMystery' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int theLoveLetterMystery(String s) 
    {
      // Write your code here
       StringBuffer S = new StringBuffer(s);
        StringBuffer S1 = new StringBuffer(s);
        S1.reverse();
        String a = S.toString();
        String b = S1.toString();
       // System.out.println(a+" "+b);
        int count=0;
        while(a.equals(b)==false)
        {
            StringBuffer A = new StringBuffer(a);
            StringBuffer B = new StringBuffer(b);
           // count++;
           int i;
           for(i=0;i<A.length();i++)
           {
              if(A.charAt(i)>B.charAt(i))
              {
                  count++;
                 int v = (int)A.charAt(i)-1;
                 A.replace(i,i+1,Character.toString((char)v));
              }
           }
          a = A.toString();
         // StringBuffer G = new StringBuffer(a);
          A.reverse();
          b = A.toString();
        }
        //System.out.println("Value of a "+a+" Value of b "+b+" with a count of "+count);
        return count;
    }
}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.theLoveLetterMystery(s);

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
