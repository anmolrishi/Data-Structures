import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Arrays;

public class POTD {

	public static String toLowercase(String inputString) {
		// Write your code here
		String lowerCase = "";
		int n=inputString.length();
		for(int i=0;i<n;i++){

			char a = inputString.charAt(i);
			if(a >= 'A' && a<='Z')
				a +=32;
			lowerCase = lowerCase + a;
		}
		return lowerCase;
	}

	public static String encryptString(String input, char k) {
		int n=input.length();
		String lowerCase = "";

		for(int i=0;i<n;i++){
			int m = k-96;
			char a = input.charAt(i);

			a +=m;
			lowerCase = lowerCase + a;
		}
		return lowerCase;
	}

	public static int partition(int[] input,int start,int end)
	{
		int pivot = input[start], count =0;
		for(int i=start;i<end;i++)
		{
			if(input[i]<pivot)
				count++;
		}

		int temp = input[start];
		input[start]= input[count+start];
		input[count+start]= temp;

		int i=start,j=end;

		while(j>count+start && i<count+start)
		{
			if(input[i]>pivot)
			{
				if(input[j]<pivot)
				{
					int temp1= input[i];
					input[i]=input[j];
					input[j]= temp1; 
					i++;j--;
				}
			}
			j--;
		}
		return count+start;
	}

	public static void quicksort(int[]input,int start,int end)
	{
		if(start>=end)
		{
			return;
		}

		int pivotindex = partition(input,start,end);
		quicksort(input,start,pivotindex-1);
		quicksort(input,pivotindex+1,end);
	}

	public static String[] subsequence(String input){
		if(input.length()==0){
			String a[] = new String[1];
			a[0] = "";
			return a;
		}

		String smallAns[] = subsequence(input.substring(1));
		String a[] = new String[2*smallAns.length];

		for (int i = 0; i<smallAns.length; i++){
			a[i] = smallAns[i];
		}
		for (int i = 0; i<smallAns.length; i++){
			a[i + smallAns.length] = input.charAt(0) + smallAns[i];
		}
		return a;

	}

	//			public static long solve(String input){
	//				long c=0;
	//				String a[] = new String[(int)Math.pow(2,input.length())];
	//				// Write your code here .
	//				a=subsequence(input);
	//				for (int i = 0; i<a.length; i++){
	//				if(a[i].length() == 3 && a[i].charAt(0)=='R' && a[i].charAt(1)=='O' && a[i].charAt(2)=='R'){
	//				    c++;
	//				}
	//			}
	//			return c;
	//			}

	public static long solve(String input) {

		long countofR = 0, countofRO = 0, countofROR = 0;
		for(int i=0;i<input.length();i++) {
			if(input.charAt(i)=='O') {
				countofRO += countofR;
			}
			else {
				countofR++;
				countofROR += countofRO;
			}
		}
		return countofROR;
	}

	public static int findMinimumSUm(int arr[][]) {
		int n = arr.length;
		int temp[][] = new int[n][n];
		temp[n-1][n-1] = arr[n-1][n-1];
		for(int i=n-2;i>=0;i--)
			temp[n-1][i] = arr[n-1][i] + temp[n-1][i+1];
		for(int i=n-2;i>=0;i--)
			temp[i][n-1] = arr[i][n-1] + temp[i+1][n-1];
		for(int i=n-2;i>=0;i--)
		{
			for(int j=n-2;j>i;j--)
				temp[i][j] = arr[i][j] + Math.min(temp[i+1][j], temp[i][j+1]);
			for(int j=n-2;j>i;j--)
				temp[j][i] = arr[j][i] + Math.min(temp[j+1][i], temp[j][i+1]);
			temp[i][i] = arr[i][i] + Math.min(temp[i+1][i], temp[i][i+1]);
		}
		return temp[0][0];
	}


	public static void palinGenerator(int n) {

		if(n>=11){
			for(int i=1;i<=9;i++){
				System.out.println(i);       
			}


			for(int i=11;i<=n;i+=11){
				System.out.println(i);
			}
		}

		else{
			while(n != 0){
				System.out.println(n--);
			}
		}


	}

