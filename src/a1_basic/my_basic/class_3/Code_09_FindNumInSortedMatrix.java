package a1_basic.my_basic.class_3;

/**
 * 从对角开始
 */
public class Code_09_FindNumInSortedMatrix {
	public static boolean isContain(int[][] matrix,int k) {
		int endR = matrix.length-1;
		int endC = matrix[0].length - 1;
		int row = endR;
		int column =  0;
		while (row > -1 && column <= endC) {
			if (matrix[row][column] == k) {
				return true;
			}else if (matrix[row][column] > k) {
				row--;
			}else {
				column++;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int matrix[][]= new int[][] {
			{ 0, 1, 2, 3, 4, 5, 6 },// 0
			{ 10, 12, 13, 15, 16, 17, 18 },// 1
			{ 23, 24, 25, 26, 27, 28, 29 },// 2
			{ 44, 45, 46, 47, 48, 49, 50 },// 3
			{ 65, 66, 67, 68, 69, 70, 71 },// 4
			{ 96, 97, 98, 99, 100, 111, 122 },// 5
			{ 166, 176, 186, 187, 190, 195, 200 },// 6
			{ 233, 243, 321, 341, 356, 370, 380 }
		};
		int k = 233;
		System.out.println(isContain(matrix,k));
	}
}
