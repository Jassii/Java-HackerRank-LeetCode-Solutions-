import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt(); //denoting the number of test cases..

        for(int i=0;i<t;i++)
        {
          try    //if any value which can not be stored in the variable x then the exception is throws and in catch block it is solved..
            {
                long x=sc.nextLong();
                System.out.println(x+" can be fitted in:");
                if(x>=-128 && x<=127)  //for byte..
                { 
                   System.out.println("* byte");    
                }
                
                //Complete the code
                
                if(x>=Short.MIN_VALUE && x<=Short.MAX_VALUE)  //range for short datatype..
                {
                    System.out.println("* short");
                }
                if(x>=Integer.MIN_VALUE && x<=Integer.MAX_VALUE)  //range for int datatype..
                { 
                    System.out.println("* int");
                }
                if(x>=Long.MIN_VALUE && x<=Long.MAX_VALUE) //range for long datatype..
                {
                    System.out.println("* long");
                }
            }
            catch(Exception e)  //catch block says that it can't be fitter anywhere//
            {
                System.out.println(sc.next()+" can't be fitted anywhere.");
            }

        }
    }
}



