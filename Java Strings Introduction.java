import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next(); //input of first string..
        String B=sc.next(); //input of second string.
        /* Enter your code here. Print output to STDOUT. */
        //calculating the sum of the lengths of both the strings..
        int sum=0;
        int a = A.length();
        int b = B.length();
        sum = a+b;
        System.out.println(sum);
        
        //checking whether A is lexicographically is greater than B or not..
        if(A.compareTo(B)>0)
        {
            System.out.println("Yes");
        }
        else
        {
            System.out.println("No");
        }
        
        //capitalizing first letter of both the word..
        String a1 = A.substring(0,1);
        String a2 = A.substring(1,A.length());
        
        String A1 = a1.toUpperCase();
        String newa = A1+a2;
        
        String b1 = B.substring(0,1);
        String b2 = B.substring(1,B.length());
        
        String B1 = b1.toUpperCase();
        String newb = B1+b2;
        
        
        
        /*A = A.capitalize();
        B = B.capitalize();*/
        System.out.print(newa+" "+newb);
        
    }
}



