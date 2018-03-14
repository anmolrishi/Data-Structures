package linked_list;


public class Polynomial {

	public Term head;
	
	
	public void setCoefficient(int degree, int coeff){
		
		
		 if(this.head==null){
			 Term newTerm = new Term(coeff,degree);
			 this.head = newTerm;
			 return;
		 }
		 
		 Term temp = this.head;
		 while(temp!=null){
			if(temp.degree == degree){
				
				temp.coeff = coeff;
				return;
			}
			temp = temp.next;
		}
		
		
			Term newTerm = new Term(coeff,degree);
			
			Term ptr = this.head;
			Term prev = null;
			while(ptr!=null && ptr.degree < degree){
				prev = ptr;
				ptr = ptr.next;
			}
			if(prev==null){
				newTerm.next = head;
				this.head = newTerm;
			}
			else{
				newTerm.next = ptr;
				prev.next = newTerm;
			}
			
		}
		
	
	
	
	public void print(){
		Term temp = this.head;
		while(temp!=null){
			if(temp.coeff!=0){
				System.out.print(temp.coeff + "x" + temp.degree + " ");
			}
			
			temp = temp.next;
		}
	}
	
	
	
	public Polynomial add(Polynomial p){
        
		if(p==null){
		    return this;
		}
			
		
		Polynomial ans = new Polynomial();
		Term temp1 = this.head;
		Term temp2 = p.head;
		Term tail = null;
		ans.head = new Term(0, 0);
		
		if(temp1.degree<temp2.degree){
			ans.head = temp1;
			temp1=temp1.next;
		}else if(temp1.degree>temp2.degree){
			ans.head = temp2;
			temp2 = temp2.next;
		}
		else{
			ans.head.coeff = temp1.coeff + temp2.coeff;
			ans.head.degree = temp1.degree;
			
			temp1=temp1.next;
			temp2 = temp2.next;
		}
		tail = ans.head.next;
			
		while(temp1!=null && temp2!=null){
			
			if(temp1.degree<temp2.degree){
				tail = new Term(temp1.coeff, temp1.degree);
				temp1=temp1.next;
			}else if(temp1.degree>temp2.degree){
				tail = new Term(temp2.coeff, temp2.degree);
				temp2 = temp2.next;
			}
			else{
				tail = new Term(temp1.coeff + temp2.coeff, temp1.degree);
				temp1=temp1.next;
				temp2 = temp2.next;

			}
			tail = tail.next;
		}
		
//		if(temp1==null){
//			tail.next = temp2;
//		}
//		else
//			tail.next = temp1;
//		
		return ans;
			
	}
	
}

class Term {
    
	public int coeff;
	public int degree;
	public Term next;
	
	public Term(int coeff, int degree) 
	{
		this.coeff = coeff;
		this.degree = degree;
		next = null;
	}
	
}
