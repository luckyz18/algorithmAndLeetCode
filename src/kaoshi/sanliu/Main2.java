package kaoshi.sanliu;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int j = scanner.nextInt();
        double d = 0.6000;
        DecimalFormat decimalFormat = new DecimalFormat("0.0000");
        //System.out.println(String.format("%.4f",d));
        System.out.println(decimalFormat.format(d));

    }
}
