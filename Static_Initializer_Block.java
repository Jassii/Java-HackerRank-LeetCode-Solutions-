import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution 
{
//Write your code here
static Scanner sc = new Scanner(System.in);  //assigning this also as static because with the help of the reference variable value is provided to B and H..
static int B;  //value of breadth..
static int H;  //value of length..

//alternative method of using static initializer block...  
public static boolean flag = initializeClassVariable();
private static boolean initializeClassVariable()
{
    B = sc.nextInt();
    H = sc.nextInt();
    if(B<=0 || H<=0)   //if any of them is less than zero...
    {
        System.out.println("java.lang.Exception: Breadth and height must be positive");
        System.exit(0);  //when any value is negative then simply terminate the program elseee find the area of the parallelogram..
    }
    return true;
}
/////////////////////////////////////Another way to do this..
	static Scanner sc = new Scanner(System.in);
	static int B = sc.nextInt();
	static int H = sc.nextInt();
	static boolean flag = false;
	//just use static block declaration..
static
{
	if(B<=0 || H<=0)
	{
		System.out.println("");
		flag=false;
	}
	else
	{
		flag=true;
	}
}
	
public static void main(String[] args)
{
		if(flag)  //flag variable is accessed directly as it is static..no need to create an object..
    {      
			int area=B*H;
			System.out.print(area);
		}
		
	}//end of main

}//end of class
