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
     * Complete the 'balancedSums' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static String balancedSums(List<Integer> arr) 
    {
       // Write your code here
       
       //when only one element is there in the list..
       
       //did not understand the logic here....
       if(arr.size()==1)
       {
           return "YES";
       }
       int i;
       int sum=0;
       for(i=0;i<arr.size();i++)
       {
           sum = sum+arr.get(i);
       }
       int lefty=0;
       for(i=0;i<arr.size();i++)
       {
           int current = arr.get(i);
           sum = sum - current;
           if(sum==lefty)
           {
               return "YES";
           }
           else
           {
               lefty = lefty + current;
           }
       }
       return "NO";
    }
       /*boolean value = check(arr,0,arr.size()-1);
       if(value==true)
       {
           return "YES";
       }
       return "NO";
    }
    public static boolean check(List<Integer> arr,int start,int end)
    {
        //calculating the middle index.
        
        if(start<=end)
        {
            int mid = (start+end)/2;
            int lsum = sum(arr,start,mid-1);  //calculating the left sum.
            int rsum = sum(arr,mid+1,end);  //calculating the right sum.
            
            
            if(lsum==rsum)
            {
                return true;
            }
            else if(lsum>rsum)
            {
                mid = mid-1;  //shift the middle index to its left..
                return check(arr,start,mid);
            }
            else if(lsum<rsum)
            {
                mid = mid+1;
                return check(arr,mid,end);
            }
        }
        return false;     
    }
    public static int sum(List<Integer> arr,int s,int e)
    {
        if(s<=e)
        {
            int i;
            int sum=0;
            for(i=s;i<=e;i++)
            {
                sum = sum + arr.get(i);
            }
            return sum;    
        }
        return 0;
    }*/

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                String result = Result.balancedSums(arr);

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
