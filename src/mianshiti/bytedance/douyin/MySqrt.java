package mianshiti.bytedance.douyin;

/**
 * n的平方根，精度十位小数
 * 二分查找
 */
public class MySqrt {

    public static double mySqrt(int x) {
        if (x < 0) {
            return -1;
        }
        double low = 0, high = x;
        if (x < 1) {
            low = x;
            high = 1;
        }
        while (low <= high) {
            double mid = (low + high) / 2.0;
            if (Math.abs(mid * mid - x*1.0) <= 0.0000000001) {   //精度10位小数
                return mid;
            } else if (mid * mid > x) {
                high  = mid;
            } else {
                low = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        double v = mySqrt(10);
        System.out.println(v);
    }

}
