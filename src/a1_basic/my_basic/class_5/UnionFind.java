package a1_basic.my_basic.class_5;

import java.util.HashMap;
import java.util.List;

public class UnionFind {
	public static class Node{
		//任意定义
		
	}
	//并查集
	public static class UnionFindSet {
		private HashMap<Node, Node> fatherMap;
		private HashMap<Node, Integer> sizeMap;
		
		public UnionFindSet(List<Node> list) {
			fatherMap  = new HashMap<Node, Node>();
			sizeMap = new HashMap<Node, Integer>();
			makeSet(list);
		}
		public void makeSet(List<Node> list) {
			fatherMap.clear();
			sizeMap.clear();
			for (Node node : list) {
				fatherMap.put(node, node);  //所有节点的父亲都是指向自己
				sizeMap.put(node, 1);  //所有节点的size都是1
				
			}
		}
		
		//查找代表节点
		public Node findHead(Node node) {
			Node father = fatherMap.get(node);
			if (father != node) {
				father = findHead(father);
			}
			fatherMap.put(node, father);  //扁平化   对查找代表节点的优化操作 查找路径上的节点的父亲都直接指向代表节点
			return father;
		}
		
		public boolean isSameSet(Node a,Node b) {
			return (findHead(a) == findHead(b));
		}
		//a所在的集合和b所在的集合 合并
		public void union(Node a, Node b) {
			if (a==null || b==null) {
				return;
			}
			Node headA = findHead(a);
			Node headB = findHead(b);
			if (headA != headB) {
				int aSetSize = sizeMap.get(headA);
				int bSetSize = sizeMap.get(headB);
				if (aSetSize < bSetSize) {
					//合并到b集合
					fatherMap.put(headA, headB);
					sizeMap.put(headB, aSetSize+bSetSize);
				}else {
					fatherMap.put(headB, headA);
					sizeMap.put(headA, aSetSize+bSetSize);
				}
			}
		}
		 
	}
	
	public static void main(String[] args) {
		
	}
	
}
