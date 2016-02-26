package test_stack;
import java.io.*;
import java.lang.*;
import java.util.Scanner;


  class Test{
	int a;
	Test next;
	
	void test(){
		
	}
	public void getData(){
		System.out.println("Enter value");
		Scanner in=new Scanner(System.in);
		this.a=in.nextInt();
		
	}
	public void display()
	{
		System.out.println(this.a+"->");
	}
}


public class test_stack {

	@SuppressWarnings({ "unused", "null" })
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		int choice;
		char ch='y';
		Test head;
		head=null;
		
		
		System.out.println("Enter Choice:\n1. Insert\n2. Delete\n3. Display\n4. Quit");
		while(ch=='y'){
			System.out.println("Enter Choice:\n1. Insert\n2. Delete\n3. Display\n4. Quit");
		int i = Integer.parseInt(in.next());
		switch(i){
		case 1:{
			Test temp=new Test();
			temp.getData();
			
			if(head==null){
				head=temp;
				head.next=null;
			}
			else{
				temp.next=head;
				head=temp;
			}
			break;
		}
		case 2:{
			if(head==null){
				System.out.println("List is empty cant delete");
			}
			else{
			head=head.next;
			}
			break;
			
		}
		case 3:{
			Test tmp=head;
			if(tmp==null){
System.out.println("Empty!!");
			}
			else{
			while(tmp.next!=null)
			{
				head.display();
				tmp.display();
				tmp=tmp.next;
			}
			tmp.display();
			}
			break;
		}
		case 4:{
			ch='n';
			break;
		}
		}
		}
	}
	
}
