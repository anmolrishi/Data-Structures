

public class Recursion {


	public static int FibMemoization(int n) {
		int[] storage = new int[n+1];
		return fib(n, storage);
	} 
	
	public static int fib(int n,int[] storage) {
		if(n==0 || n==1){
			storage[n] = 1;
			return storage[n];
		}

		if(storage[n]!=0){
			return storage[n];
		}
		
		int c1 = fib(n-1, storage);
		int c2 = fib(n-2, storage);
		
		storage[n] = c1+c2;
		
		return storage[n];

	}
	
	

	//	public static boolean checkSorted() {
	//		
	//	}

	public static int power(int x, int n) {
		if(n==0){
			return 1;
		}
		int smallAns = power(x,n/2);
		if(n%2==0){
			return smallAns*smallAns;
		}
		else{
		return x*smallAns*smallAns;}
//Time complexity = O(n)
	}

	public static int sumOfArray(int[] input, int n) {

		if(n==0){
			return 0;
		}
		int sum = input[n-1] + sumOfArray(input, n-1);
		return sum;

	}
	
	public static int sumOfDigits(int input){
		
		if(input==0){
			return 0;
		}
		
		int sum = input%10 + sumOfDigits(input/10);
		return sum;
		

	}
	
	
	

	public static String name(int n) {
		switch(n)
		{
		case 0:  return "zero";
		case 1:  return "one";
		case 2:  return "two";
		case 3:  return "three";
		case 4:  return "four";
		case 5:  return "five";
		case 6:  return "six";
		case 7:  return "seven";
		case 8:  return "eight";
		case 9:  return "nine";
		default: return "invalid input";
		}

	}
	
	public static void NumtoAlpha(int num)
	{    
		if(num==0)
		{
			return;
		}
		System.out.print(name(num%10)+" ");
		NumtoAlpha(num/10);
	}

	public static int minOfArray(int[] input,int startindex) {

		if(startindex==0){
			return Integer.MAX_VALUE;
		}

		int small = input[startindex];
		int num = minOfArray(input, startindex+1);
		if(small>num)
		{
			small=num;
		}

		return small;

	}
	
public static int countZerosRec(int input){
		
		if(input==0){
			return 0;
		}
	

		
		if(input%10==0){
			return 1 + countZerosRec(input/10);
		}
		else
			return countZerosRec(input/10);
	   
	}

public static double findGeometricSum(int k){
	
	if(k==0){
	    return 1;
	}
	
	return Math.pow(0.5, k) + findGeometricSum(k-1);

}

public static boolean isStringPalindrome(String input) {
	char[] ch=input.toCharArray();
	
	if(input.length() <=1){
		return true;
	}
	
	if(ch[0]!=ch[input.length()-1]){
			return false;
		}
	
	char[] smallString = new char[ch.length-2];
	
	for(int i=1;i<ch.length-1;i++){
		smallString[i-1] = ch[i];
	}
	String s = new String(smallString);
	return isStringPalindrome(s);
		
}

public static void allIndicesOfNum(int[] input, int startIndex, int num, boolean ans[] ) {
	
	
}

public static int[] allIndicesOfNum(int[] input, int startIndex, int num) {
	
	//BASE CASE
	if(startIndex >= input.length){
		int[] ans = new int[0];
		return ans;
	}
	int[] smallAns = allIndicesOfNum(input, startIndex, num);
	if(input[startIndex] != num){
		return smallAns;
	}
	
	int ans[] = new int[smallAns.length+1];
	ans[0] = startIndex;
	
	for (int i =0;i<smallAns.length;i++){
		ans[i+1]=smallAns[i];
	}
	return ans;
	
}

public static void selectionSortR(int[] input, int startIndex) {
	
	if(startIndex >= input.length-1){
		return;
	}
	
	int min = input[startIndex];
	int minPos = startIndex;
	
	for (int i=startIndex+1 ;i<input.length ;i++){
		if (input[i]<min){
			min = input[i];
			minPos = i;
		}
	}
	
	if(minPos!=startIndex){
		input[minPos] = input[startIndex];
		input[startIndex] = min;
	}
	
	selectionSortR(input, startIndex+1);
}

public static void bubbleSortR(int[] input, int endIndex) {
	
	if(endIndex <=0){
		return;
	}

	
	for (int i=0 ;i<=endIndex-1 ;i++){
		if (input[i]>input[i+1]){
			int temp = input[i];
			input[i] = input[i+1];
			input[i+1] = temp;
		}
	}
//	
//	if(minPos!=endIndex){
//		input[minPos] = input[startIndex];
//		input[startIndex] = min;
//	}
	
	bubbleSortR(input,endIndex-1);
}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] ans = {3,10,2,21,4,6,1};
//		NumtoAlpha(45);
//		bubbleSortR(ans, ans.length-1);
//		
//		for (int i =0 ;i<ans.length;i++){
//			System.out.println(ans[i]);
//		}
//		//System.out.println(isStringPalindrome("CAR"));
		System.out.println(FibMemoization(5));
	}

}
