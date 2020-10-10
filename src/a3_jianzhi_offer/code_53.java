package a3_jianzhi_offer;

/**
 * 数字在排序数组中出现的次数
 */
public class code_53 {
    //二分查找变形
    public static int getFirstK(int[] array, int len, int k, int start, int end){
        if (start > end){
            return -1;
        }
        int mid = (end+start) /2;
        if (array[mid] == k){
            if (mid > 0 && array[mid-1] != k || mid == 0 ){
                return mid;
            }else{
                end = mid-1;
            }
        }else if (array[mid] < k){
            start = mid+1;
        }else{
            end = mid-1;
        }
        return getFirstK(array,len,k,start,end);  //位置下标
    }
    public static int getLastK(int[] array, int len, int k, int start, int end){
        if (start > end){
            return -1;
        }
        int mid = (end+start) /2;
        if (array[mid] == k){
            if (mid < len-1 && array[mid+1] != k || mid == len-1 ){
                return mid;
            }else{
                start = mid+1;
            }
        }else if (array[mid] < k){
            start = mid+1;
        }else{
            end = mid-1;
        }
        return getLastK(array,len,k,start,end);  //位置下标
    }

    public static int getNumberOfK(int[] array,int k){
        if (array == null || array.length ==0){
            return 0;
        }
        int count = 0 ;
        int len = array.length;
        int left = getFirstK(array,len,k,0,len-1);
        int right = getLastK(array,len,k,0,len-1);
        if (left > -1 && right > -1){
            count =  right-left+1;
        }
        return count;
    }

    public static void main(String[] args) {
        int a = getNumberOfK(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 3);
        System.out.println(a);
    }

}
