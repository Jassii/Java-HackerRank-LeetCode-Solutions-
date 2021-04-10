import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) 
    {
            Map<Integer,Integer> mp = new HashMap<>();
            
            //traversing through the array elements and counting frequencies and storing in the MAP..
            int i;
            for(i=0;i<ar.length;i++)
            {
                if(mp.containsKey(ar[i]))
                {
                    mp.put(ar[i],mp.get(ar[i])+1);
                }
                else
                {
                    mp.put(ar[i],1);
                }
            }
            //now calculating the total number of pairs...
            int pairs=0;
            for(Map.Entry m:mp.entrySet())  //for traversing the map..
            {
                int t = (int)m.getValue();
                int y = t/2;
                pairs = pairs+y;
            }
            return pairs;  //returning the number of pairs..
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
