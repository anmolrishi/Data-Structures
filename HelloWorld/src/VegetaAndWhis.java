import java.util.Scanner;

public class VegetaAndWhis {

	public static int count(int n,int p,int q) {
		if(n==0){
			return 0;
		}
		
		if(p>q){int power = 0;
			while(Math.pow(p,power) <n){
				power++;
			}
			--power;
			if(Math.pow(p,power)==n){
				return 0;
			}
			else{
				n-=Math.pow(p,power);
				return 1+count(n, p, q);
			}
		}
		else {int power = 0;
		while(Math.pow(q,power) <n){
			power++;
		}
		--power;
		if(Math.pow(q,power)==n){
			return 1;
		}
		else{
			n-=Math.pow(q,power);
			return count(n, p, q)+1;
		}
	}
	}
	
	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
		
		int n=s.nextInt();		
        int p=s.nextInt();		
        int q=s.nextInt();	
        
        if((n>=1 && n<=200000) && (p>=1 && p<=200000) && (q>=1 && q<=200000)){
            int ans = 0;
            
            while(n!=0){
            	int power = 0;
    			while(Math.pow(p,power) <=n && Math.pow(q,power) <=n){
    				power++;
    			}
    			--power;
    			
    			if(Math.pow(p,power)>Math.pow(q,power)){
    				n-=Math.pow(p,power);
    			}
    			else{
    				n-=Math.pow(q,power);
    			}
    			
    			ans++;
            }
            
            
            
            System.out.println(ans);
        }
	}
	

}
