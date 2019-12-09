package jianzhi_offer;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 */
public class num_29 {
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList();
        if (matrix == null ) {
            return list;
        }
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR <= dR && tC <= dC) {
            printInCircle(matrix, tR++, tC++, dR--, dC--,list);
        }
        return list;
    }

    //打印一圈
    private static void printInCircle(int[][] m, int tR, int tC, int dR, int dC, ArrayList<Integer> list) {
        if (tR == dR) {
            for (int i = tC; i <= dC; i++) {
                list.add(m[tR][i]);
            }
        } else if (tC == dC) {
            for (int i = tR; i <= dR; i++) {
                list.add(m[i][tC]);
            }
        } else {
            int curC = tC;
            int curR = tR;
            while (curC != dC) {
                list.add(m[tR][curC]);
                curC++;
            }
            while (curR != dR) {
                list.add(m[curR][dC]);
                curR++;
            }
            while (curC != tC) {
                list.add(m[dR][curC]);
                curC--;
            }
            while (curR != tR) {
                list.add(m[curR][tC]);
                curR--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{  {1}  };
        ArrayList<Integer> integers = printMatrix(m);
        for (int l : integers) {
            System.out.print(l + " ");
        }
    }


}
