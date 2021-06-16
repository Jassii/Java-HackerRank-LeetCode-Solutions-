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
     * Complete the 'maximumPerimeterTriangle' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY sticks as parameter.
     */

    public static List<Integer> maximumPerimeterTriangle(List<Integer> sticks) 
    {
      // Write your code here
      List<Integer> output = new ArrayList<>();  //output list..
      int i;
      
      //As it is asking for the maximum perimeter triangle..just simply sort it in descending order..then select three values which satisfies the property of the triangle...and in the end it will return three sides..having the maximum perimeter..
      
      
      //your first move should be to sort in descending order the list..for maximum perimeter..
      Collections.sort(sticks);  //sort in ascending order..
      Collections.reverse(sticks); //this will change into descending order..
      boolean present = false;
      for(i=0;i<sticks.size()-2;i++)
      {
          if((sticks.get(i+2)+sticks.get(i+1))>sticks.get(i))  //if it is satisfying the property of triangle..
          {
              present = true;
              output.add(sticks.get(i+2));
              output.add(sticks.get(i+1));
              output.add(sticks.get(i));
              break;
          }
      }
      if(present==false)//if no sides are satisfying the property of the triangle..
      {
          output.add(-1);   //return -1..
      }
      return output;
    } 
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> sticks = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.maximumPerimeterTriangle(sticks);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
