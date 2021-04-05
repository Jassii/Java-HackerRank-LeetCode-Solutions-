import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Animal //parent class..
{  
	void walk()
	{
		System.out.println("I am walking");
	}
}
class Bird extends Animal//child class(Inheritance is done with the help of (extends) keyword..)
{
	void fly()
	{
		System.out.println("I am flying");
	}
    void sing()
    {
        System.out.println("I am singing");
    }
}

public class Solution{

   public static void main(String args[]){

	  Bird bird = new Bird();   //creating an object of the child class..
	  bird.walk();   //calling the method present in the parent class..
	  bird.fly();   
      bird.sing();
	
   }
}
