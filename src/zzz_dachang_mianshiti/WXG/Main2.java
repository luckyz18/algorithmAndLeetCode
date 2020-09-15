package zzz_dachang_mianshiti.WXG;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            Set<Integer> result = new HashSet();
            Set<Integer> resSet = new HashSet<>();
            resSet.add(0);
            List<Integer> zhongzi = new ArrayList<>();
            //zhongzi.add(0);
            int num = 0;
            List<List<Integer>> list = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int x = scanner.nextInt();
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < x; j++) {
                    num= scanner.nextInt();
                    if (num == 0){
                        zhongzi.add(i);
                    }
                    temp.add(num);
                }
                list.add(temp);
            }
            for (int i = 0; i < zhongzi.size(); i++) {
                List<Integer> list2 = list.get(zhongzi.get(i));
                for (int j = 0; j <list2.size() ; j++) {
                    Integer number = list2.get(j);
                    if (number != 0){
                        List<Integer> resList = new LinkedList<>();
                        resList.add(number);
                        boolean[] help = new boolean[m];
                        dfs(resList,list,help,number);
                        for (int k = 0; k <resList.size() ; k++) {
                            Integer inte = resList.get(k);
                            resSet.add(inte);
                        }
                    }
                }
            }
            System.out.println(resSet.size());
        }
    }

    private static void dfs(List<Integer> res, List<List<Integer>> list, boolean[] help,Integer num) {
        for (int i = 0; i <list.size() ; i++) {
            if (list.get(i).contains(num) && help[i] == false){
                help[i] = true;
                List<Integer> nowList= list.get(i);
                for (int j = 0; j < nowList.size() ; j++) {
                    if (nowList.get(j) != num && !res.contains(nowList.get(j))){
                        res.add(nowList.get(j));
                        dfs(res,list,help,nowList.get(j));
                    }
                }
                help[i] = false;
            }
        }
    }
}
