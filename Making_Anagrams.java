import java.util.*;
class Solution
{
    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();  //input of first string.
        String s2 = sc.nextLine();  //input of second string.
        int result = makingAnagrams(s1,s2);
        System.out.println(result);
    }
    public static int makingAnagrams(String s1,String s2)
    {
        int n1 = s1.length();
        int n2 = s2.length();
        String com=""; //this will store the common Sub_String..
        if(n1<=n2)
        {
            int i;
            for(i=0;i<n1;i++)
            {
                char ch = s1.charAt(i); //particular character.
                String s = Character.toString(ch);  //converted into string.
                if(s2.contains(s))
                {
                    int index = s2.indexOf(ch);
                    s2 = s2.substring(0,index)+s2.substring(index+1);
                    com = com+s;
                }
            }
            //we are finding the common substring..
        }
        else
        {
            int i;
            for(i=0;i<n2;i++)
            {
                char ch = s2.charAt(i);
                String s = Character.toString(ch);
                if(s1.contains(s))
                {
                    int index = s1.indexOf(ch);
                    s1 = s1.substring(0,index)+s1.substring(index+1);
                    com = com+s;
                }
            }
        }
       //now i have got the common string..
       int count=0;
       int len = com.length();  //length of the common substring..
       int dif1 = n1 - len;  //uncommon string.
       int dif2 = n2 - len;  //uncommon string
       count = dif1+dif2;  //total length of the uncommon string..
       return count;
    }
}
