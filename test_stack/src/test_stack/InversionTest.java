package test_stack;

import java.util.ArrayList;
import java.util.Scanner;

public class InversionTest {
	
	public static int count=0;
	
public static void invert(ArrayList<Integer> input){
		
		int center;
		ArrayList<Integer> left=new ArrayList<Integer>();
		ArrayList<Integer> right=new ArrayList<Integer>();
		
		if(input.size()==1){
			count+=0;
		}
		else{
			center=input.size()/2;
			System.out.println("center:"+center);
			for(int i=0;i<center;i++)
				left.add(input.get(i));
			for(int i=center;i<input.size();i++)
				right.add(input.get(i));	
			invert(left);
			invert(right);
			splitInvertCheck(left,right );
			
		}
		
		
	}
	
	public static void splitInvertCheck(ArrayList<Integer> left, ArrayList<Integer> right){
		int i=0,j=0;
		while(i<left.size()&&j<left.size()){
			if(left.get(i)>right.get(j)){
				count=count+left.size()-i;
				j++;
				
			}
			else{
				i++;
			}
		}
		
	}
		
	
	public static void main(String args[]){
		int stop=0,length=0;
		ArrayList<Integer> input = new ArrayList<Integer>();
		
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the values. Enter -1 to stop");
		while(stop!=-1){
			stop=in.nextInt();
			if(stop!=-1)
			input.add(stop);
		}
		
		length=input.size();
		ArrayList<Integer> new1 = new ArrayList<Integer>(length+1);
		invert(input);
		System.out.println("Count is: "+count);
	}
}
