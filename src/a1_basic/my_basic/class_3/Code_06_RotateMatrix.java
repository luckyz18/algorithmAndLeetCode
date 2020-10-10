package a1_basic.my_basic.class_3;

/*正方形矩阵 顺时针旋转矩阵 90度*/
public class Code_06_RotateMatrix {
	
	public static void rotate(int[][] matrix) {
		int tr = 0;
		int tc = 0;
		int dr = matrix.length-1;
		int dc = matrix[0].length-1;
		while(tr < dr) {
			rotateEdge(matrix,tr++,tc++,dr--,dc--); /*从外圈  到里圈*/
		}
	}

	public static void rotateEdge(int[][] matrix, int tr, int tc, int dr, int dc) {
		int times = dc - tc; 
		int tmp = 0;
		for(int i=0; i!=times;i++) {
			tmp = matrix[tr][tc+i];
			matrix[tr][tc + i] = matrix[dr-i][tc];
			matrix[dr-i][tc] = matrix[dr][dc-i];
			matrix[dr][dc-i] = matrix[tr+i][dc];
			matrix[tr+i][dc] = tmp;
		}
	}
	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length;j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		printMatrix(matrix);
		System.out.println("===============");
		rotate(matrix);
		printMatrix(matrix);
	}
}
