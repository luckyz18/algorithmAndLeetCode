package jianzhi_offer;

/**
 * 二进制中1的个数
 */
public class code_15 {
    public int NumberOf1(int n) {
        int count=0;
        while (n!=0){
            count++;
            n = (n-1)&n;
        }
        return count;
    }
}
