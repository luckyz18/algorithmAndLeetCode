package jianzhi_offer;

/**
 * 青蛙跳台阶
 */
public class code_10_2 {
    public static int JumpFloor(int target) {
        if (target <= 1) {
            return target;
        }
        int[] fab = new int[target + 1];
        fab[0] = 1;
        fab[1] = 1;
        for (int i = 2; i <= target; i++) {
            fab[i] = fab[i - 1]+ fab[i - 2];
        }
        return fab[target];
    }

    public static void main(String[] args) {
        int i = JumpFloor(2);
        System.out.println(i);
    }
}
