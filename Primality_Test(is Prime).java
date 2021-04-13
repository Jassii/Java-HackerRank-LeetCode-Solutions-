import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.math.BigInteger;   //importing the BigInteger class...

public class Solution 
{
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) 
    {
        String n = scanner.nextLine();  //input of the large value in the form of string..
        
        BigInteger n1 = new BigInteger(n); //creating an(object of BigInteger class) BigInteger variable(string value is passed..)
        boolean value = n1.isProbablePrime(1); //to check if it is prime or not..
        
        if(value==true)
        {
            System.out.println("prime");
        }
        else
        {
            System.out.println("not prime");
        }
       scanner.close();
    }
}
