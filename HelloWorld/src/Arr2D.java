import java.util.Scanner;

public class Arr2D {

	public static int[][] TakeInput() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Rows");
		int row = s.nextInt();
		System.out.println("Enter Columns");
		int col = s.nextInt();
		int[][] input = new int[row][col];
		
		for (int i=0;i<row;i++){
			for (int j=0;j<col;j++){
				System.out.println("Enter element at " + i + "th row " + j + "th col");
				input[i][j] = s.nextInt();
			}
		}
		return input;
		
	}
	
	public static void Print2dArray(int[][] input){
		int row=input.length;
		//int col = input[0].length;
		for (int i=0;i<row;i++){
			for (int j=0;j<input[i].length;j++){
				System.out.print(input[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	public static int SumOfAllElements(int[][] input) {
		 int row=input.length;
		int sum=0;
		for (int i=0;i<row;i++){
			for (int j=0;j<input[i].length;j++){
				sum+=input[i][j];
			}
		}
		return sum;
		
	}
	
	public static int MaxRowSum(int[][] input) {
		int row = input.length;
		int sum1[]=new int[input.length];
		int sum2[]=new int[input[0].length];
		
		for (int i=0;i<row;i++){
			for (int j=0;j<input[i].length;j++){
				sum1[i]+=input[i][j];
			}
			
		}
		
		for (int i=0;i<row;i++){
			for (int j=0;j<input[i].length;j++){
				sum2[i]+=input[j][i];
			}
			
		}
		int big1=sum1[0],index1=0,big2=sum2[0],index2=0;
		for (int i=0;i<row;i++){
			if(sum1[i]>big1){
				big1=sum1[i];
				index1=i;
			}
		}
		for (int i=0;i<input[0].length;i++){
			if(sum2[i]>big2){
				big2=sum2[i];
				index2=i;
			}
		}
		if(big1>=big2){
			System.out.println("Row Number " + index1);
			return big1;
		}
		else
		System.out.println("Col Number " + index2);
		return big2;
		
		
		
	}
	
	public static void WavePattern(int[][] input) {
		int row = input.length; int col = input[0].length;boolean Inc=true;
		for(int i=0;i<=col-1;i++)
		{
			if(Inc==true)
			{
				for(int j=0;j<=row-1;j++){
					System.out.print(input[j][i]+" ");
				}
				Inc =false;	
			}
			else
			{
				for(int j=row-1;j>=0;j--)
					System.out.print(input[j][i]+" ");
				Inc=true;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] a;
		a = TakeInput();
//		Print2dArray(a);
//		System.out.println("SUM OF ALL ELEMENTS = " + SumOfAllElements(a));
//		System.out.println(MaxRowSum(a));
		WavePattern(a);

	}

}
