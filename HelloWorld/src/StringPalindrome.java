

public class StringPalindrome {

	public static void printSubstrings(String input) {
		int n=input.length();
		//System.out.println(input.substring(0,1));
		for(int i=0;i<n;i++){
			for(int j=0;j<=i;j++){
			if(checkPalindrome(input.substring(j, i+1))){
					System.out.println(input.substring(j, i+1));	
				}
				
			}
		}
		
	}
	
	public static boolean checkPalindrome(String input) {
		int n=input.length();
		int i=0;
		while(i<n/2){
			if(input.charAt(i) != input.charAt(n-i-1)){
				return false;
				
			}
			i++;
		}
		return true;
		
	}
	
	public static void optimizedCheckSubstringPalindrome(String input) {
		int n=input.length();
		boolean flag;
		int c=0;
		
		
		
		for(int i=1;i<n;i++ ){
			flag=true;
		for(int j=0;j<i/2;j++){
			if(input.charAt(i)!=input.charAt(j-i-1)){
				flag=false;
			}
	//		else flag=false;
		}
		if(flag==true){
			c++;
		}
		}
		System.out.println(c);
		
	}
	
	public static void main(String[] args) {
		printSubstrings("ABBABAD");
		optimizedCheckSubstringPalindrome("ABBABAD");
//		System.out.println(checkPalindrome("ABBABAD"));
	}	
}
