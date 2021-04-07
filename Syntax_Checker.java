import java.util.Scanner;
import java.util.regex.*;

public class Solution
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases>0){
			String pattern = in.nextLine();  //enter the string..
          	//Write your code
              try
              {
                  Pattern.compile(pattern);  //this method will take the input and check the regex is valid or not..if it gives an exception then it is not valid..
                  System.out.println("Valid");    
              }
              catch (PatternSyntaxException p)  //suppose the regex is not valid then the exception generated will be (PatternSyntaxException)...
              {
                  System.out.println("Invalid");  //print invalid..
              }
              testCases--;  //decreasing the value..
		} 
	}
}
