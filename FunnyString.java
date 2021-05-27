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
     * Complete the 'funnyString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String funnyString(String s) 
    {
        // Write your code here
        List<Integer> l1 = new ArrayList<>();  //it will store the difference..
        List<Integer> l2 = new ArrayList<>();
         
        StringBuilder S = new StringBuilder(s);
        S.reverse();  //reverse the string..
        S.toString(); //S is storing the reverse of the string..
        
        int i;
        for(i=0;i<s.length();i++)
        {
            l1.add(Integer.valueOf(s.charAt(i)));  //l1 list will store(ascii value)
        } 
        
        //checking of the reverse string..
        for(i=0;i<S.length();i++)
        {
            l2.add(Integer.valueOf(S.charAt(i))); //l2 list will store(ascii value)(reverse)
        }
       
       boolean flag = true;
       for(i=0;i<l1.size()-1;i++)
        {
            if(Math.abs(l1.get(i+1)-l1.get(i)) == Math.abs(l2.get(i+1)-l2.get(i)))
            {
                continue;
            }
            else
            {
                flag=false;
                return "Not Funny";
            }
        }
        if(flag==true)
        {
            return "Funny";
        }
        return "Not Funny";
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

                String result = Result.funnyString(s);

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
