package stacks_and_queues;

import java.util.Scanner;
import java.util.Stack;

public class CheckBrackets {
	
	public static boolean Check(String input) {
		
		if(input.length()==0){
			return true;
		}
		
		StacksUsingArrays st = new StacksUsingArrays(input.length());
		char c[] = input.toCharArray();
		int i=0;
		while(i<c.length){
			if(c[i] == '{' ||c[i] == '(' ||c[i] == '[' ){
				st.push(c[i]);
			}
			if(c[i] == '}'){
				if(st.pop()!='{'){
					return false;
				}
			}
			else if(c[i] == ']'){
				if(st.pop()!='['){
					return false;
				}
			}
			else if(c[i] == ')'){
				if(st.pop()!='('){
					return false;
				}
			}
			i++;
		}
		return st.isEmpty();
		
	}

public static boolean CheckRedundantBrackets(String input) {
		
		if(input.length()==0){
			return false;
		}
		
		Stack<Character> st = new Stack();
		
		char c[] = input.toCharArray();
		int i=0,count=0;
		
		while(i<c.length){
			count=0;
			if(c[i] != ')'){
				st.push(c[i]);
			}
			
			else if(c[i] == ')'){
				while(st.pop()!='('){
					count++;
				}
//				if(st.pop()=='('){
//					return true;
//				}
				if(count==0){
					return true;
				}
			}
			i++;
		}
		return false;//st.isEmpty();
		
	}


    
     public static int[] stockSpan(int[]price)
    {
      int[]span = new int[price.length];
  
  //The stack stores last day with a stock greater than this day 
      Stack<Integer> days = new Stack<Integer>();
      
      days.push(0);
      span[0] = 1;
      
      for(int i = 1 ; i < price.length ; i++)
      {
    
      while(!days.isEmpty() && (price[days.peek()]<price[i]))
      {
        days.pop();
      }
    
      if(!days.isEmpty())
          span[i] = i - days.peek();
      else
          span[i] = i+1;
      
      days.push(i);
    
      }
  
     return span;
}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter expression : ");
		String input = s.nextLine();
		System.out.println(CheckRedundantBrackets(input));
		
	}
}
