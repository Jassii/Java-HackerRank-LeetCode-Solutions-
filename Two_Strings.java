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
     * Complete the 'twoStrings' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static String twoStrings(String s1, String s2) 
    {
      // Write your code here
      
      //brute force approach done by me at the begenning.. 
      
      /*int i,j;
      int count=0;
      for(i=0;i<s1.length();i++)
      {
          for(j=0;j<s2.length();j++)
          {
              if(s1.charAt(i)==s2.charAt(j))
              {
                  return "YES";
              }
          }
      }
      return "NO";*/
      /*int i;
      int count=0;
      int min = s1.length();
      if(min>s2.length())
      {
          min = s2.length();
      }
      for(i=0;i<s2.length();i++)
      {
          char ch = s2.charAt(i);
          String S= Character.toString(ch);
          if(s1.contains(S))
          {
              return "YES";
          }
      }
      
      return "NO";*/
      
      //we have to use set...and its operation that is intersection operation..
      
     Set<Character> a = new HashSet<>();
     Set<Character> b = new HashSet<>();
     int i;
     for(i=0;i<s1.length();i++)  //stored the characters of the string in set..
     {
         a.add(s1.charAt(i));
     }
     for(i=0;i<s2.length();i++)
     {
         b.add(s2.charAt(i));
     }
     //now doing the intersection....
     Set<Character> answer = new HashSet<Character>(a);
     answer.retainAll(b);  //used at the time of applying operation..
     
     if(answer.isEmpty())
     {
         return "NO";
     }
      return "YES";
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s1 = bufferedReader.readLine();

                String s2 = bufferedReader.readLine();

                String result = Result.twoStrings(s1, s2);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
