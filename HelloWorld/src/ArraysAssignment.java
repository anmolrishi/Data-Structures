import java.util.Arrays;
import java.util.Scanner;

public class ArraysAssignment {


	public static void sortBinaryArray(int[] arr){
		int b=0, e=arr.length-1,temp;
		int n=0;
		for (int i=0;i<arr.length-n;i++){
			if(arr[i]==0){
				temp=arr[b];
				arr[b]=arr[i];
				arr[i]=temp;
				b++;
			}
			else{
				temp=arr[e];
				arr[e]=arr[i];
				arr[i]=temp;
				e--;
				n++;
			}  // time complexity = log n 
		}
	}

	public static void CheckSequence() {

		boolean isDec=true;



	}

	public static void FindTriplet(int[] arr, int num){
		Arrays.sort(arr);

		for (int i=0;i<=arr.length-1;i++){
			for (int j=i+1;j<=arr.length-1;j++){
				for (int k=i+j+1;k<=arr.length-1;k++){
					if(arr[i]+arr[j]+arr[k] == num){
						System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);	
						/*if(arr[i]<=arr[j] && arr[i]<=arr[k]){
								if(arr[j]<=arr[k]){
									System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);	
								}
								else{
									System.out.println(arr[i] + " " + arr[k] + " " + arr[j]);
								}
							}
							else if(arr[j]<=arr[i] && arr[j]<=arr[k]){
								if(arr[j]<=arr[k]){
									System.out.println(arr[j] + " " + arr[j] + " " + arr[k]);	
								}
								else{
									System.out.println(arr[j] + " " + arr[k] + " " + arr[j]);
								}
							}*/
					}
				}
			}
		}

	}

	public static int OptimizedcheckRotate(int[] input){
		int start=0,end=input.length-1;
		int mid = (start+end)/2;
		while(input[start]>input[end])
		{
			if(input[start]<input[mid])
			{
				start = mid+1;
			}
			else
			{
				end = mid-1;
			}
			mid = (start+end)/2;
		}
		if(input.length%2==0)
		{
			mid = start+1;
			return mid;}
		else
			return start;
		//time complexity = log n

	}


	public static void printArray(int input[]){
		for (int i=0;i<=input.length-1;i++){
			System.out.println(input[i]);
		}
	}

	//		public static void array(int a[]){
	//			int big;
	//			big = Integer.MIN_VALUE;
	//			
	//			for(int i = 0;i<a.length;i++){
	//				if(big>a[i]){
	//					big=a[i];
	//				}
	//			}
	//			System.out.println(big);
	//		}

	public static void tower(char source,char helper,char destination,int num)
	{
		if(num==1)
		{	
			System.out.println("Moving"+num+"from"+source+"to"+destination);
			return;
		}

		tower(source, destination, helper, num-1);
		System.out.println("Moving"+num+"from"+source+"to"+destination);
		tower(helper, source, destination, num-1);
         // time complexity : 2^n -1 
	}
	
	
	
	public static void main(String[] args) {
		int a[] = {3, 4, 5,1, 2};
		/*			sortBinaryArray(a);
		 */		
		System.out.println(OptimizedcheckRotate(a));

	}

}


