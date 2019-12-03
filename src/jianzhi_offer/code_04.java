package jianzhi_offer;

/**
 * 在排过序二维数组中查找一个k
 */
public class code_04 {
    public static boolean find(int target, int[][] array) {
        if (array.length == 0 || array[0].length == 0) {
            return false;
        }
        int row = array.length;
        int column = array[0].length;
        int startR = 0;
        int startC = column - 1;
        int endR = row - 1;
        int endC = 0;
        while (startR <= endR && startC >= endC) {
            if (array[startR][startC] == target) {
                return true;
            } else if (array[startR][startC] < target) {
                startR++;
            } else {
                startC--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] array = {{1, 3, 5, 6}, {2, 4, 7, 8}};
        boolean b = find(9, array);
        System.out.println(b);
    }
}
