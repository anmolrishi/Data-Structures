import java.util.HashMap;
import java.util.Scanner;

public class RecursionHard {
	//
	//	public static String[] permutationOfString(String input){
	//	
	//		
	//		
	//	}

//	HashMap<K, V>
	
	 public static String[] permi(String s,int i)
	 {
	  if(s.length()==i)
	  {
	   String output[]={""};
	   return output;
	  }
	  String input[]=permi(s,i+1);
	  String output[]=new String[input.length*(i+1)];
	  int k=0;
	  int a=0;
	  while(k < output.length)
	  {
	   int j=0;
	   a=0;
	   while(j < input.length)
	   {
	    if(a==s.length())
	     a=0;
	    
	    if(check(s.charAt(a),input[j])==0)
	    {
	         a++;  
	    }
	    else{
	     output[k]=input[j] + s.charAt(a);
	     k++;
	     j++;
	     a++;
	    }
	   }
	   
	  }
	  return output;
	 }
	
	 public static int check(char ch,String s)
	 {int ans = 1;
	  for(int i=0;i<s.length();i++)
	  {
	   if(ch==s.charAt(i))
	    ans= 0;
	   
	  }
	  return ans;
	 }
	
	public static int[][] subsets1(int input[],int sI) {
		if(input.length==0){
			int a[][] = new int[1][];
			a[0] = new int[0];
			return a;
		}

		int n=input.length;




		int[][] smallAns = subsets(input);
		int[][] a = new int[2*smallAns.length][];

		for (int i = 0; i<smallAns.length; i++){
			for(int j=0;j<smallAns[i].length;j++){
				a[i][j] = smallAns[i][j];	
			}

		}

		for (int i = 0; i<smallAns.length; i++){
			for(int j=0;j<=smallAns[i].length;j++){
				if(j==0){
					a[i+smallAns.length][j] = input[0];	
				}else{
					a[i+smallAns.length][j] = smallAns[i][j-1];	
				}

			}

		}
		return a;

	}



	public static void printSubsets1(int[] input, int[] outputSoFar,int sum){
		if(input.length==0)
		{int s=0;
		for(int i=0;i<outputSoFar.length;i++)
		{	if(s>sum){
			return;
		}
			s+=outputSoFar[i];
		}
		if(s==sum){
			for(int i =0;i<outputSoFar.length;i++){
				System.out.print(outputSoFar[i] + " ");
			}System.out.println();
		}
		

		return;
		}

		int n=input.length;
		int[] smallInput = new int[n-1];

		for(int i=1;i<n;i++){
			smallInput[i-1]=input[i];
		}

		printSubsets1(smallInput,outputSoFar,sum);

		int b[] = new int[outputSoFar.length+1];

		for(int i=0;i<outputSoFar.length;i++)
		{
			b[i]=outputSoFar[i];
		}
		b[outputSoFar.length]=input[0];
		printSubsets1(smallInput,b,sum);

	}
	public static void printSubsetsSumTok(int input[], int k) {
		int[] outputSoFar={};
		printSubsets1(input, outputSoFar,k);
	}

//	public static void printSubsets(int input[]) {
//		int[] outputSoFar={};
//		printSubsets1(input, outputSoFar);
//
//	}

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
			for(int j=0;j<smallAns[i].length;j++)
			{
				a[i][j] = smallAns[i][j];	
			}

		}


		for (int i = 0; i<smallAns.length; i++)
		{
			a[i+smallAns.length][0] = input[0];

			for(int j=1;j<smallAns[i].length+1;j++)
			{								
				a[i+smallAns.length][j] = smallAns[i][j-1];	
			}

		}

		return a;

	}


	public static String[] subsequence(String input){
		if(input.length()==0){
			String a[] = new String[1];
			a[0] = "";
			return a;
		}

		String smallAns[] = subsequence(input.substring(1));
		String a[] = new String[2*smallAns.length];

		for (int i = 0; i<smallAns.length; i++){
			a[i] = smallAns[i];
		}
		for (int i = 0; i<smallAns.length; i++){
			a[i + smallAns.length] = input.charAt(0) + smallAns[i];
		}
		return a;

	}
	
	
	
	
	
	public static int convertStringToInt(String input){
		// Write your code here
		if(input.length() == 1)
		{
			return input.charAt(0) - '0';
		}

		int smallOutput = convertStringToInt(input.substring(0, input.length()-1));
		int lastDigit = input.charAt(input.length()-1) - '0';
		return smallOutput*10 + lastDigit;
	}

	// Return a string array that contains all possible codes
	public static  String[] getCode(String input){
		// Write your code here

		if(input.length()==0)
		{
			String a[] ={""};
			return a;
		}

		String h = "";
		int i=0,j=0,k=0;
		h=input.substring(1);
		String m[]= getCode(h);
		String a[]= new String[m.length];

		for(i=0;i<m.length;i++)
			a[i]= (char) (input.charAt(0) + 48)+ m[i];

		int p=0;
		for(k=0;k<m.length;k++)
		{
			String q;

			if(m[k].compareTo("")==0) 
				break;

			else
				q=""+input.charAt(0) + (int)(m[k].charAt(0)-96);

			int v = convertStringToInt(q);

			if(v>=10 && v<=26)
			{
				String a1[] = new String[a.length+1];

				for(p=0;p<a.length;p++)
				{
					a1[p] = a[p];
				}

				if(m[k].length()>1)
					a1[p]= (char)(v+96) + m[k].substring(1,m[k].length());

				else
					a1[p]= ""+ (char)(v+96);

				a=a1;

			}
		} 


		return a;
	}

	
	
	public static int convert(String input) {
		if(input.length()==0){
			return 0;
		}
		
		String anew = "";
		anew = input.substring(1);
		
		int n = convert(anew);
		
		int num = ((int) (input.charAt(0))-48) * (int)Math.pow(10, anew.length()) + n;
		return num;
	}
	
	public static void code(String input,String n) {
		if(input.length()==0){
			System.out.println(n);
			return;
		}
		if(input.length()==1){
			System.out.println((char) (input.charAt(0)+48)+n);
			return;
		}
		
		char ch=(char)(input.charAt(input.length()-1)+48);
		code(input.substring(0, input.length()-1), ch+n);
		int v=convert(input.substring(input.length()-2));
		
		if(v>=10 && v<=26){
			code(input.substring(0,input.length()-2),(char)(v+96)+n);
		}
	}
	public static void printAllPossibleCodes(String input) {
		// Write your code here
        code(input,"");
	}
	
	public static void generateAllParenthesis(int n,String s) {
		if(n==0){
			return;
		}
		
		
		
	}

	public static void main(String[] args) {
		
		//printAllPossibleCodes("1123");
//		String[] s = getCode("1123");
		
//		for (int i = 0; i<s.length; i++){
//			System.out.println(s[i]);
//		}
//		
		Scanner s = new Scanner(System.in);
		 String a=s.next();
		 String output[]=permi(a, 0);
		 for(int i=0;i<output.length;i++)
		 {
		  System.out.println(output[i]);
		 }
		 
		
		//int b[] = {5 ,12 ,3 ,17, 1, 18, 15, 3, 17 };
		//System.out.println(new int[0][0]);
	//	printSubsetsSumTok(b, 6);
//		int[][] ans = subsets(b);
//
//		for (int i = 1; i<ans.length; i++)
//		{
//			for(int j=0;j<ans[i].length;j++)
//			{
//				System.out.print(ans[i][j]);
//			}
//			System.out.println();
//		}
	}   
} 

