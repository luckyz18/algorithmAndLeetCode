package mianshi.ali;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main5 {
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            String num = scanner.next();
            int k = Integer.parseInt(scanner.next());
            addOperator(num, k, "", 0, 0);
            System.out.println(result.size());
        }

    }

    private static void addOperator(String num, int target, String tmp, long cures, long prenum) {
        if (target == cures && num.length() == 0) {
            result.add(tmp);
            return;
        }


        for (int i = 1; i <= num.length(); i++) {
            String cur = num.substring(0, i);
            if (cur.length() > 1 && cur.charAt(0) == '0') {
                return;
            }
            long curNum = Long.parseLong(cur);
            String sub = num.substring(i);
            if (tmp.length() == 0) {
                addOperator(sub, target, cur, curNum, curNum);
            } else {
                addOperator(sub, target, tmp + "+" + curNum, cures + curNum, curNum);
                addOperator(sub, target, tmp + "-" + curNum, cures - curNum, -curNum);
            }

        }
    }
}
