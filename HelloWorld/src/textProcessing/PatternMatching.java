package textProcessing;

import java.util.HashMap;

public class PatternMatching {

	// worst case : aaaaaa and baa
	// Also do KMP works in O(n)
	public static int boyerMoore(String text,String pattern)
	{
		HashMap<Character, Integer>lastIndex = getLastIndices(pattern);
		for(int i=pattern.length()-1;i<text.length();)
		{
			int j=0; 
			while(j<pattern.length())
			{
				if(text.charAt(i-j)==pattern.charAt(pattern.length()-j-1))
				{
					j++;
				}
				else
				{
					char badChar = text.charAt(i-j);
					if(lastIndex.containsKey(badChar))
					{
						int index = lastIndex.get(badChar);
						if(index>pattern.length()-j-1)
						{
							i++;
						}
						else
						{
							i+=(pattern.length()-j-1)-index;
						}
					}
					else
					{
						i+=pattern.length()-j;
					}
					break;
				}
			}
			if(j==pattern.length())
			{
				return i-pattern.length()+1;
			}
		}
		return -1;
	}

	private static HashMap<Character, Integer> getLastIndices(String pattern) 
	{
		// TODO Auto-generated method stub
		HashMap<Character,Integer> map =  new HashMap<>();
		for(int i=0;i<pattern.length();i++)
		{
			char currentChar = pattern.charAt(i);
			map.put(currentChar, i);
		}
		return map;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text="aaabcabb";
		String pattern = "abd";
		System.out.println(boyerMoore(text, pattern));
	}
}