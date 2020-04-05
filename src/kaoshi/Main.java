package kaoshi;

import java.util.ArrayList;
public class Main {
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(matrix == null || matrix.length==0 || matrix[0].length == 0){
            return list;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int startR = 0,startC = 0,endR =row-1, endC = col-1;
        while(startR <= endR && startC <= endC) {
            printEdge(matrix,startR++,startC++,endR--,endC--,list);
        }
        return list;
    }
    public static void printEdge(int[][] matrix, int tr, int tc, int dr, int dc, ArrayList<Integer> list){
        if(tr == dr){  //只有一横
            while(tc<= dc){
                list.add(matrix[tr][tc]);
                tc++;
            }
        }else if(tc == dc){  //只有一竖
            while(tr <= dr){
                list.add(matrix[tr][tc]);
                tr++;
            }
        }else{
            int curR = tr;
            int curC = tc;
            while(curC != dc){
                list.add(matrix[tr][curC++]);
            }
            while(curR != dr ){
                list.add(matrix[curR++][dc]);
            }
            while(curC != tc){
                list.add(matrix[dr][curC--]);
            }
            while(curR != tr){
                list.add(matrix[curR--][tc]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{ {1,2},{3,4} };
        ArrayList<Integer> integers = printMatrix(m);
        for (int l : integers) {
            System.out.print(l + " ");
        }
    }
}