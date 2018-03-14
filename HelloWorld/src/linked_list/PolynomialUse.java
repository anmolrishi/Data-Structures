package linked_list;

public class PolynomialUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Polynomial p = new Polynomial();
		p.setCoefficient(0, 5);
		p.setCoefficient(10, 2);
		p.setCoefficient(6, 20);
		p.print();
		System.out.println();
		Polynomial p1 = new Polynomial();
		p1.setCoefficient(0, 5);
		p1.setCoefficient(10, 2);
		p1.setCoefficient(6, 20);
		p1.print();
		
		p1.add(p);
		
		System.out.println();
		p1.print();

	}

}
