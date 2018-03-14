package oops;

public class ComplexNumbers {
	private int real;
	private int imaginary;

	public ComplexNumbers(int r, int i) {
		real=r;
		imaginary = i;
	}
	
	public void plus(ComplexNumbers c){
		this.real+=c.real;
		this.imaginary+=c.imaginary;
	}
	
	public void print() {
		System.out.println(this.real + " + i" + this.imaginary);
	}
	
	public void multiply(ComplexNumbers c) {
		int r = this.real;
		this.real = this.real*c.real - this.imaginary*c.imaginary;
		this.imaginary = this.imaginary*c.real + r*c.imaginary;
		
	}
}
