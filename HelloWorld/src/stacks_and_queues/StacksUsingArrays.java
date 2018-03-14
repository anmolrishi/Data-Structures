package stacks_and_queues;

public class StacksUsingArrays {

	
	
		private int[] data; 
		private int top=-1; // refers to the last element in the stack
		// being private prevents the use of stack in the same package 

		public StacksUsingArrays(int size) 
		{
			data = new int[size];
		}

		public int size() // non static because every stack should have a different size 
		{
			return top+1;   // time complexity = 1
		}
		
		public boolean isEmpty()
		{
			if(size()==0)
				return true;
			else
				return false;
			//return size()==0;
		}


		public int top()    // time complexity = 1
		{
			if(isEmpty())
			{
				//ideally throw an Exception
				return Integer.MIN_VALUE;
			}
			return data[top];
		}

		public void push(int element) // cannot be static because it access top which is static
		{
			if(top==data.length-1)
			{                              // time complexity = 1
				//stack overflow
				return;
			}
			data[++top]= element;
		}


		public int pop()
		{                  // time complexity = 1

			if(isEmpty())
			{
				//ideally throw an Exception
				return Integer.MIN_VALUE;
			}
			int temp= data[top];
			top--;
			return temp; // or return data[top--];
		}
	
}
