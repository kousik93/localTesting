package test_stack;

import java.util.Scanner;

class Node{
	
	int a;
	Node next;
	
	void insert(){
		System.out.println("Enter value");
		Scanner in=new Scanner(System.in);
		this.a=in.nextInt();
		
	}
	
	public void display()
	{
		System.out.println(this.a+"->");
	}
}

public class linkedlisttest {

	public static void main(String args[]){
		int listlength=0;
		Node first=null,last=null;
		char ch='y';
		Scanner in=new Scanner(System.in);
		System.out.println("Enter Choice:\n1. Insert\n2. Delete\n3. Display\n4. Insert Index\n5. Delete Index\n6. Quit");
	while(ch=='y'){
		System.out.println("Enter Choice:\n1. Insert\n2. Delete\n3. Display\n4. Insert Index\n5. Delete Index\n6. Quit");
	int i = Integer.parseInt(in.next());
	switch(i){
	case 1:{
		Node temp=new Node();
		temp.insert();
		 
		if(first==null){
			first=temp;
			last=temp;
			first.next=last;
			listlength++;
		}
		else{
			last.next=temp;
			last=temp;
			listlength++;
		}
		break;
	}
	case 2:{
		if(first==null){
			System.out.println("List is empty cant delete");
		}
		else if(listlength==1){
			first=last=null;
		}
		else{
			Node previous=first;
			for(Node node = first; node != null; node = node.next){
				if (node.next == null) {
		            previous.next = null;
		            last = previous;
		            listlength--;
		        }
		        previous = node;
		}
		}
		break;
		
	}
	case 3:{
		System.out.println(listlength);
		Node tmp=first;
		if(tmp==null){
System.out.println("Empty!!");
		}
		else{
		while(tmp.next!=null)
		{
			
			tmp.display();
			tmp=tmp.next;
		}
		tmp.display();
		}
		break;
	}
	case 4:{
		int i1=0;
		int index=0;
		System.out.println("Enter position");
		index=in.nextInt();
		if(index>=listlength){
System.out.println("Out of bounds");
		}
		else{
			Node previous=first;
			Node node = first.next;
		for(i=0; i<index; i++){
			 {
				 node = node.next;
	            previous=previous.next ;
	          
	        }
	       previous.next=node.next;
	       
	}
		}
		break;
	}
	case 6:{
		ch='n';
		break;
	}
	}
	}
	}
}
