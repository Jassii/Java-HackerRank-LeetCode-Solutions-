import java.util.*;
class Solution{
	
	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			String input=sc.next();
            //Complete the code
            System.out.println(balanced(input));
		}
		
	}
    
    public static boolean balanced(String input)
    {
        if(input.isEmpty())
            {
                return true;
            }
        else
            {
                //we will use stack..
            Stack<Character> stack = new Stack<Character>(); //declareing stack..
            int i;
              for(i=0;i<input.length();i++)  //traversing through the string..
              {
             char ch = input.charAt(i); //extracting th character..
             if(ch=='('||ch=='{'||ch=='[')  //if it is opening braces(push in the stack)
              {
                 stack.push(ch);
             }
             else if(ch==']') //closing brace
             {
                if(stack.isEmpty() || stack.pop()!='[')  //here we are actually poping the element from the stack..
                {
                    return false;
                 }
             }
            else if(ch=='}')
            {
                 if(stack.isEmpty() || stack.pop()!='{')
                 {
                    return false;
                }
             }
            else if(ch==')')
               {
               if(stack.isEmpty() || stack.pop()!='(')  //here popping of braces taking place...
                {
                   return false;
                }
            }
         }
         return stack.isEmpty();  //at last if the stack is empty then it is balanced otherwise it is not..
       }
    }
}
