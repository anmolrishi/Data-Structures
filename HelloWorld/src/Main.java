import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int t=0;
		t=s.nextInt();
		while(t-->0){
			String ingredients1[] = new String[4];
			String ingredients2[] = new String[4];
			for(int i =0;i<=3;i++ ){
				ingredients1[i] = s.next();
			}
			for(int i =0;i<=3;i++ ){
				ingredients2[i] = s.next();
			}
			int similarity=0;
			for (int k = 0; k < ingredients2.length; k++) {
				for (int l = 0; l < ingredients1.length; l++) {
					if(ingredients1[l].equals(ingredients2[k])){
						similarity++;
					}
				}
				if(similarity>=2){
//					System.out.println("similar");
					break;
				}
			}
			if(similarity>=2){
				System.out.println("similar");
			}
			else{
				System.out.println("dissimilar");
			}
		}
	}

}
