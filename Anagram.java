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
     * Complete the 'anagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter....
     */

    public static int anagram(String s) 
    {
       // Write your code here
       int len = s.length();
       if(len%2!=0)  //if the string given is of odd length..
       {
         return -1;  
       }
       int mid = len/2;
       
       String S1 = s.substring(0,mid);
       
       String S2 = s.substring(mid);
       
       //System.out.println(S1+" "+S2);
       //now reverse String S2....
       
       StringBuffer S = new StringBuffer(S2);
       S.reverse();  //reversed the string..
       
       S2 = S.toString();  //now S2 will contain the reverse...(cde->edc)..
       
      // System.out.println(S1+" "+S2);

       int count=0;
      int i;
      //boolean flag=false;
      /*if(S1.equals(S2))//that is the begenning..
          {
              //System.out.println(S1+" "+S2);
              return count;
          }
     for(i=0;i<S1.length();i++)
      {
          if(S1.equals(S2))
          {
              return count;
          }
          if(S1.charAt(i)<S2.charAt(i))
          {
              char ch1 = S1.charAt(i);
              char ch2 = S2.charAt(i);
              char ch[] = S1.toCharArray();//converted into array.
              ch[i] = ch2;
              S1 = new String(ch);
              //S1.replace(Character.toString(ch1),Character.toString(ch2));
              count++;
              //System.out.println(count);
          }
          else if(S1.charAt(i)>S2.charAt(i))
          {
              char ch1 = S1.charAt(i);
              char ch2 = S2.charAt(i);
              char ch[] = S1.toCharArray();//converted into array.
              ch[i] = ch2;
              S1 = new String(ch);
              //S1 = S1.replace(Character.toString(ch1),Character.toString(ch2));
          }
      }
      //System.out.println(S1+" "+S2);
      return count;*/
     for(i=0;i<S1.length();i++)
      {
          int index = S2.indexOf(S1.charAt(i));
          if(index==-1)
          {
              count++;
          }
          else  //jaha mil raha usko remove krdo..taaki same k liye fr se repeat na ho..
          {
              S2 = S2.substring(0,index)+S2.substring(index+1);
          }
      }
      return count;
    }
      /*for(i=0;i<S1.length();i++)
      {
          if(!S2.contains(S1.charAt(i)+""))
          {
              count++;
          }
      }
      return count;
    }*/

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.anagram(s);

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
