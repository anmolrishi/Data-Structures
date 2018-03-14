
public class Test2 {


	//	public static String[] allStrings(String charSet, int len) {
	//		char[] set = charSet.toCharArray();
	//        int n = set.length;        
	//        printAllKLengthRec(set, "", n, len);
	//    }
	// 
	//    // The main recursive method to print all possible strings of length k
	//    static void printAllKLengthRec(char set[], String prefix, int n, int k) {
	//         
	//        // Base case: k is 0, print prefix
	//        if (k == 0) 
	//        {
	//            System.out.println(prefix);
	//            return;
	//        }
	// 
	//        // One by one add all characters from set and recursively 
	//        // call for k equals to k-1
	//        for (int i = 0; i < n; ++i) 
	//        {
	//             
	//            // Next character of input added
	//            String newPrefix = prefix + set[i]; 
	//             
	//            // k is decreased, because we have added a new character
	//            printAllKLengthRec(set, newPrefix, n, k - 1); 
	//        }
	//    }
	//    

//	public static String[] allStrings(String charSet, int len){
//		if(charSet.length()==0)
//		{	
//			String ans[] = new String[1];
//			ans[0] = "";
//			return ans;
//		}
//		String smallAns[] = allStrings(charSet.substring(1),len);
//		String prefix = charSet.substring(0, 1);
//		String ans[] = new String[smallAns.length];
//
//		for(int i=0;i<smallAns.length;i++)
//		{
//			ans[i] = prefix+smallAns[i];
//		}
//
//		return ans;
//	}
 static double sum = 0;
 
	public static void hello(){
		sum += 0.4;		
		
	}
	
	public static String[] allStrings(String charSet, int len){
		if(charSet.length()==0)
		{	
			String ans[] = new String[1];
			ans[0] = "";
			return ans;
		}
		char smallAns[] = charSet.toCharArray();
		//= allStrings(charSet.substring(1),len);
		char[] prefix = charSet.toCharArray();
		
		String ans[] = new String[(int)Math.pow(charSet.length(), len)];
  //      prefix = charSet.substring(0, 1+hello());
		for(int i=0;i<(int)Math.pow(charSet.length(), len);i++)
		{	hello();
			ans[i] += prefix[(int)sum]+smallAns[i];
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
	public static String minLengthWords(String input){
		if(input.length()==0){
			return "";
		}
		int big = Integer.MIN_VALUE;
		int sI=0;
		int eI=0;
		int index = 0;
		char[] c = input.toCharArray(); 
		
		for(int i=0;i<c.length;i++){
			if(c[i]==' '){
				sI=i;
				int j=i;
				while(j<c.length && c[j]!=' '){
					j++;
				}
				eI=j;
			}
			index = eI-sI;
			if(index>big){
				big = index;
			}
		}
		
		System.out.println(big);
		return null;
		// Write your code here

	}
	public static String minLengthWord(String input){
		if(input.length()==0){
			return "";
		}
		String minWord = "";
		
		for(int i=0;i<input.length();i++){
			if(input.charAt(i) == ' '){
				int index = input.indexOf(' ');
				int length = index-i;
				if(length==minWord.length()){
					continue;
				}
				if(length<minWord.length()){
					minWord = input.substring(i,index);
				}
			}
		}
		return minWord;
	}	
	
	

	// Return a string array that contains all the possible strings
	public static String[] keypad(int n){
		String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};



		return keypadClass(n,map);
	}




	public static void main(String[] args) {
//String[] ans1 = allStrings("abc",2);
//for(int i=0;i<ans1.length;i++){
//	System.out.println(ans1[i]);
//}
//		
		System.out.println(minLengthWord("Hello Therer s d"));
	//	String s = minLengthWord("ALL IS WELL");
	}

}
