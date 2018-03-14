import java.util.Scanner;
import java.util.Arrays;

public class Code_Kaze {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int K=s.nextInt();
		String T = s.next();
		String G = s.next();

		if((K>=1 && K<=1000) && (T.length()>=1 && T.length()<=1000) && (G.length()>=1 && G.length()<=1000)){
			
			char[] ch1=T.toCharArray();  
			   char[] ch2=G.toCharArray();  
			   Arrays.sort(ch1);
			   Arrays.sort(ch2);
			   
			   for(int i=0;i<ch1.length;i++){
				   for(int j=0;j<ch2.length;j++){
		    	      if(ch1[i]==(ch2[j])){
		    	         K--;
		    	      }
		    	      if(K==0){
		    	    	  System.out.println("YES");
		    	    	  break;
		    	      }
				   }
		    	   }
			   
			   if(K!=0){
				   System.out.println("NO");
				   return;
			   }
			
		}
		else return;
	}

}
