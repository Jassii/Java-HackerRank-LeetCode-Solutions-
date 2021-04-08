import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) 
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        List<Integer> L = new ArrayList<>();
        int N = sc.nextInt();  //size of the list..
        int i;
        for(i=0;i<N;i++)
        {
            L.add(sc.nextInt());  //inserting elements in the list..
        }
        int Q = sc.nextInt();//number of queries..
        while(Q>0)
        {
            String s = sc.next();
            if(s.equals("Insert"))   //checking if the query is based on the insertion..
            {
                int x = sc.nextInt();
                int y = sc.nextInt();
                L.add(x,y);   //inserting the element in the list...("add()" function used..)
            }
            else
            {
                int x = sc.nextInt();
                L.remove(x);    //removing the value at the specific index...(using "remove()" function)...
            }
            Q--;
        }
      //inorder to traverse the elements present in the list using iterator....
        Iterator itr = L.iterator();
        while(itr.hasNext())
        {
         System.out.print(itr.next()+" ");   
        }
        
        
    }
    
}
