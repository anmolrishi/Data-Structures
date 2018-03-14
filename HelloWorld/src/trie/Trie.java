package trie;

public class Trie {
	TrieNode root; // every dictionary should not have the same root therefore not static
	int count;

	Trie()
	{
		root = new TrieNode('\0');
	}

	public void add(String word)
	{
		add(root,word);

	}

	private void add(TrieNode root,String word)
	{

		if(word.length()==0)
		{   if(!root.isTerminating)
		{	
			root.isTerminating = true;
			count++;
			
		}
		
		return;
		}

		TrieNode child = root.children.get(word.charAt(0));

		if(child==null)
		{
			child = new TrieNode(word.charAt(0));
			root.children.put(word.charAt(0),child);
		}
		add(child,word.substring(1));
	}

	public void remove(String word)
	{
		remove(root,word);

	}

	private void remove(TrieNode root ,String word){

		if(word.length()==0)
		{    
			if(root.isTerminating)
			{
				count--;
				root.isTerminating = false;
			}
			return;
		}

		TrieNode child = root.children.get(word.charAt(0));

		if(child==null)
		{
			return;
		}

		remove(child,word.substring(1));

		if(!child.isTerminating && child.children.isEmpty())
		{
			root.children.remove(word.charAt(0));	
		}
	}

	public boolean find(String word)
	{
		TrieNode current = root;
		for(int i=0;i<word.length();i++)
		{
			TrieNode child = current.children.get(word.charAt(i));
			if(child==null)
			{
				return false;
			}
			current =child;
		}
		return current.isTerminating;		
	}

	public int getCount()
	{
		return count;
	}

}
