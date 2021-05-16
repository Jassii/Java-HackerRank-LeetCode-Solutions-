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
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) 
    {
    // Write your code here
    int i;
    int rows = arr.size();//inorder to calculate the number of elements in the rows.
    int columns = arr.get(0).size();
    /*System.out.println(rows);
    System.out.println(columns);*/
    int ld=0,rd=0;
    //for left diagnol
    for(i=0;i<rows;i++)
    {
        ld = ld + arr.get(i).get(i);  //as both should be equal for the left diagnol.. 
    }
    //for right diagnol..
    // 0--(l-(0+1))
    // 1--(l-(1+1))
    // 2--(l-(2+1))
    
    for(i=0;i<rows;i++)
    {
        rd = rd+arr.get(i).get(rows-(i+1));
    }
    return Math.abs(ld-rd);  //return the absolute difference..
}
}  
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
