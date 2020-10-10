package a1_basic.my_basic.class_3;

/*转圈打印矩阵*/
public class Code_05_PrintMatrixSpiralOrder {
	public static void spiralOrderPrint(int[][] matrix) {
		int tr = 0;
		int tc = 0;
		int dr = matrix.length-1;
		int dc = matrix[0].length-1;
		while(tr <= dr && tc <= dc) {
			printEdge(matrix,tr++,tc++,dr--,dc--);
		}
	}
	
	public static void printEdge(int[][] matrix, int tr, int tc, int dr, int dc) {
		if (tr == dr) {  /*打印一横*/
			for (int i = tc; i <= dc ; i++) {
				System.out.println(matrix[tr][i]);
			}
		}else if(tc == dc) {   /*打印一列*/
			for (int i = tr; i <= dr ; i++) {
				System.out.println(matrix[i][tc]);
			}
		}else {
			int curC = tc;
			int curR = tr;
			
			while (curC != dc) {
				System.out.print(matrix[tr][curC] + " ");
				curC++;
			}
			while (curR != dr) {
				System.out.print(matrix[curR][dc] + " ");
				curR++;
			}
			while(curC != tc) {
				System.out.print(matrix[dr][curC] + " ");
				curC--;
			}
			while(curR != tr) {
				System.out.print(matrix[curR][tc] + " ");
				curR--;
			}
			
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		spiralOrderPrint(matrix);
	}
}
