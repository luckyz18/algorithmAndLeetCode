package zzz_dachang_mianshiti.bytedance;


import java.util.LinkedList;
import java.util.List;

// 大数相减  不做多余的判断了先 简单点
// https://github.com/Temperature6/High-precision-algorithm/blob/master/main.cpp

public class String_subStraction {

    //此种方法只能计算 前面的数 >= 后面的数
    public static String  subTraction(String num1, String num2){
        List<String> num1List = new LinkedList<>();
        List<String> num2List = new LinkedList<>();
        int num1Point = num1.indexOf(".");
        int num2Point = num2.indexOf(".");
        int num1Decimal = num1.length() - num1Point - 1;
        int num2Decimal = num2.length() - num2Point - 1;
        if (num1Point > num2Point) {
            addZero(num2List, num1Point - num2Point);
        } else if (num2Point > num1Point) {
            addZero(num1List, num2Point - num1Point);
        }
        addStr(num1List, num1);
        addStr(num2List, num2);
        //小数部分对齐
        if (num1Decimal < num2Decimal){
            addZero(num1List, num2Decimal - num1Decimal);
        } else if (num1Decimal > num2Decimal){
            addZero(num2List, num1Decimal - num2Decimal);
        }
        //执行减法
        boolean negtive = false;  // 最终是一个负数
        int tmp = 0;
        StringBuilder result = new StringBuilder();
        for (int i = num1List.size() -1; i >= 0 ; i--) {
            if (num1List.get(i) .equals( ".")){
                result.append(".");
                continue;
            }
            int number1 = Integer.parseInt(num1List.get(i));
            int number2 = Integer.parseInt(num2List.get(i));
            if (number2 <= number1) {
                tmp = number1 - number2;
            } else {
                if (i == 0) {
                    negtive = true;
                    break;
                } else {
                    tmp = number1 + 10 - number2;
                    if (num1List.get(i-1).equals(".")){
                        num1List.set(i - 2, Integer.parseInt(num1List.get(i - 2)) - 1 + "");
                    } else {
                        num1List.set(i - 1, Integer.parseInt(num1List.get(i - 1)) - 1 + "");
                    }
                }
            }
            result.append(tmp);
        }
        result.reverse();
        if (negtive){
            //重新计算 大的在前 小的在后
            return "-" + subTraction(num2,num1);
        }
        //去掉前缀0
        String out  = filterZero(result);
        return out;
    }

    private static String filterZero(StringBuilder result) {
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i)=='0' && !(result.charAt(i) == '.')){
                continue;
            }
            if (result.charAt(i) == '.'){
                return result.substring(i-1,result.length());
            }
        }
        return result.toString();
    }

    private static void addStr(List<String> num1List, String num1) {
        for (int i = 0; i < num1.length(); i++) {
            num1List.add(num1.charAt(i)+"");
        }
    }

    private static void addZero(List<String> num1List, int i) {
        for (int j = 0; j < i; j++) {
            num1List.add("0");
        }
    }

    public static void main(String[] args) {
        String s = subTraction( "12.3","12.20");
        System.out.println(s);
    }

}
