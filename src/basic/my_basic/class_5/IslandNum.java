package basic.my_basic.class_5;

public class IslandNum {
	public static int islandCount(int[][] matrix) {
		if (matrix == null || matrix[0] == null) {
			return 0;
		}
		int N = matrix.length;
		int M = matrix[0].length;
		int res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (matrix[i][j] == 1) {
					res++;
					infect(matrix,i,j,N,M);
				}
			}
		}
		
		return res;
	}

	//递归函数  感染函数
	private static void infect(int[][] m,int i, int j, int N, int M) {
		if (i < 0 || i >= N || j < 0 || j >= M || m[i][j] != 1) {  //边界条件  i是从0开始的
			return;
		}
		m[i][j] = 2;
		infect(m, i+1, j, N, M);
		infect(m, i-1, j, N, M);
		infect(m, i, j-1, N, M);
		infect(m, i, j+1, N, M);
	}
	
	public static void main(String[] args) {
		int[][] m1 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				        { 0, 1, 1, 1, 0, 1, 1, 1, 0 }, 
				        { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
				        { 0, 1, 1, 0, 0, 0, 0, 0, 0 }, 
				        { 0, 0, 0, 0, 0, 1, 1, 0, 0 }, 
				        { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
				        { 0, 0, 0, 0, 0, 0, 0, 0, 1 }, };
		System.out.println(islandCount(m1));

		int[][] m2 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
						{ 0, 1, 1, 1, 1, 1, 1, 1, 0 }, 
						{ 0, 1, 1, 1, 0, 0, 0, 1, 0 },
						{ 0, 1, 1, 0, 0, 0, 1, 1, 0 }, 
						{ 0, 0, 0, 0, 0, 1, 1, 0, 0 }, 
						{ 0, 0, 0, 0, 1, 1, 1, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
		System.out.println(islandCount(m2));

	}

}	
