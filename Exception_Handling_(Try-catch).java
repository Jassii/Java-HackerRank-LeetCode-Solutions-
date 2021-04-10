import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        try
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(x/y);
        }
        catch(InputMismatchException e)  //if x or yor both are not 32bit signed integer..
        {
            System.out.println("java.util.InputMismatchException");
        }
        catch(Exception e)  //Exception other than above exception..
        {
            System.out.println(e);  //printing what kind of exception is there..
        }
    }
}
