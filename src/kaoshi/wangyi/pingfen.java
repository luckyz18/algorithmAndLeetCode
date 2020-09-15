package kaoshi.wangyi;

import java.util.ArrayList;
import java.util.List;

public class pingfen {

    public static void main(String[] args) {
        int[] m = new int[] {4,2};
        List<Integer> res = new ArrayList<>();
        int n = 5;
        int[] arr = new int[n+1];

        for(int i : m){
            res.add(i);
            arr[i] = 1;
        }
        for(int i = 1; i<=n;i++){
            if (arr[i] == 0){
                int len = res.size();
                boolean f = false;
                for (int j = 0; j <len ; j++) {
                    if (res.get(j) > i){
                        res.add(j,i);
                        f = true;
                        break;
                    }
                }
                if (f == false){
                    res.add(i);
                }
            }
        }
        System.out.println(res);
    }
}
