package maps;

import java.util.ArrayList; 
import java.util.HashMap;

public class MapUse {

	public static void printIntersection(int[] arr1,int[] arr2) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for(int a:arr1){
			if(!map.containsKey(a)){
				map.put(a, 1);
			}
			else{
				int OldValue = map.get(a);
				map.put(a,OldValue+1);
			}
		}

		for(int a:arr2){
			if(map.containsKey(a) && map.get(a)>0){
				int OldValue = map.get(a);
				map.put(a,OldValue-1);
			}
		}

	}

	public static ArrayList<Integer> RemoveDuplicates(int[] input) {
		ArrayList<Integer> ans = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int a:input){
			if(!map.containsKey(a)){
				map.put(a, 1);
			}
			else{
				int OldValue = map.get(a);
				map.put(a,OldValue+1);
			}
		}

		for(int a:input){
			if(map.containsKey(a) && map.get(a)!=0){
				ans.add(a);
				map.put(a, 0);
			}

		}
		return ans;

	}

	public static void PairSumToZero(int[] input) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for(int a:input){			//Frequency table created
			if(!map.containsKey(a)){
				map.put(a, 1);
			}
			else{
				int OldValue = map.get(a);
				map.put(a,OldValue+1);
			}
		}

		for(int a:input){
			if(map.containsKey(a) && map.containsKey(-a)){
				int n = map.get(a) * map.get(-a);

				for (int i = 0; i < n; i++) {

					System.out.print(a );
					System.out.print(" , ");
					System.out.println(-a);
				}

				map.remove(a);
				map.remove(-a);
			}
		}
	}

	public static void PairSum(int[] input,int sum) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for(int a:input){			//Frequency table created
			if(!map.containsKey(a)){
				map.put(a, 1);
			}
			else{
				int OldValue = map.get(a);
				map.put(a,OldValue+1);
			}
		}

		for(int a:input){
			if(map.containsKey(a) && map.containsKey(sum-a)){
				int n = map.get(a) * map.get(-a);

				for (int i = 0; i < n; i++) {

					System.out.print(a );
					System.out.print(" , ");
					System.out.println(-a);
				}

				map.remove(a);
				map.remove(-a);
			}
		}
	}

	public static void MaxConsecutive(int[] input) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for(int a:input){			//Frequency table created
			if(!map.containsKey(a)){
				map.put(a, 1);
			}
			else{
				int OldValue = map.get(a);
				map.put(a,OldValue+1);
			}
		}
		
		int big = Integer.MIN_VALUE;
//		System.out.println("IN");
		for(int a:input){int count=0;
		
			
				while(map.containsKey(a) && map.containsKey(a++)){
					count++;
				}
				
			
			if(count>big){
				big=count;
			}
		}
		
		System.out.println("Maximum Count : " + big);
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//		int[] input = {6,1,5,3,9,6,4,6,8,4,4,4};
		//		ArrayList<Integer> answer = RemoveDuplicates(input);
		//		for(Integer i : answer){
		//			System.out.println(i);
		//		}
	//	int[] input = {6,1,6,-6,-6, -6, 6};
	//	PairSumToZero(input);
		int[] input = {15,6,10,5,2,0,3,7,1,5,6,4};
		MaxConsecutive(input);
	}

}
