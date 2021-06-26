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

class Result 
{
    /*
     * Complete the 'beautifulBinaryString' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING b as parameter.
     */

    public static int beautifulBinaryString(String b) 
    {
      // Write your code here
      String sub = "010"; //substring.
      int count=0; //this will count the number of deletions inorder to make a beautiful string.
      while(b.contains(sub))  //till the string the substring..
      {
          int index = b.indexOf(sub); //first index of the substring..
          char ch = '1';  //the character with which it will be replaced.
          b = b.substring(0,index+2) + ch + b.substring(index+3);  //this is for creating a new string..(replacing the new character..)
          count++;  //count the number of deletions..
      }
      return count;  //return the number of deletions..
    }
}
public class Solution 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String b = bufferedReader.readLine();

        int result = Result.beautifulBinaryString(b);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
