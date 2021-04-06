import java.util.*;
import java.io.*;


class BiCycle  //parent class..
{
	String define_me()
  {
		return "a vehicle with pedals.";
	}
}

class MotorCycle extends BiCycle  //inheritance(child class)
{
	String define_me()   //overriden funciton
  {
		return "a cycle with an engine.";
	}
	
	MotorCycle() //constructor..
  {
		System.out.println("Hello I am a motorcycle, I am "+ define_me());  //here method of child class is accessed..

		String temp=super.define_me(); //Using the super keyword in order to access the method of the parent class..

		System.out.println("My ancestor is a cycle who is "+ temp );
	}
	
}
class Solution
{
	public static void main(String []args){
		MotorCycle M=new MotorCycle();  //creating the object of the child class..
	}
}
