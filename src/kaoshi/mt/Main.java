package kaoshi.mt;

import javax.xml.transform.Source;
import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //String v = scanner.nextLine();
        //long a = Long.parseLong(v);

        //BigInteger a = scanner.nextBigInteger();
        //String bigA = a+"";
        String bigA = scanner.nextLine();
        String s = scanner.nextLine();

        boolean f = false;
        //if (bigA.charAt(0)=='-'){
        //    //a = Math.abs(a);
        //    bigA.replaceFirst("-","");
        //    f = true;
        //}
        String[] split = s.split(" ");
        Map<Integer,Integer> map = new LinkedHashMap<>();
        int index = 1;
        for (int i = 0; i <split.length ; i++) {
            String tmp = split[i];
            map.put(index++,Integer.parseInt(tmp));
        }
        //String StringA = String.valueOf(a);
        String res = "";
        for (int i = 0; i <bigA.length() ; i++) {
            char c = bigA.charAt(i);
            if (c == '-'){
                f = true;
                continue;
            }
            Integer num = Integer.parseInt(String.valueOf(c));
            Integer numReplace = map.get(num);
            res += (numReplace+"");
        }
        if (f== true){
            System.out.println("-"+res);
        }else{
            System.out.println(res);
        }

    }
}
