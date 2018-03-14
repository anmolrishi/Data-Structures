package stacks_and_queues;

import java.util.Stack;

public class ReverseStack {
	
	public static void reverseStack(Stack<Integer> s1, Stack<Integer> s2) {
		if(s1.size()<=1){
			return;
		}
		int temp=s1.pop();
		reverseStack(s1, s2);

		while(!s1.isEmpty()){
			s2.push(s1.pop());	
		}

		s2.push(temp);

		while(!s2.isEmpty()){
			s1.push(s2.pop());
		}

	}
	public static int[] helper(int[] price, int eI) {
		if(price.length<=0){
			int ans[] = {};
			return ans;
		}
		
		
		
	}
	
	public static int[] stock(int[] price) {
		int n = price.length;
		Stack<Integer> s = new Stack<>();
		int[] ans = new int[n];
		
		for(int i=0;i<n;i++){
			s.push(price[i]);
		}
		
		int i=n-1;
		while(i>=0){
			if(!s.isEmpty() && s.peek()<=price[i]){
				s.pop();
				ans[i]++;
				continue;
			}
			else{
				for(int i1=0;i1<ans[i];i1++){
					s.push(price[i-ans[i]+1]);
				}
				i--;
				
			}
			
		}
		return ans;
	}
	
	public static int[] stockSpan(int[] price) {
		int n = price.length;
		Stack<Integer> s = new Stack<>();
		int[] ans = new int[n];
		
//		for(int i=0;i<n;i++){
//			ans[i]=1;
//		}
//		
		for(int i=0;i<n;i++){
			s.push(price[i]);
		}
		
		int i=n-1;
		while(i>=0){
			
			while(!s.isEmpty()){
				int temp=s.pop();
				if(price[i]>=temp){
				ans[i]++;
				}
				
				for(int i1=0;i1<ans[i];i1++){
					s.push(price[i-ans[i]+1]);
				}
				

			}

			
			i--;

		}
		return ans;
		
		

	}
	
//
//	public static void ReverseRecursion(StacksUsingArrays stack, StacksUsingArrays helper) {
//		if(stack.size()<=1){
//			return;
//		}
//		
//		int temp=stack.pop();
//		ReverseRecursion(stack, helper);
//		
//		while(!stack.isEmpty()){
//		helper.push(stack.pop());	
//		}
//		
//		
//		
//	}
//	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Stack<Integer> s1 = new Stack<>();
//		Stack<Integer> s2 = new Stack<>();
//		
//		for(int i=1;i<5;i++){
//			s1.push(i);
//		}
//		reverseStack(s1, s2);
//		while(!s1.isEmpty()){
//			System.out.println(s1.pop());
//		}
		int[] price = {60,70,80,100,90};
		int[] ans = stockSpan(price);
		
		for(int i=0;i<ans.length;i++){
			System.out.println(ans[i]);
		}
		
	}

}
