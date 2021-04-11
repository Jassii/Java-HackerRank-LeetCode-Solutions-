import java.util.Scanner;
class MyCalculator 
{
    /*
    * Create the method long power(int, int) here.
    */
    public long power(int n,int p) throws Exception  //this tells that this method can throw an exception
    {
        if(n<0||p<0)
        {
            throw new Exception("n or p should not be negative.");  //exception is thrown(returned back)
        }
        else if(n==0 && p==0)
        {
            throw new Exception("n and p should not be zero.");  //exception is thrown(returned back)
        }
        else
        {
            return (long)Math.pow(n,p);  //return the power n^p..
        }
    } 
    
}

public class Solution 
  {
    public static final MyCalculator my_calculator = new MyCalculator();
    public static final Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        while (in .hasNextInt()) {
            int n = in .nextInt();
            int p = in .nextInt();
            
            try {
                System.out.println(my_calculator.power(n, p));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
