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
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) 
    {
       // Write your code here
       int i;
       //converting the string into character array..
       char ch[] = s.toCharArray();
       k = k%26;   //if k is a big value...then we can directly decrease it..(very main).
       for(i=0;i<ch.length;i++)
       {
           if(ch[i]>='a' && ch[i]<='z')
           {
               int val = (int)ch[i]+k;
               if(val>122)
               {
                   val = val-123;
                   val = val+97;
               }
               ch[i] = (char)val;
           }
           else if(ch[i]>='A' && ch[i]<='Z')
           {
               int val = (int)ch[i]+k;
               if(val>90)
               {
                   val = val-91;
                   val = val+65;
               }
               ch[i] = (char)val;
           }
       }
        String S = new String(ch);
        return S;
    }
}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
