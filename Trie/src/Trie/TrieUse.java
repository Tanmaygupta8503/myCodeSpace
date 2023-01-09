package Trie;

public class TrieUse {

	public static void main(String[] args) {
		Trie t = new Trie();
		t.add("news");
		t.add("at");
		System.out.println(t.search("news"));
		t.remove("news");
		System.out.println(t.search("news"));
	}
}
