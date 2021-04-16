//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

class Solution{
	public static void main(String []argst)
	{
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //denoting the number of queries..
        Map<String,Integer> mp = new HashMap<String,Integer>();  //making map..
        int i;
        sc.nextLine();
        for(i=0;i<n;i++)
        {
            String name = sc.nextLine(); //name
            int ph = sc.nextInt();  //phone number
            mp.put(name,ph);
           sc.nextLine();
            
        }
        while(sc.hasNext()) //till the EOF
        {
            String q = sc.nextLine();
            try
            {
                int p = mp.get(q);
                System.out.println(q+"="+p);
            }
            catch (Exception e)
            {
                System.out.println("Not found");
            }
        }
	}
}
