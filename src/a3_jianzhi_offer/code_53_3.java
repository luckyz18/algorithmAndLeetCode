package a3_jianzhi_offer;

public class code_53_3 {
    public int getNumberSameAsIndex(int[] nums){
        if (nums == null || nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length-1;
        while (start <= end){
            int mid = (start + end )/2;
            if (nums[mid] == mid){
                return mid;
            }else if (nums[mid] > mid){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }
}
