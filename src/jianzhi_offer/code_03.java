package jianzhi_offer;


import sun.security.util.Length;

/**
 * 数组中重复的数字
 */
public class code_03 {
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                swap(numbers, i, numbers[i]);
            }
        }
        return false;
    }

    private void swap(int[] numbers, int i, int j) {
        int tmp = numbers[j];
        numbers[j] = numbers[i];
        numbers[i] = tmp;
    }

    // 题目二
    public static int duplicate2(int numbers[], int length) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        int start = 1;
        int end = length - 1;
        while (end >= start) {
            int mid = ((end - start) >> 1) + start;
            int count = countInRange(numbers, length, start, mid);
            if (start == end) {
                if (count > 1) {
                    return start;
                }
                else {
                    break;
                }
            }
            if (count > (mid - start + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private static int countInRange(int[] numbers, int length, int start, int mid) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] >= start && numbers[i] <= mid) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int i = duplicate2(new int[]{1,2,3,4}, 4);
        System.out.println(i);
    }

}

