package basic.my_basic.class_3;

/*之字形打印矩阵*/
public class Code_08_ZipZagPrintMatrix {
	public static void printMatrixZigZag(int[][] matrix) {
		int tr = 0;
		int tc = 0; 
		int dr = 0;
		int dc = 0;
		int endR = matrix.length-1;
		int endC = matrix[0].length-1;
		boolean fromUp = true;
		while (tr != endR + 1) {
			printLevel(matrix,tr,tc,dr,dc,fromUp);
			tr = tc == endC ? tr + 1 : tr;
			tc = tc == endC ? tc : tc + 1;
			dc = dr == endR ? dc + 1 : dc;
			dr = dr == endR ? dr : dr + 1;
			fromUp = !fromUp;
		}
	}

	private static void printLevel(int[][] matrix, int tr, int tc, int dr, int dc, boolean fromUp) {
		if (fromUp) {
			while (tr != dr+1) {
				System.out.print(matrix[tr++][tc--] + " ");
			}
		}else {
			while (dr != tr-1) {
				System.out.print(matrix[dr--][dc++] + " ");
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		printMatrixZigZag(matrix);

	}
	
}
