package kaoshi.sanliu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        int AT = 0;
        int TA = 0;
        for (int i = 0; i <c1.length ; i++) {
            if (c1[i] == 'A' && c2[i] == 'T'){
                AT++;
            }else if (c1[i] == 'T' && c2[i] == 'A'){
                TA++;
            }
        }
        if (AT > TA){
            System.out.println(AT);
        }else{
            System.out.println(TA);
        }
    }
}
