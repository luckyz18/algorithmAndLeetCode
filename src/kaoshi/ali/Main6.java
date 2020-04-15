package kaoshi.ali;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main6 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            String num = scanner.next();
            int k = Integer.parseInt(scanner.next());
            List<String> ret = new ArrayList<>();
            //addOpe(num, k);
            addOperator(num, k, "", 0, 0, ret);
            System.out.println(ret.size());
        }

    }


    private static void addOperator(String num, int target, String tmp, long diff, long curNum, List<String> ret) {
        if (target == curNum && num.length() == 0) {
            ret.add(tmp);
            //return;
        }
        for (int i = 1; i <= num.length(); i++) {
            String cur = num.substring(0, i);
            if (cur.length() > 1 && cur.charAt(0) == '0') {
                return;
            }
            String sub = num.substring(i);
            if (tmp.length() > 0) {
                addOperator(sub, target, tmp + "+" + cur, Long.parseLong(cur), Long.parseLong(cur) + curNum, ret);
                addOperator(sub, target, tmp + "-" + cur, -Long.parseLong(cur), curNum - Long.parseLong(cur), ret);
               // addOperator(sub, target, tmp + "*" + cur, diff * Long.parseLong(cur), (curNum -diff ) + diff * Long.parseLong(cur) , ret);

            }else{
                addOperator(sub, target,  cur, Long.parseLong(cur), Long.parseLong(cur), ret);
            }
        }
    }

}
