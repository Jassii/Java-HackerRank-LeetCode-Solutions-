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
     * Complete the 'minimumNumber' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING password
     */

    public static int minimumNumber(int n, String password) 
    {
       int i;
       int lc = 0;
       int uc = 0;
       int d = 0;
       int sc = 0;
       for(i=0;i<password.length();i++)
       {
           int ascii = (char)password.charAt(i);
           if(ascii>=48 && ascii<=57)
           {
               d++;
           }
           else if(ascii>=65 && ascii<=90)
           {
               uc++;
           }
           else if(ascii>=97 && ascii<=123)
           {
               lc++;
           }
           else
           {
               sc++;
           }
       }
       //now checking if any character is missing or not..
       int count=0;
       if(d==0)
       {
           count++;
       }
       if(lc==0)
       {
           count++;
       }
       if(uc==0)
       {
           count++;
       }
       if(sc==0)
       {
           count++;
       }
       //System.out.println("Missing values are "+count);
       if(password.length()+count>=6)
       {
           return count;
       }
       
       return (count+(6-(password.length()+count)));
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = Result.minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
