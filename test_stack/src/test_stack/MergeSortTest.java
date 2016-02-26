package test_stack;

import java.util.*;
import java.util.*;

public class MergeSortTest {
	
	
	public static ArrayList<Integer> mergeSort(ArrayList<Integer> input){
		
		int center;
		ArrayList<Integer> left=new ArrayList<Integer>();
		ArrayList<Integer> right=new ArrayList<Integer>();
		
		if(input.size()==1){
			return input;
		}
		else{
			center=input.size()/2;
			System.out.println("center:"+center);
			for(int i=0;i<center;i++)
				left.add(input.get(i));
			for(int i=center;i<input.size();i++)
				right.add(input.get(i));	
			mergeSort(left);
			mergeSort(right);
			merge(left,right,input );
			
		}
		
		return input;
	}
	
	public static void merge(ArrayList<Integer> left,ArrayList<Integer> right,ArrayList<Integer> input){
		int i=0,j=0,k=0;
		while(i<left.size()&&j<right.size()){
			if(left.get(i)<right.get(j)){
				input.set(k,left.get(i));
				i++;
				
			}
			else {
				input.set(k,right.get(j));
				j++;
				
			}
			k++;
			
		}
		if(i>=left.size()){
			while(j<right.size()){
				input.set(k,right.get(j));
				j++;
				k++;
			}
		}
		if(j>=right.size()){
			while(i<left.size()){
				input.set(k,left.get(i));
				i++;
				k++;
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
		input=mergeSort(input);
		for(int d:input) {
            System.out.println(d);
		}
	}
}