	public static String swapWords(String input, String word1, String word2) {
		ArrayList<String> ans = new ArrayList<>();
		int endIndex=0,startIndex=0;
		for(int i=0;i<input.length();i++){
			if(input.charAt(i)==' '){
				endIndex = i;
			}
			ans.add(input.substring(startIndex, endIndex));
			startIndex = endIndex;
		}



		return ans;

	}

	public static int func(int x) {
		//march 11
		int j=1;
		int f=1;
		while(f%x != 0){
			f=1;
			for(int i=1;i<=j;i++){
				f*=i;
			}	
			j++;
		}
		return --j;

	}

	public static void decimalToHex(long n) {
		long temp=n;

		while(temp>=16){
			int digit = (int)(temp/16);
			if(digit!=0){
				if(digit<10)
					System.out.print((int)hexa(digit));
				else
					System.out.print(hexa(digit));
			}

			temp = temp%16;
		}

		if(temp!=0)
			System.out.print(hexa((int)temp));
	}




	private static char hexa(int digit) {
		// TODO Auto-generated method stub
		if(digit<=9){
			return (char) digit;
		}
		else if(digit>9 && digit<16){
			switch(digit){
			case 10 : return 'A';
			case 11 : return 'B';
			case 12 : return 'C';
			case 13 : return 'D';
			case 14 : return 'E';
			case 15 : return 'F';

			}

		}
		else{
			decimalToHex(digit);
		}

		return ' ';
	}
	public static int findMaxPlus(int[][] matrix) { 
		int k, i, j, max = 0, temp1 = 0, temp2 = 0; 
		if(matrix.length < 3 || matrix[0].length < 3) 
			return 0; 
		if(matrix.length % 2 == 0) {
			i = (matrix.length - 1) / 2; 
			j = matrix.length / 2; } 
		else { i = j = matrix.length / 2; } 
		for(; i > 0; i--, j++) {
			for(k = 1; k < matrix[0].length-1; k++){
				temp1 = func(matrix, i, k); 
				if(i != j) temp2 = func(matrix, j, k); 
				if(temp1 > max) max = temp1; if(temp2 > max) max = temp2; if(max == i) return max; } } return max; }

	private static int func(int[][] matrix, int i,int j) { if(!((j-1)>-1&&(j+1)<matrix[0].length)) { return 0; } if(!(matrix[i][j-1]==1&&matrix[i][j+1]==1)) return 0; int k=1; while(i+k<matrix.length&&i-k>-1) { if(matrix[i+k][j]==1&&matrix[i-k][j]==1) { k++; } else break; } return k-1; }
	//	Shuffle

	public static String bigFactorial(int num){ 
		int size = 160000; 
		int ans[] = new int[size]; 
		int i = 1; 
		ans[size-1] = 1; 
		while(i <= num){ 
			int carry = 0; 
			for(int j = ans.length-1; j>=0;j--){ 
				int value = ans[j]*i + carry; 
				ans[j] = value % 10; 
				carry = value / 10; 
			} 
			i++; 
		} 
		String result = ""; 
		int flag=-1; 
		for(int j = 0; j < ans.length; j++){ 
			if(ans[j] != 0){ 
				flag = 1; 
			} 
			if(flag==1){ 
				result+=ans[j]; 
			} 
		} 
		return result; 
	}





	public static void shuffleA(int noOfBits, int firstNumber, int secondNumber) {
		int no_Of_Bits_First = Integer.bitCount(firstNumber);
		int no_Of_Bits_Second = Integer.bitCount(secondNumber);
		int totalBits = no_Of_Bits_First+no_Of_Bits_Second;
		if(totalBits>noOfBits){
			totalBits = noOfBits-(totalBits-noOfBits);
		}

		System.out.println(((1<<totalBits)-1)<<(noOfBits-totalBits));

	}



	//prime sum - Given an even number N, you need to print pairs of all prime numbers whose sum is N.

	public static void printPrimeNumberSumToN(int n){

		int[] prime = new int[n+1];
		prime[0] = 0;
		prime[1] = 0;
		for(int i =2; i <= n; i++){
			prime[i] = 1;
		}
		int sqrt = (int)Math.sqrt(n);
		for(int i =0; i <= sqrt; i++){
			if(prime[i] == 1){
				for(int j = 2*i; j <=n; j=j+i){
					prime[j] = 0;
				}
			}
		}

		for(int i = 2; i <= n/2; i++){
			if(prime[i] == 1){
				if(prime[n - i] == 1){
					if((n - i) < i){
						System.out.println((n - i) +" " + i);
					}else{
						System.out.println(i +" " + (n - i));
					}
				}
			}
		}
	}



