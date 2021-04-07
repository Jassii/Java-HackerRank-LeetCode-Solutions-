import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.text.NumberFormat; //importing the NumberFormat class(Abstract class)
import java.util.Locale;

public class Solution
{
    
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        double payment = sc.nextDouble();  //payment which has to be formatted..
        sc.close();
        
        String us = NumberFormat.getCurrencyInstance(Locale.US).format(payment);   //using the getCurrencyMethod of NumberFormat class in order to get the currency (followed with .format method for taking payment as a paramter)..
        String india = NumberFormat.getCurrencyInstance(new Locale("en","IN")).format(payment);//here Locale of India is created as it is not inbuilt..(created object of Locale class..)
        String china = NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
        String france = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);
        
        System.out.println("US: " + us);  //printing the formatted payment of the respected countries..
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}
