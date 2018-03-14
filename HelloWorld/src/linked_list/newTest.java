package linked_list;
import java.io.*;
import java.util.StringTokenizer;

public class newTest {

	
	/* Signature of four required functions is given in the code. You can create other functions as well if you need.
	*  Also you should submit your code even if you are not done with all the functions. 
	*/

	// Main used internally is shown here just for your reference.
	/*public static void main(String[] args) {
			Scanner s = new Scanner(System.in);
			int n = s.nextInt();
			int degree1[] = new int[n];
			for(int i = 0; i < n; i++){
				degree1[i] = s.nextInt();
			}
			int coeff1[] = new int[n];
			for(int i = 0; i < n; i++){
				coeff1[i] = s.nextInt();
			}
			Polynomial first = new Polynomial();
			for(int i = 0; i < n; i++){
				first.setCoefficient(degree1[i],coeff1[i]);
			}
			n = s.nextInt();
			int degree2[] = new int[n];
			for(int i = 0; i < n; i++){
				degree2[i] = s.nextInt();
			}
			 int coeff2[] = new int[n];
			for(int i = 0; i < n; i++){
				coeff2[i] = s.nextInt();
			}
			Polynomial second = new Polynomial();
			for(int i = 0; i < n; i++){
				second.setCoefficient(degree2[i],coeff2[i]);
			}
			int choice = s.nextInt();
			Polynomial result;
			switch(choice){
			// Add
			case 1: 
				 result = first.add(second);
				result.print();
				break;
			// Subtract	
			case 2 :
				 result = first.subtract(second);
				result.print();
				break;
			// Multiply
			case 3 :
				 result = first.multiply(second);
				result.print();
				break;
			}

		}
	  */

	public class Polynomial {

		
		/* This function sets coefficient for a particular degree value, if degree is not there in the polynomial
		 *  then corresponding term(with specified degree and value is added int the polynomial. If the degree
		 *  is already present in the polynomial then previous coefficient is replaced by
		 *  new coefficient value passed as function argument
		*/
		Node poly;
		
		public Polynomial() {
			poly = null;
		}
		
		public Polynomial(BufferedReader br) throws IOException {
			String line;
			StringTokenizer tokenizer;
			float coeff;
			int degree;
			
			poly = null;
			
			while ((line = br.readLine()) != null) {
				tokenizer = new StringTokenizer(line);
				coeff = Float.parseFloat(tokenizer.nextToken());
				degree = Integer.parseInt(tokenizer.nextToken());
				poly = new Node(coeff, degree, poly);
			}
		}
	    
		public void setCoefficient(int degree, int coeff){
//	         this.coeff  = coeff;
//	 		this.degree = degree;
		}
		
		// Prints all the terms(only terms with non zero coefficients are to be printed) in increasing order of degree. 
		public void print(){
			
		}
		
		private Node addInsert(Node ins, Node list){
			Node temp = new Node(ins.term.coeff, ins.term.degree, null);
					
			//if list is empty GOOD
			if(list==null){
				return temp;
			}
																													//Ian Lozinski
			else{			
			Node curr = list;
			Node prev = null;

			//traverses list. if greater than, move on. 
			//if equal, make new node with added coeffs
			//if less, inserts before it (aka, prev.next)
			while(curr!=null)
				if(temp.term.degree>curr.term.degree){					
					if(curr.next==null){
						curr.next=temp;
						return list;
					}
					prev=curr;
					curr=curr.next;
				}
				else if(temp.term.degree==curr.term.degree){
					if(curr.term.coeff+temp.term.coeff==0){
						if(prev==null)
							return curr.next;
						else{
							prev.next=curr.next;
							return list;}
					}
					if(prev==null)
						list = new Node(curr.term.coeff+temp.term.coeff, curr.term.degree, curr.next);
					else{
						prev.next= new Node(curr.term.coeff+temp.term.coeff, curr.term.degree, curr.next);
					}
					return list;				
				}
				else if(temp.term.degree<curr.term.degree){				
					temp.next=curr;
					prev.next=temp;
					return list;
				}	
			}		
			return null;	
		}
			

		
		// Adds two polynomials and returns a new polynomial which has result
		public Polynomial add(Polynomial p)
		{
	     	Node sumaaa = null;
			Node curr = this.poly;
			Node currp = p.poly;
			
			//fills sumaaa with nodes from curr
			while(curr!=null){
				sumaaa = addInsert(curr, sumaaa);
				curr=curr.next;
			}
		
			//fills sumaaa with nodes from currp
			while(currp!=null){
				sumaaa = addInsert(currp,sumaaa);
				currp=currp.next;
			}
			Polynomial sum = new Polynomial();
			sum.poly=sumaaa;
			return sum;		
		}
		
		// Subtracts two polynomials and returns a new polynomial which has result
		public Polynomial subtract(Polynomial p)
		{
		
		}
		
		// Multiply two polynomials and returns a new polynomial which has result
		public Polynomial multiply(Polynomial p){
			
			Node fact1 = this.poly;
			Node fact2 = p.poly;
			Node t = null;
			Node prod = null;																														//Ian Lozinski
			Polynomial product = new Polynomial();

			while(fact1!=null){
				while(fact2!=null){
					t = new Node(fact1.term.coeff*fact2.term.coeff,
							 fact1.term.degree+fact2.term.degree, null);
					fact2=fact2.next;
					prod = addInsert(t, prod);
				}
				fact1=fact1.next;
				fact2=p.poly;
			}
			product.poly=prod;
			return product;
		}

	}
	 
		
		 class Node {

		Term term;
		Node next;
		
		public Node(float coeff, int degree, Node next) 
		{
			term = new Term(coeff, degree);
			this.next = next;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
