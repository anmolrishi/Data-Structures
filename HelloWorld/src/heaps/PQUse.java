package heaps;

public class PQUse {
	
	public static void kSortedArray(int[] input, int k) {
		Priority_Queue_Max<Integer> pq = new Priority_Queue_Max<>();
		for(int i=0;i<input.length;i++){
			pq.insert(input[i], Math.abs(k-i));
		}
		
		while(!pq.isEmpty()){
			System.out.println(pq.removeMax());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	Priority_Queue_Max<Integer> pq = new Priority_Queue_Max<>();
		
		int[] arr = {8,10,6,9,5,7};
		kSortedArray(arr, 3);
//		for(int i : arr){
//			pq.insert(i, i);
//		}
		
	//	System.out.println(pq.size());
	//	System.out.println(pq.isEmpty());
		
//		while(!pq.isEmpty()){
//			System.out.println(pq.removeMax());
//		}
//		//System.out.println(pq.removeMin());

	}

}
