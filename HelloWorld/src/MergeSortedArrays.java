
public class MergeSortedArrays {

	public static int[] SortedMerge(int[] a,int[] b) {
		int i=0,j=0,k=0;
		int n=a.length;
		int m=b.length;

		int[] c = new int[m+n];

		while(i<n &&j<m){
			if(a[i]<b[j]){
				c[k] = a[i];
				k++;
				i++;
			}
			else{
				c[k] = b[j];
				k++;
				j++;
			}
		}
		if(i<n){
			for(int p = i;p<n;p++){
				c[k] = a[p];k++;
			}

		}

		else if(j<m){
			for(int p = j;p<m;p++){
				c[k] = b[p];k++;
			}
		}
		return c;	


	}
	public static int fact(int n) {
		if(n==0){
			return 1;
		}
		int ans = n*fact(n-1);
		return ans;

	}





	public static void  bubbleSort(int[] input){

		for(int i = 0; i < input.length - 1; i++){
			for(int j = 0; j < input.length - 1 - i; j++){
				if(input[j] > input[j + 1]){
					int temp = input[j];
					input[j]  = input[j + 1];
					input[j + 1] = temp;
				}
			}
		}
	}

	public static void selectionSort(int[] input){
		for(int i = 0; i< input.length - 1; i++){
			int min = input[i];
			int minPos = i;
			for(int j = i + 1; j < input.length; j++){
				if(input[j] < min){
					min = input[j];
					minPos = j;
				}
			}
			if(minPos != i){
				int temp = input[i];
				input[i] = input[minPos]; // min
				input[minPos] = temp;
			}
		}
	}

	public static int binarySearch(int[] input, int num){

		int start = 0;
		int end = input.length - 1;
		int mid;
		while(start <= end){
			mid = (start + end) / 2;
			if(input[mid] == num ){
				return mid;
			}else if(input[mid] > num){
				end = mid - 1;
			}else{
				start = mid + 1;
			}
		}
		return -1;
	}
	
	public static  int[] merge(int[] input1, int[] input2, int[] output){
//		int output[] = new int[input1.length + input2.length];

		int i = 0, j = 0, k = 0;
		while(i < input1.length && j < input2.length){
			if(input1[i] > input2[j]){
				output[k] = input1[i];
				i++;
				k++;
			}else{
				output[k] = input2[j];
				k++;
				j++;
			}
		}
		while(i < input1.length){
			output[k++] = input1[i++];
		}
		while(j < input2.length){
			output[k++] = input2[j++];
		}
		return output;
	}
	
	public static void mergeSort(int[] input){
		if(input.length <= 1){
			return;
		}
		int mid = input.length / 2;
		int part1[] = new int[mid];
		int part2[] = new int[input.length - mid];
		for(int i = 0; i < part1.length; i++){
			part1[i] = input[i];
			//			k++;
		}
		for(int i = 0; i < part2.length; i++ ){
			part2[i] = input[mid + i];
		}
		mergeSort(part1);
		mergeSort(part2);
		merge(part1, part2, input);
//		int[] output = merge(part1, part2);
//		for(int i = 0; i < output.length; i++){
//			input[i] = output[i];
 
//		}
//		
	}


	public static void printArray(int[] input){
		for(int i = 0; i < input.length; i++){
			
			System.out.print(input[i] +" ");
		}
		System.out.println();
	}

	

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		int[] arr1 = {1,6,2,8,0,5};
//		//		int[] arr2 = {1,4,6};
//		//		int[] ans = merge(arr1, arr2);
//		mergeSort(arr1);
//		printArray(arr1);
//		//		selectionSort(arr);
//		//		bubbleSort(arr);
//		//		printArray(arr);
//	}
//
//}




	public static int Find(int num, int sI) {



		int length = (int) Math.log10(num) + 1;

		if(sI>=length){
			return 0;
		}

		int[] a = new int[length];
		int temp = num;
		int c=0;int ans,i=0;
		while(temp!=0)
		{
			a[i]=temp%10;
			temp/=10;
			i++;
		}

		for(i=0;i<length/2;i++)
		{
			int temp1 = a[i];
			a[i] = a[length-i-1];
			a[length-i-1] = temp1;
		}

		for(i=sI;i<length;i++){
			if(a[sI]<a[i]){
				c++;
			}
		}
		ans = c* fact(length-sI-1);

		return ans + Find(num, sI+1);

	}

	public static void split() {

	}

	public static void main(String[] args) {
		
		int[] arr1 = {1,6,2,8,0,5};
		mergeSort(arr1);
		for(int i:arr1){
			System.out.println(i);
		}
		// TODO Auto-generated method stub
		//		
		//		int[] a = {1,5};
		//		int[] b = {1,25};
		//		int[] ans = SortedMerge(a, b);
		//		int length = (int) Math.log10(1234) + 1;

//		System.out.println(Find(2143,0));
		//		for (int i =0 ;i<ans.length;i++){
		//			System.out.println(ans[i]);
		//		}
		//		
	}

}
