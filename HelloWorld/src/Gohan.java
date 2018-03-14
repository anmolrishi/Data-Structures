import java.util.Scanner;

public class Gohan {
	
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);

		int n=s.nextInt();		
		int number = s.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++){
			a[i] = s.nextInt();
		}
		int question=0;
		
		while(question<number){
			int type=s.nextInt();
			if(type==1){
				int x=s.nextInt()-1;
				int y=s.nextInt()-1;
				int sum=0;
				for(int i=x;i<=y;i++){
					sum+=a[i];
				}
				System.out.println(sum);
			}
			else if(type==2){
				int x=s.nextInt()-1;
				int y=s.nextInt()-1;
				int z=s.nextInt();

				for(int i=x;i<=y;i++){
					a[i]%=z;
				}

			}
			question++;
		}


	}
}
