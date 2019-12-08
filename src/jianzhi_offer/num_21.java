package jianzhi_offer;


public class num_21 {
    public static void reOrderArray(int [] array) {
        if (array == null || array.length == 0){
            return;
        }
        //冒泡
        for (int i = array.length-1; i >= 0 ; i--) {
            for (int j = 0; j < i ; j++) {
                if (isEven(array[j]) && !isEven(array[j+1])){
                    swap(array,j,j+1);
                }
            }
        }
        //for (int i = 0; i <array.length ; i++) {
        //    System.out.print(array[i] +" ");
        //}
    }

    private static void swap(int[] array, int j, int i) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    //判断是否是偶数
    public static boolean isEven(int num){
        return (num & 1) == 0;
    }

    //2. O(N) 以空间换时间
    public static void reOrderArray2(int [] array) {
        if (array == null || array.length ==0){
            return;
        }
        int[] help = array.clone();
        int oddCount = 0;
        for (int i = 0; i <array.length ; i++) {
            if (!isEven(array[i])){
                oddCount++;
            }
        }
        int oddIndex =0;
        int evenIndex = oddCount;
        for (int data: help) {
            if (isEven(data)){
                array[evenIndex++] = data;
            }else{
                array[oddIndex++] = data;
            }
        }
    }


    public static void main(String[] args) {
        reOrderArray2(new int[] {1,3,5,6,8,7,2,9});
    }

}
