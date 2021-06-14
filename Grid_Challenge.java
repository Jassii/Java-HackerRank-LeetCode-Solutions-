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
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static String gridChallenge(List<String> grid) 
    {
      // Write your code here
      //traverse the list of strings and sort the string at each index..
      int i;
      for(i=0;i<grid.size();i++)
      {
          String s = grid.get(i);  //string..
          char ch[] = s.toCharArray();  //converted into character array.
          Arrays.sort(ch); //array sorted,ascending order..
          s = new String(ch); //converted back to the list..
          grid.set(i,s);
      }
      //now we just have to check whether the columns string are already sorted or not.
      
      //this list will store the orignal list..
      List<String> list = new ArrayList<>();
      for(i=0;i<grid.size();i++)
      {
          list.add(grid.get(i));
      }
      
      //sorting the grid list..
      Collections.sort(grid);  //sorting the list.
        
      //if both the lists are same..
      for(i=0;i<list.size();i++)
      {
          String a = list.get(i);
          String b = grid.get(i);
          if(a.equals(b)==false)
          {
               return "NO";
          }
      }
      return "YES";
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                    .collect(toList());

                String result = Result.gridChallenge(grid);

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
