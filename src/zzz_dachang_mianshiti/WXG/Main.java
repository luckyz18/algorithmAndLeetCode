package zzz_dachang_mianshiti.WXG;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    int value;
    Main next;

    public Main(int value, Main next) {
        this.value = value;
        this.next = next;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Main head1 = null;
        Main cur1 = null;
        for (int i = 0; i < n; i++) {
            int tmp = scanner.nextInt();
            if (head1 == null && cur1 == null ) {
                head1 = new Main(tmp, null);
                cur1 = head1;
            } else {
                cur1.next = new Main(tmp,null);
                cur1 = cur1.next;
            }
        }

        int m = scanner.nextInt();
        Main head2 = null;
        Main cur2 = null;
        for (int i = 0; i < m; i++) {
            int tmp = scanner.nextInt();
            if (head2 == null && cur2 == null ) {
                head2 = new Main(tmp, null);
                cur2= head2;
            } else {
                cur2.next = new Main(tmp,null);
                cur2 = cur2.next;
            }
        }

        List list  = getSameNode(head1,head2);
        for (int i = 0; i <list.size() ; i++) {
            System.out.print(list.get(i)+ " ");
        }
    }

    private static List getSameNode(Main head1, Main head2) {
        if (head1== null || head2 == null){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        Main p = head1;
        Main q = head2;
        while (p!= null && q!= null){
            if (p.value == q.value){
                list.add(p.value);
                p = p.next;
                q = q.next;
            }else if (p.value < q.value){
                q = q.next;
            }else if (p.value > q.value){
                p = p.next;
            }

        }
        return list;

    }
}
