package kaoshi.jd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sc = new ArrayList<>();
        List<Integer> xc = new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            sc.add(scanner.nextInt());
            xc.add(scanner.nextInt());
        }
        Collections.sort(sc);
        Collections.sort(xc);
        int m =xc.get(sc.size()-1);
        int[] maxS = new int[m];
        int[] maxX = new int[m];
        int[] ret = new int[m];
        for(int i =0; i< sc.size();i++){
            maxS[sc.get(i)]++;
        }
        for (int i = 0; i < xc.size() ; i++) {
            maxX [xc.get(i)]++;
        }
        for (int i = 0; i <maxS.length ; i++) {
            ret[i] = maxS[i] - maxX[i];
        }
        int maxPerson = 0;
        for (int i = 0; i <ret.length ; i++) {
            maxPerson = Math.max(maxPerson,ret[i]);
        }
        System.out.println(maxPerson);

    }
}
