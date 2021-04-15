import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) 
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String a1 = sc.nextLine();  //using string value inorder to enter the big value.
        String b1 = sc.nextLine();  //using string value inorder to enter the big value.
        BigInteger a = new BigInteger(a1);  //declaring BigInteger variable..
        BigInteger b = new BigInteger(b1);
        System.out.println(a.add(b));  //using the function add for the sum..
        System.out.println(a.multiply(b));  //using the function multiply..
    }
}
