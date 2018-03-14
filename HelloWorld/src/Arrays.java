

public class Arrays {
	
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
			}
		}
	}
	
	public static void rotate(int[] arr, int index) {
		// Write your code here
		int n = arr.length;
		int temp;
		for (int i = 1; i <= index; i++){
			temp = arr[0];
		    for(int j=0;j<n-1;j++){
		            arr[j]=arr[j+1];
		            	        
		    }
		    arr[n-1]=temp;
		}
	}
	
	public static void FindTriplet(int[] arr, int num){
		//Arrays.sort(arr);
	}
	
	public static void printArray(int input[]){
		for (int i=0;i<=input.length-1;i++){
			System.out.print(input[i] + " ");
		}
	}
	
//	public static void array(int a[]){
//		int big;
//		big = Integer.MIN_VALUE;
//		
//		for(int i = 0;i<a.length;i++){
//			if(big>a[i]){
//				big=a[i];
//			}
//		}
//		System.out.println(big);
//	}

	public static void main(String[] args) {
		int a[] = {1,2,3,4,5,6,7};
//		sortBinaryArray(a);
		rotate(a,2);
		printArray(a);
	}

}
