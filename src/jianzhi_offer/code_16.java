package jianzhi_offer;

/**
 * 数值的整数次方
 */
public class code_16 {
    public static double Power(double base, int exponent) {
        boolean isNeagtive = false;
        if (base == 0.0 ){
            return 0;
        }
        if (exponent == 0){
            return 1;
        }
        if (exponent == 1){
            return base;
        }
        if (exponent < 0){
            isNeagtive = true;
            exponent = Math.abs(exponent);
        }
        double res= Power(base,exponent >> 1);
        res *= res;
        if ((exponent & 1) ==1){
            res *= base;
        }
        return isNeagtive? 1/res : res;
    }

    public static void main(String[] args) {
        double power = Power(2, 3);
        System.out.println(power);
    }
}
