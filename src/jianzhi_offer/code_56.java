package jianzhi_offer;

//数组中只出现一次的数字
public class code_56 {
    public static void findNumsAppearOnce(int [] array,int num1[] , int num2[]){
        if (array == null || array.length == 0){
            return;
        }
        int resultOR =0;
        for (int tmp : array) {
            resultOR ^= tmp;
        }
        int indexOf1 = findFirstBit1(resultOR);  //找到第一个从右数是 1 的位置
        for (int i = 0; i <array.length ; i++) {
            if (isBit1(array[i], indexOf1) == 0) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
        System.out.println();
        // nums1 nums2 就是只出现一次的数
    }

    private static int findFirstBit1(int num) {
        int indexBit1 = 0;
        //位是 0
        while ( (num & 1) ==0 && (indexBit1 < 32 )){
            indexBit1 ++;
            num = num >> 1;
        }
        return indexBit1;
    }


    public static int isBit1(int num, int indexBit1){
        num = num >> indexBit1;
        return (num & 1);
    }

    //
    public void FindNumsAppearOnce2(int[] nums, int num1[], int num2[]) {
        int diff = 0;
        for (int num : nums)
            diff ^= num;
        diff &= -diff;      //能得到最左边的1表示的数值？ 11000 输出8 ？
        for (int num : nums) {
            if ((num & diff) == 0)
                num1[0] ^= num;
            else
                num2[0] ^= num;
        }
    }

    public static void main(String[] args) {
        //System.out.println(isBit1(13,2));
        //int firstBit1 = findFirstBit1(24);
        //System.out.println(firstBit1);

        //findNumsAppearOnce(new int[] {2,5,4,2,6,4},new int[1] , new int[1]);
    }
}
