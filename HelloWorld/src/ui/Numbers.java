package ui;
import javax.swing.JOptionPane;
public class Numbers {

	public static void printNumbersInLexicographicalOrder(int N) {
		int i=0;
		while(i<100){
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fn = JOptionPane.showInputDialog("First NUMBER?");
		String sn = JOptionPane.showInputDialog("Second NUMBER?");
		
		int num1 = Integer.parseInt(fn);
		int num2 = Integer.parseInt(sn);
		
		int sum = num1+num2;
		JOptionPane.showMessageDialog(null, "The Answer is " + sum, "The title", JOptionPane.PLAIN_MESSAGE);
	}

}
