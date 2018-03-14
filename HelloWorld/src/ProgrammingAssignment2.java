import java.util.Scanner;

public class ProgrammingAssignment2 {
	
	public static String reverseWordWise(String input) {
		
		
	int eI=input.length();
	String ans = "";//Character.toString(input.charAt(0));
	String ans1 = "";
	for(int i=input.length()-1;i>=0;i--){
	    if(input.charAt(i)==' '){
	        ans1 += ans.concat(input.substring(i+1,eI) + " ");
	        eI=i;}
	        else if(i==0){
	        	ans1 += ans.concat(input.substring(i,eI) + " ");
	        }
	    
	}
	
return ans1;

	}
	
	public static int findString(String text, String pattern) {
		int n=text.length();
		for(int i=0;i<n;i++){
		    if(pattern.equals(text.substring(i,i+pattern.length()))){
		        return i;
		    }
		}

		return -1;
}

	public static String reverseEachWord(String input) {
		
			int startIndex=0,n=input.length();

	String ans = "";//Character.toString(input.charAt(0));
	String ans1 = "";
	
	
	for(int i=0;i<n;i++){
	    char c = input.charAt(i);
	    if(c==' ' ){
	        
	        ans = input.substring(startIndex,i);
	       
	        int l = ans.length();
	        String reverse = "";
	        
	        for ( int j = l - 1 ; j >= 0 ; j-- ){
	        	char ch = ans.charAt(j);
	        	reverse = reverse + ch;
	        }
            
         
	       ans1 += reverse + " ";
	       
	        startIndex=i+1;}
	    
	    else if( i==n-1){
	    	 ans = input.substring(startIndex,i+1);
		      
		        int l = ans.length();
		        String reverse = "";
		        
		        for ( int j = l - 1 ; j >= 0 ; j-- ){
		        	char ch = ans.charAt(j);
		        	reverse = reverse + ch;
		        }
	            
	         
		       ans1 += reverse;
		       
		        startIndex=i+1;
	    }
	    
	    
	        	    
	}
	return ans1;

	}
	
	public static String rotateString(String inputString, int n){
		// Write your code here
        int l = inputString.length();
        char[] ch = inputString.toCharArray();
		char temp;
		for (int i = 1; i <= n; i++){
			temp = ch[l-1];
		    for(int j=0;j<l-1;j++){
		            ch[l-j-1]=ch[l-j-2];
		            	        
		    }
		    ch[0]=temp;
		}
		String newString2;
		newString2 = String.valueOf(ch);
		return newString2;
	}
	
	public static String toLowercase(String inputString) {
		// Write your code here
		String lowerCase = "";
		int n=inputString.length();
		for(int i=0;i<n;i++){
			char a = inputString.charAt(i);
			a+=32;
			lowerCase = lowerCase + a;
		}
	   return lowerCase;
	}
	

	public static String removeConsecutiveDuplicates(String input) {
	    // Write your code here
        String ans = "";
        int n=input.length();
        char[] ch=input.toCharArray();  
		for(int i=1;i<n;i++){
		    
			if(ch[i]!=ch[i-1])
			{ans = ans + ch[i-1];}
	}
		ans+=ch[n-1];
	return ans;
	}
	
	public static char highestOccuringCharacter(String inputString) {
		
		int n=inputString.length();  
        char[] c= new char[256];

        int max = Integer.MIN_VALUE;
		char result = ' ';
        for(int i=0;i<n;i++){
         c[inputString.charAt(i)]++;
         }
        
        System.out.println(c.length);
        for (int j = 0; j < n; j++) {
            if (max < c[inputString.charAt(j)]) {
                max = c[inputString.charAt(j)];
                result = inputString.charAt(j) ;
            }
        }
        	return result;
        }

public static String findLargestUniqueSubstring(String input){
	    
	int n=input.length();  
    char[] c= new char[256];
    
    for(int i=0;i<n;i++){
     c[input.charAt(i)]++;
     }
    
    String ans = "";
    for(int i=0;i<n;i++){
        if(c[input.charAt(i)]>0){
        	ans+=input.charAt(i);
        }
        
        }
    return ans;
    
	}

public static void convertStringToInt(String input){
	int n=input.length();  
char[] c= new char[32];

for(int i=0;i<n;i++){
 c[i]=input.charAt(i);
 }int i=0;
int num =0;
while(i<n)
	num= num*10 + c[i];
System.out.println(num);
}
	
	
	public static void main(String[] args) {
		
		convertStringToInt("2345");
//		String s = "aagghiittt";
//
//		System.out.println(highestOccuringCharacter(s));
		
		
		//		char[] c= new char[26];
		
//		for(int i=0;i<26;i++){
//			c[i]+=97+i;
//
//		}
//		for(int i=0;i<26;i++)
//			System.out.println(c[i]);
	//	System.out.println(removeConsecutiveDuplicates(s));
	//	System.out.println(rotateString(s, 3));
	//	System.out.println(toLowercase(s));
	//	System.out.println(reverseWordWise(s));
		/*Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		int digits = s.nextInt();
		double sqrt = 1;
//		int sqrt = 1;
//		while( sqrt * sqrt <= num){
//			sqrt++;
//		}
//		System.out.println(sqrt - 1);
		double increment = 1;
		int currentPlace = 0;
		while(currentPlace <= digits){
			while(sqrt * sqrt <= num){
				sqrt = sqrt + increment;
			}
			sqrt = sqrt - increment;
			increment = increment/ 10;
			currentPlace++;
		}
		System.out.println(sqrt);
int p=Integer.MAX_VALUE;*/
	}

}
