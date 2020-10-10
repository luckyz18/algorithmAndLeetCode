package a1_basic.class_08;

import java.util.ArrayList;
import java.util.List;

public class Code_03_Print_All_Subsquences {

	public static void printAllSubsquence(String str) {
		char[] chs = str.toCharArray();
		process(chs, 0);
	}

	public static void process(char[] chs, int i) {
		if (i == chs.length) {
			System.out.println(String.valueOf(chs));
			return;
		}
		process(chs, i + 1);
		char tmp = chs[i];
		chs[i] = 0;
		process(chs, i + 1);
		chs[i] = tmp;
	}
	
	public static void function(String str) {
		char[] chs = str.toCharArray();
		process(chs, 0, new ArrayList<Character>());
	}
	
	public static void process(char[] chs, int i, List<Character> res) {
		if(i == chs.length) {
			printList(res);
			return;
		}
		List<Character> resKeep = copyList(res);
		resKeep.add(chs[i]);
		process(chs, i+1, resKeep);

		List<Character> resNoInclude = copyList(res);
		process(chs, i+1, resNoInclude);
	}
	
	public static void printList(List<Character> res) {
		for (char c: res) {
			System.out.print(c+" ");
		}
		System.out.println("----");
	}
	
	public static List<Character> copyList(List<Character> list){
		List k = new ArrayList();
		for(Character c : list){
			k.add(c);
		}
		return k;
	}


	/**
	 * res: 上级传送给他的
	 * chars 的第 i 个位置
	 * @param chars
	 * @param i
	 * @param res
	 */
	public static void printAllSub( char[] chars,int i,String res) {
		if (i == chars.length){
			System.out.println(res);
			return;
		}
		printAllSub(chars,i+1,res); //这个位置不保留
		printAllSub(chars,i+1,res + chars[i]);  //这个位置保留 存到res
	}

	

	public static void main(String[] args) {
		String test = "abc";
		//printAllSubsquence(test);
		//printAllSub("abc".toCharArray(),0,"");
		function("abc");
	}

}
