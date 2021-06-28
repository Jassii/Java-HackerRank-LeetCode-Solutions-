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
     * Complete the 'gameOfThrones' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String gameOfThrones(String s) 
    {
        // Write your code here
        
        //first calculate the count of each alphabets present in the string..
        Map<Character,Integer> M = new HashMap<>();
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
    
        boolean val=true;
        
        if(s.length()%2==0)  //if length of the string is even..
        {
            for(Map.Entry<Character,Integer> entry:M.entrySet())  
            {
                //then every alphabet count should also be even..if it's not.then "NO".
                if(entry.getValue()%2!=0)
                {
                    val=false;
                }
            }
        }
        else  //if the length is odd...
        {
            int count=0;
            for(Map.Entry<Character,Integer> entry:M.entrySet())
            {
                //then only one character count should be odd..for palindrome..
                if(entry.getValue()%2!=0)  //if the value is odd..
                {
                    count++;
                }
            }
            if(count!=1) //if count is more than 1..then no Palindrome possible.
            {
                val=false;
            }
        }
        if(val==true)  //if val is still true..then it can form Palindrome.
        {
            return "YES";
        }
        return "NO";  //otherwise No palindrome..
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
