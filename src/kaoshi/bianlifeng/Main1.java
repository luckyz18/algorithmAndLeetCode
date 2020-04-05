package kaoshi.bianlifeng;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(",");
        List<Integer> list = new LinkedList<>();

        int result =  0;
        for (int i = 0; i <split.length ; i++) {
            int a  = Integer.parseInt(split[i]);
            if (a%3 == 0){
                result += a;
            }else{
                list.add(a);
            }
        }
        Collections.sort(list);
        boolean[] flag = new boolean[list.size()];
        for (int i = list.size()-1; i >= 0 ; i--) {
            int maxNum = list.get(i);
            for (int j = i-1; j >=0 ; j--) {
                if (flag[j] == false) {
                    int subNum = list.get(j);
                    if ((maxNum + subNum) % 3 == 0) {
                        result += (maxNum + subNum);
                        //list.remove(i);
                        //list.remove(j);
                        flag[j] = true;
                        flag[i] = true;
                        break;
                    }
                }
            }
        }
        int backage = (result / 3);
        System.out.println(backage);


    }
}
