import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'closestNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> closestNumbers(List<Integer> arr) 
    {
      // Write your code here
      
      //first let us sort the list.
      Collections.sort(arr);
      
      //My main motive is to find the smallest absolute difference..
      int i;
      int min = Integer.MAX_VALUE;
      for(i=0;i<arr.size()-1;i++)
      {
          int dif = Math.abs(arr.get(i+1)-arr.get(i));
          min = Math.min(min,dif);
      }
      
      //As we have got the smallest minimum difference..
      //now we will see which of the pairs have that minimum difference..
      
      List<Integer> result = new ArrayList<>();  //this list will store the final list.
      for(i=0;i<arr.size()-1;i++)
      {
          int dif = Math.abs(arr.get(i+1)-arr.get(i));
          if(dif==min)  //if the dif between pairs matches with the min..
          {
              result.add(arr.get(i));  //add the (i)'th value..
              result.add(arr.get(i+1)); //add the (i+1)'th value..
          }
      }
      return result;  //finally return the result list.
    }
}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        List<Integer> result = Result.closestNumbers(arr);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
