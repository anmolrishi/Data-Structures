package trees;

import java.util.ArrayList;
import java.util.Collections;

import stacks_and_queues.QueueUsingLL;

public class LargestMultipleOf3 {
	
	
public static ArrayList<Integer> largestMultiple3(ArrayList<Integer> input) {
	
	QueueUsingLL<Integer> q0 = new QueueUsingLL<>();
	QueueUsingLL<Integer> q1 = new QueueUsingLL<>();
	QueueUsingLL<Integer> q2 = new QueueUsingLL<>();
	// Write your code here
	
	
	int i, sum;
    for ( i = 0, sum = 0; i < input.size(); ++i )
    {
        sum += input.get(i);
        if ( (input.get(i) % 3) == 0 )
            q0.enqueue(input.get(i));
        else if ( (input.get(i) % 3) == 1 )
        	q1.enqueue(input.get(i));
        else
            q2.enqueue(input.get(i));
    }
    
    if ( (sum % 3) == 1 )
    {
        // either remove one item from queue1
        if ( !q1.isEmpty() )
            q1.dequeue();
 
        // or remove two items from queue2
        else
        {
            if ( !q2.isEmpty() )
                q2.dequeue();
            else
                return null;
 
            if ( !q2.isEmpty() )
                q2.dequeue();
            else
                return null;
        }
    }
 
    // Step 4.3: The sum produces remainder 2
    else if ((sum % 3) == 2)
    {
        // either remove one item from queue2
    	 if ( !q2.isEmpty() )
             q2.dequeue();
 
        // or remove two items from queue1
        else
        {
        	 if ( !q1.isEmpty() )
                 q1.dequeue();
            else
                return null;
 
        	 if ( !q1.isEmpty() )
                 q1.dequeue();
            else
                return null;
        }
    }
    
    ArrayList<Integer> ans = new ArrayList<>();
    
    while ( !q0.isEmpty() )
        ans.add(q0.dequeue());
    	
    while ( !q1.isEmpty() )
        ans.add(q1.dequeue());
    
    while ( !q2.isEmpty() )
        ans.add(q2.dequeue());
    
    Collections.sort(ans);
    Collections.reverse(ans);
    
    return ans;
    
}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> leaves = new ArrayList<>();
		leaves.add(8);
		leaves.add(9);
		leaves.add(1);
		leaves.add(7);
		
		ArrayList<Integer> a = largestMultiple3(leaves);
		for (int i=0;i<a.size();i++){
			System.out.println(a.get(i));
		}
	}

}
