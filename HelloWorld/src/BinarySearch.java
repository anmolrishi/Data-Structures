import java.util.Scanner;

public class BinarySearch {

	public static int binSearch(int[] input){
		int start=0,end=input.length-1;
		int mid = (start+end)/2;
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		while(start<=end && input[mid]!=num){
			if(num<input[mid]){
				end = mid-1;
			}
			else{
				start = mid+1;
			}
			mid = (start+end)/2;
		}
		
		if(num==input[mid]){
			return mid+1;
		}
		else
			return -1;
	}
	
	
	
	public static void main(String[] args) {
		int a[] = {2,4,6,8,10};
		int ans = binSearch(a);
		System.out.println(ans);
	}

}
