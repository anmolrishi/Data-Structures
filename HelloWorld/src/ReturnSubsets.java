
public class ReturnSubsets {

	public static int[][] subsets(int input[]) 
	{
		if(input.length==0)
		{
			int a[][] = {{}};
			return a;
		}

		int n=input.length;
		int[] smallInput = new int[n-1];

		for(int i=1;i<n;i++)                   // substring's work done 
		{
			smallInput[i-1]=input[i];
		}



		int[][] smallAns = subsets(smallInput);

		int[][] a = new int[2*smallAns.length][];

		for (int i = 0; i<smallAns.length; i++)
		{
			a[i]= new int[smallAns[i].length];

			for(int j=0;j<smallAns[i].length;j++)
			{
				a[i][j] = smallAns[i][j];	
			}

		}


		for (int i = 0; i<smallAns.length; i++)
		{   a[i+smallAns.length]= new int[smallAns[i].length+1];
		a[i+smallAns.length][0] = input[0];

		for(int j=1;j<smallAns[i].length+1;j++)
		{							

			a[i+smallAns.length][j] = smallAns[i][j-1];	
		}

		}

		return a;

	}
	public static void printSubsetsSumTok(int input[], int k) {
		int[][] ans = subsets(input);
        
		for (int i = 1; i<ans.length; i++)
		{ 
		int sum = 0;
		for(int j=0;j<ans[i].length;j++)
		{ 
			sum+=ans[i][j];
		}
	
		if(sum==k)
		{
			for(int j=0;j<ans[i].length;j++)
			{
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
		
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int [] input = {5, 12, 3 ,17, 1, 18 ,15 ,3 ,17};
		printSubsetsSumTok(input,6);
		
	}   

}
