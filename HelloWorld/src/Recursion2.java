
public class Recursion2 {

	public static String replace(String input){
		if(input.length()==0){
			return "";
		}
		if(input.length()==1){
			return input.substring(0, 1);
		}
		
		String a = "";
		
		if(input.charAt(0)=='p' && input.charAt(1)=='i'){
			a="3.14" + replace(input.substring(2));
			
		}
		else{
		a = input.charAt(0) + replace(input.substring(1));
		}
		return a;
		
	}
	//static String a = "";
	public static String addStars(String s) {
		if(s.length()==0){
			return "";
		}
		if(s.length()==1){
			return s.substring(0, 1);
		}
		String a = "";
		if(s.charAt(0)==s.charAt(1)){
			a =s.charAt(0) + "*" + addStars(s.substring(1));
		}else{
		
		a =s.charAt(0) + addStars(s.substring(1));
		}
		return a;

	}
	
//	public static int bsearch(int a[],int s,int e,int x) {
//		if(){
//			return -1;
//		}
//		
//	}
//	
//	public static int binarySearch(int input[], int element) {
//		
//		int start=0,end = input.length-1;
//		int mid = (start+end)/2;
//		
//		if(end <start){
//			return -1;
//		}
//		
//		
//		if(input[mid]==element){
//			return mid;
//		}
//		int[] smallInput = new int[mid];
//		if(input[mid]<element){int k=0;
//			for(int i=mid+1;i<=end;i++){
//				smallInput[k] = input[i];k++;
//			}
//			return k+binarySearch(smallInput, element);
//		}
//		else{int k=0;
//			for(int i=0;i<mid;i++){
//				smallInput[k] = input[i];k++;
//			}
//			return k+binarySearch(smallInput, element);
//		}
//
//	}
	
	public static boolean check(String checkString) 
	{
		if(checkString.length()<=2)
		{
			return true;  //base case
		}
		
		if(checkString.charAt(0)=='a')
			
		{
			if(checkString.charAt(1)=='a' || checkString.charAt(1)==' ')
			{
				return check(checkString.substring(1));
			}
			
			else if (checkString.charAt(1)=='b' && checkString.charAt(2)=='b')
			{
				return check(checkString.substring(1));
			}
			
			else return false;
		}


		if(checkString.charAt(0)=='b' && checkString.charAt(1)=='b')
		{
			if(checkString.charAt(2)=='a' || checkString.charAt(2)==' ')
			{
				return check(checkString.substring(2));
			}
			else return false;
		}
		return false;
	}
	
	public static boolean checkStringWithAandB(String input){
		
		
		if(input.charAt(0) == 'a'){
			return check(input.substring(1));
		}
		else return false;

	}
	
	public static int recursiveBinarySearch(int[] sortedArray, int start, int end, int key) {
        
        if (start < end) {
            int mid = start + (end - start) / 2; 
            if (key < sortedArray[mid]) {
                return recursiveBinarySearch(sortedArray, start, mid, key);
                 
            } else if (key > sortedArray[mid]) {
                return recursiveBinarySearch(sortedArray, mid+1, end , key);
                 
            } else {
                return mid;  
            }
        }
        return -1; 
    }

	
	public static int binarySearch(int input[], int element) {
		return recursiveBinarySearch(input, 0,input.length, element);

	}
	
	public static String removeX(String input){
		if(input.length()<=0){
			return "";
		}
		
		String a = "";
		
		if(input.charAt(0)=='x'){
			return removeX(input.substring(1));
		}
		
			a+=input.charAt(0) + removeX(input.substring(1));
		

		
		
		return a;
	}
	
/*	public static String[] subsequence(String input){
		if(input.length()==0){
		    String ans[] = new String[1];
		    ans[0] = "";
		    return ans;
		}
		
		String smallAns[] = subsequence(input.substring(1));
		
		String ans[] = new String[2 * smallAns.length];
	   
		for(int i=0;i<smallAns.length;i++){
			ans[i] = smallAns[i];
		}
		
			ans = 
			return a;
			

	}*/
	
