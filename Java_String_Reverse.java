import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        int i;
        char ch[] = A.toCharArray();
        String n="";
        for(i=ch.length-1;i>=0;i--)
        {
            n = n + ch[i];
        }
        if(n.equals(A))
        {
            System.out.println("Yes");
        }
        else
        {
            System.out.println("No");
        }
    }
}



