import java.io.*;
import java.util.*;
class Node{
	int data;
	Node next;
	Node(int d){
        data=d;
        next=null;
    }
	
}
class Solution
{//--------------------------------------------------------------------------------------------------------------------
    public static Node removeDuplicates(Node head) 
    {
      //Write your code here
      if(head==null)  //if the list is empty..then simply return null value..(or head)
      {
          return head; 
      }
      Node temp = head;  //it will be used to traverse the linked list..
      while(temp.next!=null) //untill it is null..
      {
          if(temp.data==temp.next.data)
          {
              Node t = temp.next.next; //creating new node which will point the next.next node..
              temp.next.next = null; //next duplicate node will be then null..
              temp.next = t;  //earlier will point to the next.next node..
          }
          else
          {
              temp = temp.next; //if it is not equal then simply move forward..
          }
      }
      return head; //At last simply return the head of the linked list..
    }
//---------------------------------------------------------------------------------------------------------------------------
	 public static  Node insert(Node head,int data)
     {
        Node p=new Node(data);			
        if(head==null)
            head=p;
        else if(head.next==null)
            head.next=p;
        else
        {
            Node start=head;
            while(start.next!=null)
                start=start.next;
            start.next=p;

        }
        return head;
    }
    public static void display(Node head)
        {
              Node start=head;
              while(start!=null)
              {
                  System.out.print(start.data+" ");
                  start=start.next;
              }
        }
        public static void main(String args[])
        {
              Scanner sc=new Scanner(System.in);
              Node head=null;
              int T=sc.nextInt();
              while(T-->0){
                  int ele=sc.nextInt();
                  head=insert(head,ele);
              }
              head=removeDuplicates(head);
              display(head);

       }
    }
