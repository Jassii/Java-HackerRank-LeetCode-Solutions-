import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        s = s.trim();//if there is any trailing spaces..
        if(s.length()==0)  //if the string is zero
        {
            System.out.println(0);   //number of tokens will be zero..
            return;   //return nothing..
        }
        String C[] = s.split("[^A-Za-z]+");  //split it if any non alphabetical characters are found..
        System.out.println(C.length);  //printing the number of tokens...
        for(int i=0;i<C.length;i++)
        {
            System.out.println(C[i]);  //printing the tokens..
        }
        scan.close();
    }
}
