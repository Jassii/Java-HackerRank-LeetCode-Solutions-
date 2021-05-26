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
     * Complete the 'minimumDistances' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int minimumDistances(List<Integer> a) 
    {
       // Write your code here
       /*int i,j;
       int res = Integer.MAX_VALUE;
       for(i=0;i<a.size();i++)
       {
           for(j=i+1;j<a.size();j++)
           {
               if(a.get(i)==a.get(j))
               {
                   int dif = j-i;  //calculating the difference of the index value.
                   res = Math.min(res,dif); //this will be happening for the min value..
               }
           }
       }
       if(res==Integer.MAX_VALUE)
       {
           return -1;
       }
       return res;*/
       
       
       //create a map which will store the index of the respective keys..
       
       Map<Integer,List<Integer>> M = new HashMap<>();  
       
       int i;
       for(i=0;i<a.size();i++)
       {
           if(M.containsKey(a.get(i)))
           {
               M.get(a.get(i)).add(i);
           }
           else  //if map does not contain the key..
           {
               List<Integer> l = new ArrayList<>();
               l.add(i);
               M.put(a.get(i),l);
           }
       }
       //System.out.println(M);
       int min = Integer.MAX_VALUE;
       for(Map.Entry<Integer,List<Integer>> entry:M.entrySet())
       {
           List<Integer> D = entry.getValue();  //taking a list at each instance..
           if(D.size()<=1)  //atmost 1 value is there in the list..
           {
               continue;
           }
           Collections.sort(D);  //sort the list..
           for(i=0;i<D.size()-1;i++)
           {
               min = Math.min(min,D.get(i+1)-D.get(i));  //check the minimum difference..
           } 
       }
       if(min==Integer.MAX_VALUE) //if no pair is there...(that is only one value is there..)
       {
           return -1;
       }
       return min;
    }
}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.minimumDistances(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
