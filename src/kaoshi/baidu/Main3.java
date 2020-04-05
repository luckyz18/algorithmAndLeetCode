package kaoshi.baidu;

import java.util.*;

public class Main3 {
    static class Node {
        int val;
        Set<Node> childs;

        public Node(int val) {
            this.val = val;
        }
    }

    static Map<Integer,Node> map = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(scanner.next());
        }
        for (int i = 0; i < n - 1; i++) {
            int a = Integer.parseInt(scanner.next());
            int b = Integer.parseInt(scanner.next());
            Node aa = null;
            Node bb = null;
            if (map.containsKey(a)){
                aa = map.get(a);
            }else{
                aa= new Node(a);
            }
            if (map.containsKey(b)){
                bb = map.get(b);
            }else{
                bb= new Node(b);
            }
            aa.childs.add(bb);


        }
        //System.out.println(2);

    }
}
