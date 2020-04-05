package kaoshi.mt;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //String next = scanner.nextLine();
        int i = scanner.nextInt();
        //System.out.println(i);
        //System.out.println(next);
        List<String> list = new ArrayList<>();
        for (int j = 0; j < i ; j++) {
            //Integer l = scanner.nextInt();
            //list.add(l);
            String next = scanner.next();
            list.add(next);

        }
        for(String  m: list){
            System.out.println(m);
        }
    }
}
