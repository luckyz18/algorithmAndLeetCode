package a3_jianzhi_offer;

/**
 * 矩形覆盖
 */
public class code_10_4 {
    public int RectCover(int target) {
        if (target <=1){
            return target;
        }
        int fab[] = new int[target+1];
        fab[0] = 1;
        fab[1] = 1;
        for (int i = 2; i <= target ; i++) {
            fab[i] = fab[i-1]+ fab[i-2];
        }
        return fab[target];
    }
}
