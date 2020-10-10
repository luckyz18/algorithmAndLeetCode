package kaoshi.baidu;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        BigInteger [] array = new BigInteger[n];
        for (int i = 0; i <n ; i++) {
            //String s = scanner.next();
            //array[i] = new BigInteger(s);
            array[i] = scanner.nextBigInteger();
        }

        Arrays.sort(array);
        int k= 0 ;
        while ((array[n-1].compareTo(BigInteger.valueOf(n)) == 1  )  || (array[n-1].compareTo(BigInteger.valueOf(n)) == 0  ) ){
            array[n-1]= array[n-1].subtract(BigInteger.valueOf(n));
            for (int i = 0; i <array.length-1 ; i++) {
                array[i] = array[i].add(BigInteger.valueOf(1));
            }
            k++;
            Arrays.sort(array);
        }
        System.out.println(k);
    }


    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger n = scanner.nextBigInteger();
        BigInteger subtract = n.subtract(n);
        BigInteger multiply = n.multiply(subtract);
        System.out.println(multiply);

    }*/
}
