
import java.io.IOException;
import java.lang.reflect.Method;

class Printer<T>  //first defining the <T> as the generic....
{  
      void printArray(T array[])   //here T refers to the type passed from the main function..
      {
          int i;
          for(i=0;i<array.length;i++) //looping the array....
          {
              System.out.println(array[i]);  //printing the values of the arrays passed..
          }
      }
}
public class Solution 
{
    public static void main( String args[] ) {
        Printer myPrinter = new Printer();  //creating the object of Printer class..
        Integer[] intArray = { 1, 2, 3 };  //creating an integer type array(Writing Integer) as it has to be used as a generic..
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);     //passing integer array..
        myPrinter.printArray(stringArray);  //passing string array..
        int count = 0;

        for (Method method : Printer.class.getDeclaredMethods()) {
            String name = method.getName();

            if(name.equals("printArray"))
                count++;
        }

        if(count > 1)System.out.println("Method overloading is not allowed!");
      
    }
}