	public static int maxValue(int array[]){
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < array.length; i++) {
			list.add(array[i]);
		}
		int maxAns = Collections.max(list);

		for (int i = 1; i < array.length; i++) {
			if(array[i]==maxAns){
				array[i]=0;
				break;
			}
		}
		return maxAns;


	}

	public static void lemonade() {
		Scanner scan = new Scanner(System.in); 
		int ans = 0; 
		int n = scan.nextInt(); 
		int m = scan.nextInt(); 
		int helper[] = new int[1000001]; 

		for (int j = 0; j < m; j++) { 
			helper[scan.nextInt()]++; 
		} for (int j = 0; j < n; j++) { 
			int c = scan.nextInt(); 
			int arr[] = new int[c]; 
			for (int k = 0; k < c; k++) { 
				arr[k] = scan.nextInt(); 
			} if (helper[j] != 0) { 
				Arrays.sort(arr); 
				int point = 0; 
				while (arr.length - 1 - point >= 0 && helper[j] > 0) { 
					ans = ans + arr[arr.length - 1 - point]; 
					helper[j]--; point++; 
				} 
			} 
		} System.out.println(ans);
	}

	public static int findDifference(int[] input){
		int EvenSum=0;
		int OddSum=0;
		int i=0;
		while(i<input.length){
			if(i%2==0){
				EvenSum+=input[i];
			}else if(i%2==1){
				OddSum+=input[i];
			}
			i++;
		}

		return EvenSum-OddSum;
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
		 * Taking input and printing output is handled automatically.
		 */	

	}

	public static int minValue(int array[]){
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < array.length; i++) {
			list.add(array[i]);
		}
		int maxAns = Collections.min(list);


		return maxAns;


	}



	public static int findGcd(int[] input){

		int smallest = minValue(input);
		while (smallest > 1) {

			int counter = 0;
			int modTot = 0;

			while (counter < input.length) {

				modTot += input[counter] % smallest;
				counter++;

			}

			if (modTot == 0) {
				//Return the gcd if any
				return smallest;
			}

			//System.out.print(" "+ smallest);
			smallest--;

		}
		return 1;

		//		int gcd=2;
		//	
		//		int min = minValue(input);
		//		if(min==1){
		//			return 1;
		//		}
		//		while(gcd<=min){
		//			int i=0;
		//			while(i<input.length){
		//				if(input[i]%gcd!=0){
		//					gcd++;
		//					break;
		//				}
		//				i++;
		//			}
		//			if(i==input.length){
		//				break;
		//			}
		//		}
		//		if(gcd>min){
		//			return 1;
		//		}
		//		return gcd;

	}

	public static String nextPalindrome(String input) { 
		int f[] = new int[26]; 
		for(int i = 0; i < input.length(); i++) { 
			int index = input.charAt(i) - 'a'; f[index]++; } 
		int countOdd = 0; 
		for(int i = 0; i < 26; i++) { 
			if(f[i] % 2 != 0) { 
				countOdd++; } 
		} 
		if(input.length() % 2 == 0 && countOdd != 0) { 
			return ""; } 
		if(input.length() % 2 != 0 && countOdd != 1) { 
			return ""; } 
		char temp[] = input.toCharArray(); 
		Arrays.sort(temp); 
		String inputNew = ""; 
		for(char i : temp) { 
			inputNew += i; } 
		String output1 = "", output2 = "", output = ""; 
		for(int i = 0; i < inputNew.length();) { 
			int index = inputNew.charAt(i) - 'a'; 
			int count = f[index]; 
			if(count % 2 == 0) { 
				output1 += inputNew.substring(i, i+(count/2)); 
				output2 = inputNew.substring(i, i+(count/2)) + output2; }
			else { output = inputNew.substring(i, i+count); } i += count; } 
		String ans = output1 + output + output2; 
		return ans; 
	}
	//XOR count
	public static int count(int n) { int count = 0, p, i = 0; while(n != 0) { p = n%2; n = n/2; if(p == 0) count += Math.pow(2,i); i++; } return count; }
	//	same avg
	public static void findSubArray(int[] array) { int i, sum1 = 0, count = 0, avg = 0; for(i = 0; i < array.length; i++) { avg += array[i]; } avg = avg / array.length; ArrayList<Integer> a = new ArrayList<Integer>(); a.add(count); for(i = 0; i < array.length; i++){ sum1 += array[i]; count++; if(sum1 / (count) == avg) { a.add(i); count = 0; sum1 = 0; } } if(a.get(a.size() - 1) != array.length-1 || a.size() == 2) { System.out.println("NOT POSSIBLE"); return; } for(i = 1; i < a.size(); i++) { System.out.println(a.get(i - 1) + " " + a.get(i)); a.set(i, a.get(i) + 1); } }
	//	c++ k negotitations
	//	int MaximiseSumafterKnegations(int input[], int size, int k) { //Loop runs k times while(k--) { int min = INT_MAX, pos = -1; //In every iteration, it checks for the minimum element of the array and replaces it with its negative value for(int i = 0; i < size; i++) { if(min > input[i]) { min = input[i]; pos = i; } } input[pos] = -input[pos]; } //Calculate the sum after k negations and return sum int sum = 0; for(int z = 0; z < size; z++) sum += input[z]; return sum; }

	//	pair differs
	public static int count(int[] a, int k) { int ans = 0; for (int i = 0; i < a.length - 1; i++) { for (int j = i + 1; j < a.length; j++) { int xor = a[i] ^ a[j]; if (k == bitcount(xor)) ans += 1; } } return ans; } public static int[] binary(int a) { if (a == 0) { int b[] = new int[0]; return b; } int b = a % 2; int c[] = binary(a / 2); int d[] = new int[c.length + 1], k = 0; for (int i = 0; i < c.length; i++) { d[k] = c[i]; k++; } d[k] = b; return d; } private static int bitcount(int n) { int count = 0; int a[] = binary(n); for (int i = 0; i < a.length; i++) { if (a[i] == 1) count++; } return count; }

	//	permuted rows
	public static ArrayList<Integer> check(int[][] a, int k,int n,int m) { HashMap<Integer, Integer> map=new HashMap<>(); ArrayList<Integer> ans=new ArrayList<>(); for(int i=0;i<a[k].length;i++) { if(map.containsKey(a[k][i])) { int oldvalue=map.get(a[k][i]); map.put(a[k][i], oldvalue+1); } else map.put(a[k][i], 1); } for(int i=0;i<m;i++) { boolean flag=true; for(int j=0;j<n;j++) { if(i!=k) { if(!map.containsKey(a[i][j])) { flag=false; break; } } } if(flag==true&&i!=k) ans.add(i); } return ans; }
	//	cats and dogs
	public static void checkCounting(long c, long d, long l) { if (d * 4 + c * 4 < l){ System.out.println("no"); } else if (d * 4 > l){ System.out.println("no"); } else { long value = l - d * 4; if (value % 4 != 0){ System.out.println("no"); } else { value /= 4; long dif = (c - value); dif = dif - d * 2; if (dif > 0){ System.out.println("no"); } else{ System.out.println("yes"); } } } }
	//pascals triangle
	//	public static void pascalsTriangle(int n) { int lastRow[] = {1, 1}; int mod = 1000000000 + 7; int row = 1; while(row <= n) { // Print spaces for(int i = 1; i <= n-row; i++) { System.out.print(" "); } // Print elements if(row == 1) { System.out.println("1"); } else if(row == 2) { System.out.println("1 1"); } else { int currentRow[] = new int[lastRow.length + 1]; currentRow[0] = 1; currentRow[currentRow.length - 1] = 1; System.out.print("1 "); for(int i = 0; i < lastRow.length-1; i++) { long temp = lastRow[i] * 1l + lastRow[i+1]; currentRow[i+1] = (int) (temp % mod); System.out.print(currentRow[i+1] + " "); } System.out.println("1"); lastRow = currentRow; } row++; } }
	//	delete occurances
	//		public static Node<Integer> deleteElement(Node<Integer> head, int elem){ if(head == null){ return head; } Node<Integer> temp = head; Node<Integer> prev = null; while(temp != null){ if(temp.data.equals(elem)){ if(prev == null){ head = head.next; temp = temp.next; }else{ prev.next = temp.next; temp = temp.next; } }else{ prev = temp; temp = temp.next; } } return head; }
	//shuffle the array
	public static void shuffleArray(int input[]){ if(input.length < 3){ return; } int i = 3; while(i < input.length){ int temp = input[i - 3]; input[i - 3] = input[i]; input[i] = temp; if(i % 3 == 2){ i += 4; }else{ i++; } } }

	public static int weightOfString(String input) {

		int[] arr = new int[256];

		for (int i = 0; i < 26; i++) {
			arr['a'+i] = i+1;
		}

		arr['a']=0;
		arr['e']=0;
		arr['i']=0;
		arr['o']=0;
		arr['u']=0;

		char s[] = input.toCharArray();
		int sum=0;

		for (int j = 0; j < s.length; j++) {
			sum+=arr[s[j]];
		}

		return sum;			

	}

	public static int check(int[] input) {
		Arrays.sort(input);
		int x=0,y=0;

		for (int i = 0; i < input.length; i++) {

			if(i%2==0){
				x = x*10 + input[i];
			}
			else{
				y = y*10 + input[i];
			}

		}
		return x+y;
	}

	//		multiplayer
	public static int findWinner(int input[][]) {
		int f[] = new int[input.length]; 

		for(int i = 0; i < input.length; i++) { 
			int max = 0; 

			for(int j = 1; j < input[i].length; j++) { 
				if(input[i][j] > input[i][max]) { 
					max = j; 
				} 
			} f[i] = max; 
		} int c[] = new int[input[0].length]; 

		for(int i = 0; i < f.length; i++) {
			int index = f[i]; c[index]++; 

		} int max = 0; 

		for(int i = 1; i < c.length; i++) { 
			if(c[i] > c[max]) {
				max = i; 
			} 
		} return max; 

	}

	
