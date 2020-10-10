package a1_basic.my_basic.class_7;

public class Code_00_TrieTree {
	//前缀树
	public static class TrieNode{
		public int end;
		public int path;
		public TrieNode[] nexts;
		
		public TrieNode() {
			end = 0;
			path = 0;
			nexts = new TrieNode[26];   //之前没写   空指针
		}
		
	}
	
	public static class Trie{
		private TrieNode root;
		public Trie() {
			root  = new TrieNode();
		}
		
		public void insert(String word) {
			if (word == null) {
				return;
			}
			char[] chs = word.toCharArray();
			int index = 0;
			TrieNode node = root;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.nexts[index] == null) {
					node.nexts[index] = new TrieNode();
					
				}
				node = node.nexts[index];
				node.path++;
			}
			node.end++;
		}
		
		public int search(String word) {
			if (word == null) {
				return 0;
			}
			char[] chs = word.toCharArray();
			int index = 0;
			TrieNode node = root;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.nexts[index] == null) {
					return 0;
				}
				node = node.nexts[index];
			}
			return node.end;
		}
		
		public void delete(String word) {
			if (word == null) {
				return;
			}
			char[] chs = word.toCharArray();
			int index = 0;
			TrieNode node = root;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (--node.nexts[index].path == 0) {
					node.nexts[index] = null;   //后面的节点直接删去
					return;
				}
				node = node.nexts[index];
			}
			node.end--;
		}
		
		public int prefixNumber(String word) {
			if (word == null) {
				return 0;
			}
			char[] chs = word.toCharArray();
			int index = 1;
			TrieNode node = root;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.nexts[index] == null) {
					return 0;
				}
				node  = node.nexts[index];
			}
			return node.path;
		}
	}
	
	public static void main(String[] args) {
		String[] arr1 = {"abc","bcd","def","bcf"};
		String[] arr2 = {"b","a","bc"};
		Trie trie = new Trie();
		for (int i = 0; i < arr1.length; i++) {
			trie.insert(arr1[i]);
		}
		//arr2中有哪些字符，是arr1中出现的
		for (int i = 0; i < arr2.length; i++) {
			if (trie.search(arr2[i]) != 0) {
				System.out.print(arr2[i] + " ");
			}
		}
		System.out.println(" ");
		System.out.println("===================================");
		//arr2中有哪些字符，是作为arr1中某个字符串前缀出现的？
		for (int i = 0; i < arr2.length; i++) {
			if (trie.prefixNumber(arr2[i]) != 0) {
				System.out.print(arr2[i] + " ");
			}
		}
		System.out.println(" ");
		System.out.println("===================================");
		
		String res = null;
		int pre = 0;
		for (int i = 0; i < arr2.length; i++) {
			int prefixNum = trie.prefixNumber(arr2[i]);
			if (prefixNum != 0) {
				System.out.print(arr2[i] + " ");
				if(prefixNum >= pre) {
					res = arr2[i];
					pre = prefixNum;
				}
			}
		}
		System.out.println();
		System.out.println(res);
		
//		Trie trie = new Trie();
//		System.out.println(trie.search("zuo"));
//		trie.insert("zuo");
//		System.out.println(trie.search("zuo"));
//		trie.delete("zuo");
//		System.out.println(trie.search("zuo"));
//		trie.insert("zuo");
//		trie.insert("zuo");
//		trie.delete("zuo");
//		System.out.println(trie.search("zuo"));
//		trie.delete("zuo");
//		System.out.println(trie.search("zuo"));
//		trie.insert("zuoa");
//		trie.insert("zuoac");
//		trie.insert("zuoab");
//		trie.insert("zuoad");
//		trie.delete("zuoa");
//		System.out.println(trie.search("zuoa"));
//		System.out.println(trie.prefixNumber("zuo"));
		
		
	}
}
