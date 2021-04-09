import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String a, String b)
    {
        // Complete the function
        a = a.toLowerCase();
        b = b.toLowerCase();
        
        char A[] = a.toCharArray();
        char B[] = b.toCharArray();
        
        //sorting the first array..
        for(int i=0;i<A.length-1;i++)
        {
            for(int j=0;j<A.length-i-1;j++)
            {
                if(A[j]>A[j+1])
                {
                    char t = A[j];
                    A[j]=A[j+1];
                    A[j+1]=t;
                }
            }
        }
        
        //sorting the second array..
        for(int i=0;i<B.length-1;i++)
        {
            for(int j=0;j<B.length-i-1;j++)
            {
                if(B[j]>B[j+1])
                {
                    char t = B[j];
                    B[j]=B[j+1];
                    B[j+1]=t;
                }
            }
        }
        
        //checking if they both are anagrams or not..
        boolean r=false;
        if(A.length==B.length)  //checking if the length of both the arrays are same or not..
        {
            int i;
            for(i=0;i<A.length;i++)
            {
                if(A[i]==B[i])
                {
                    continue;
                }
                else
                {
                    r = false;
                    break;
                }
            }
            if(i==A.length)//checking if the i has reached at the end or not...
            {
                r = true;
            }
        }
        else
        {
            r =  false;
        }
        return r;
    }

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
