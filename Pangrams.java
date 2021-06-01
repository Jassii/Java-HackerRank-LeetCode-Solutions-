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
     * Complete the 'pangrams' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String pangrams(String s) 
    {
       boolean mark[] = new boolean[26]; //this will store for every alphabet..
       char ch[] = s.toCharArray(); //converting the string into character array..
       int i;
       for(i=0;i<ch.length;i++)
       {
           int index=0;
           if(ch[i]>='A' && ch[i]<='Z')  //if particular character is in range..
           {
              index = ch[i]-'A';  //find its index value..
           }
           else if(ch[i]>='a' && ch[i]<='z') //if particular character is in range..
           {
              index = ch[i]-'a';  //find its index value..
           }
           mark[index] = true;  //at that index put true..(yes it is present.)
       }
       
       for(i=0;i<26;i++)  //traversing the mark array..
       {
           if(mark[i]==false)  //if any of the index is (false) then it is not pangram.
           {
               return "not pangram";
           }
       }
       return "pangram";
    }
}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
