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
     * Complete the 'superReducedString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String superReducedString(String s) 
    {
       // Write your code here
        /*Map<Character,Integer> M = new HashMap<>();
        
        int i;
        for(i=0;i<s.length();i++)
        {
            if(M.containsKey(s.charAt(i)))
            {
                M.put(s.charAt(i),M.get(s.charAt(i))+1);
            }
            else
            {
                M.put(s.charAt(i),1);
            }
        }
       // System.out.println(M);
        for(Map.Entry<Character,Integer> entry : M.entrySet())
        {
            int val = entry.getValue()%2;
            M.replace(entry.getKey(),val);
            
        }
        //System.out.println(M);
        String S = "";
        for(Map.Entry<Character,Integer> entry : M.entrySet())
        {
           if(entry.getValue()!=0)
           {
               S = S + entry.getKey();
           }
        }
        if(S.length()==0)
        {
            return "Empty String";
        }
        return S;*/
        //done with two methods...(But above method is not satisfying 4 or 5 test cases..)
        StringBuilder str = new StringBuilder(s);
        int i;
        for(i=1;i<str.length();i++)
        {
            if(str.charAt(i)==str.charAt(i-1))
            {
                str.delete(i-1,i+1);
                i=0;
            }
        }
        String str1 = str.toString();  //converted String Builder into String.
        if(str1.length()==0)
        {
            return "Empty String";
        }
        return str1;
        
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
