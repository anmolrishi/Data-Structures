package dynamic_programming;

public class EditDistance {

	public static int  editDistance(String s,String t){

		if(s.length()==0)
		{
			return t.length();
		}
		else if(t.length()==0)
		{
			return s.length();
		}

		if(s.charAt(0)==t.charAt(0))
		{
			return 	editDistance(s.substring(1), t.substring(1));
		}
		else
		{
			int option1 =  1 + editDistance(s.substring(1),t);
			// insert option
			int option2 =  1 + editDistance(s,  t.substring(1));
			// delete option
			int option3 =  1 +  editDistance(s.substring(1),t.substring(1));
			// replace option

			int min = Math.min(option1, option2);
			return Math.min(min, option3);
		}
	}

	public static long editDistanceR(String s,String t)
	{
		long storage[][]= new long[s.length()+1][t.length()+1];
		return editDistanceR(s, t,storage);

	}

	private static long editDistanceR(String s, String t, long[][] storage) {
		int m = s.length();
		int n = t.length();

		if(s.length()==0)
		{
			storage[m][n]=t.length();
			return storage[m][n];
		}
		else if(t.length()==0)
		{
			storage[m][n]=s.length();
			return storage[m][n];
		}
		
		if(storage[m][n]!=0){
			return storage[m][n];
		}

		if(s.charAt(0)==t.charAt(0)){
			return s.charAt(0)+editDistanceR(s.substring(1), t.substring(1), storage);
		}

		else
		{
			long option1 = 1 + editDistance(s.substring(1),t);
			long option2 = 1 + editDistance(s,  t.substring(1));
			long option3 = 1 +  editDistance(s.substring(1),t.substring(1));

			long min = Math.min(option1, option2);
			storage[m][n] = Math.min(min, option3);

			return storage[m][n];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(editDistanceR("abcdghcdghcghcdghc", "bcdefhcdghcdghghcdghc"));
		System.out.println(editDistance("abcdghcdghcghcdghc", "bcdefhcdghcdghghcdghc"));

	}

}