//	count flips
	public static int totalFlips(int[] x1 , int[] x2 , int[] x3){
		int count = 0; 
		for(int i = 0 ; i<x1.length ; i++){
			if(x3[i] == 0){ 
				
				if(x1[i] != x2[i]){
				count++;
				
				} 
				
			} else{
				if(x1[i] == x2[i]){
					count++;
					
				} 
				
			} 
			
		}
		return count;
		
	}
	
	public static void print(int n) {
	//Write your code here
	    char d,e;
	    int b=0;
	    for(int c=n;c>=1;c--){
	        for(int i=1;i<=b;i++){
	            System.out.print(' '); 
	        }
	        
	        for(d='A'; d <= 'A'+c-1 ;d++){
	            System.out.print(d);
	        }
	        --d;
	        for( e = d ; e>='A' ; e-- ){
	            System.out.print(e);
	        }
	        System.out.println();
	        b++;
	    }
	
	}
	public static void main(String[] args) {
print(4);

		// TODO Auto-generated method stub
		//System.out.println(encryptString("abcd",'a'));

		//System.out.println(solve("RRORR"));
		//		int []a= {3,2,1};
		//		quicksort(a,0,a.length);
		//		for(int i=0;i<a.length;i++)
		//		{
		//			System.out.println(a[i]);
		//		}
		//
		//	palinGenerator(80);
		//		System.out.println(func(16));
		//		decimalToHex(1600);
		//		System.out.println(bigFactorial(50));
		//			int input[] = {13,5} ;
		//			System.out.println(findGcd(input));


		//		Scanner s = new Scanner(System.in);
		//		int m,n;
		//		n = s.nextInt();
		//		m = s.nextInt();
		//		int CodeOfRooms[] = new int[m];
		//
		//		for (int i = 0; i < CodeOfRooms.length; i++) {
		//			CodeOfRooms[i] = s.nextInt();
		//		}
		//
		//		int c[][] = new int[n][200];
		//
		//		for (int i = 0; i < c.length; i++) {
		//			c[i][0] = s.nextInt();
		//			for (int j = 1; j <= c[i][0]; j++) {
		//				c[i][j] = s.nextInt();
		//			}
		//		}
		//		int consumed=0;
		//		for (int i = 0; i < m; i++) {
		//			consumed+=maxValue(c[CodeOfRooms[i]]);
		//		}
		//
		//		System.out.println(consumed);

		//			System.out.println(weightOfString("xyuvz"));
//		int[] input = {4,3,5,7,0};
//		System.out.println(check(input));
	}

}
