package jianzhi_offer;

public class code_53_2 {
    public static int getMissingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int len = nums.length;
        return getFirstNotEqual(nums,  0, len - 1);
    }

    private static int getFirstNotEqual(int[] nums, int start, int end) {
        if (start > end) {
            return -1;
        }
        while (start <= end){
            int mid = (start + end) / 2;
            if (nums[mid] == mid) {
                start = mid + 1;
            } else if (nums[mid] != mid && (mid > 0 && nums[mid - 1] == mid - 1) || mid == 0) {
                return mid;
            } else {
                end = mid - 1;
            }
        }
        if (start == nums.length){
            return start;
        }
        return 0;
    }

    public static void main(String[] args) {
        int m = getMissingNumber(new int[]{0});
        System.out.println(m);
    }
}