	public static void printSubsequence(String input, String outputSoFar){
		if(input.length()==0){
		   System.out.println(outputSoFar);
		    return;
		}
		
	   
		printSubsequence(input.substring(1),outputSoFar);
		printSubsequence(input.substring(1),outputSoFar + input.charAt(0));	

	}
	public static String helper(int n) {
		switch(n){
		case 2 :
			return "abc";
		case 3 :
			return "def";
		case 4 :
			return "ghi";
		case 5 :
			return "jkl";
		case 6 :
			return "mno";
		case 7 :
			return "pqrs";
		case 8 :
			return "tuv";
		case 9 :
			return "wxyz";
		default : return "";
		
		}
		
	}
	
	public static String[] keypad(int[] num, String[] m) {
		
		if(num.length<=0){
			
		    String ans[] = new String[1];
		    ans[0] = "";
		    return ans;
		}
		
		int[] small = new int[num.length-1];
		
		for(int i=1;i<num.length;i++){
			small[i-1] = num[i];
		}
		
		String smallAns[] = keypad(small,m);
		
		String ans[] = new String[smallAns.length];
		
		for(int i=0;i<smallAns.length;i++){
			ans[i] = m[i].charAt(i) + smallAns[i];
		}
		
		
		
		return ans;
		
		
	}
	
	
public static String[] keypadClass(int num, String[] m) {
		
		if(num==0){
			
		    String ans[] = new String[1];
		    ans[0] = "";
		    return ans;
		}
		
		
		String smallAns[] = keypadClass(num/10,m);
		int lastDigit = num%10;
		String lastDigitOptions = m[lastDigit];
		
		String ans[] = new String[smallAns.length * lastDigitOptions.length()];
		int k =0 ;
//		for(int i=0;i<lastDigitOptions.length();i++){
//		for(int j=0;j<smallAns.length;j++){
//			ans[k] = smallAns[j] + lastDigitOptions.charAt(i);
//			k++;
//		}
//		}

		for(int i=0;i<smallAns.length;i++){
		for(int j=0;j<lastDigitOptions.length();j++){
			ans[k] = smallAns[i] + lastDigitOptions.charAt(j);
			k++;
		}
		}

		
		return ans;
		
		
	}

public static void printKeypadClass(int num, String[] m, String outputSoFar) {
	
	int lastDigit = num%10;
	String lastDigitOptions = m[lastDigit];
	
	
	if(num==0){
		System.out.println(outputSoFar);
	    return ;
	}
	
	if(lastDigit==7 || lastDigit==9){
		printKeypadClass(num/10, m, lastDigitOptions.charAt(0) + outputSoFar);
		printKeypadClass(num/10, m, lastDigitOptions.charAt(1) + outputSoFar);
		printKeypadClass(num/10, m, lastDigitOptions.charAt(2) + outputSoFar);
		printKeypadClass(num/10, m, lastDigitOptions.charAt(3) + outputSoFar);
	}
	else{
	printKeypadClass(num/10, m, lastDigitOptions.charAt(0) + outputSoFar);
	printKeypadClass(num/10, m, lastDigitOptions.charAt(1) + outputSoFar);
	printKeypadClass(num/10, m, lastDigitOptions.charAt(2) + outputSoFar);
	}
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
	public static void main(String[] args) {
//	String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
//		printKeypadClass(73,map, "");
//	
		
	//	printSubsequence("abc", "");
	//	System.out.println(checkStringWithAandB("abbaabb"));
		//		String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
//	System.out.println(replace("afpipifs"));
//	//	int[] a = {2,3};
//	String[] print = subsequence("abc");
//////int a[] = {1,3,5,7,9,11,13,15,17};
//		for(int i=0;i<print.length;i++){
//System.out.println(print[i]);
//	}

}
}
