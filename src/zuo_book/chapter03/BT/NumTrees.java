package zuo_book.chapter03.BT;

/**
 * 给一个中序序列有序   求出有多少种可能的二叉树形状
 * 动态规划
 */
public class NumTrees {
    //首先是一颗搜索二叉树
    public int getNumTrees(int n) {
        if (n < 2) {
            return 1;
        }
        int num[] = new int[n + 1];
        num[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j <= i; j++) {
                num[i] += (num[j-1] * num[n-j]);
            }
        }
        return num[n];
    }
}
