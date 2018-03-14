package trie;

public class TrieUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie t = new Trie();
		t.add("Not");
		t.add("No");
		t.add("New");
		t.add("Note");
		System.out.println(t.find("No"));
		System.out.println(t.getCount());	
		t.remove("No");
		System.out.println(t.getCount());
	}

}
