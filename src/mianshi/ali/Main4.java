package mianshi.ali;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while(T-- > 0){
            String s = scanner.next();
            StringBuffer sb= new StringBuffer(s);
            StringBuffer reverseString = sb.reverse();
            String reverS = reverseString.toString();
            char[] chars = reverS.toCharArray();
            for (int i = 0; i <chars.length; i++) {
                char aChar = chars[i];
                if (aChar == '2'){
                    chars[i] = '5';
                }else if(aChar == '5'){
                    chars[i] = '2';
                }else if(aChar == '8'){
                    chars[i] = '3';
                }else if(aChar == '3'){
                    chars[i] = '8';
                }else if(aChar == '4'){
                    chars[i] = '7';
                }else if(aChar == '7'){
                    chars[i] = '4';
                }else if(aChar == '6'){
                    chars[i] = '9';
                }else if(aChar == '9'){
                    chars[i] = '6';
                }
            }
            StringBuilder ret = new StringBuilder();
            for (int i = 0; i <chars.length ; i++) {
                ret.append(chars[i]);
            }
            if (!s.equals(ret.toString())){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }
        }
    }

}
