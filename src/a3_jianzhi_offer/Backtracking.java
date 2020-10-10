package a3_jianzhi_offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 回溯一类问题
 */
public class Backtracking {
    /**
     * 子集问题   求一个数组的子序列
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    /**
     * 子集  求一个数组的子序列
     * contains duplicate
     */
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);  //进行了排序
        subBacktrackWithDup(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void subBacktrackWithDup(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            //因为前面做了排序 所以跟前面一个数进行比较
            if (i > start && nums[i] == nums[i - 1])
                continue; // skip duplicates
            tempList.add(nums[i]);
            subBacktrackWithDup(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }


    /**
     * 全排列
     * 不包含重复元素的问题
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrackPermute(list, new ArrayList<>(), nums);
        return list;
    }

    private static void backtrackPermute(List<List<Integer>> list, List<Integer> tempList, int[] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i]))  //前提： 不包含重复的元素
                    continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrackPermute(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> k = subsets(new int[]{1,2,3});
        System.out.println();
    }



    //---------------------- contains duplicate

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrackUnique(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private void backtrackUnique(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                    continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrackUnique(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    //----------------------------------------------
    //另一种全排列解法
    public static void printAllPermutations11(String str) {
        char[] chs = str.toCharArray();
        processPermutations1(chs, 0);
    }

    public static void processPermutations1(char[] chs, int i) {
        if (i == chs.length) {
            System.out.println(String.valueOf(chs));
        }
        for (int j = i; j < chs.length; j++) {
            swap(chs, i, j);
            processPermutations1(chs, i + 1);
            swap(chs, i, j);
        }
    }
    public static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }

    /**
     * 排列
     * 有重复
     */
    public static void printAllPermutations2(String str) {
        char[] chs = str.toCharArray();
        process2(chs, 0);
    }

    public static void process2(char[] chs, int i) {
        if (i == chs.length) {
            System.out.println(String.valueOf(chs));
        }
        HashSet<Character> set = new HashSet<>();
        for (int j = i; j < chs.length; j++) {
            if (!set.contains(chs[j])) {
                set.add(chs[j]);
                swap(chs, i, j);
                process2(chs, i + 1);
                swap(chs, i, j);
            }
        }
    }
    //----------------------------------------

    /**
     * 组合
     * 一个数组中元素的的组合等于 某值
     * （可不可以用重复的元素的区别）
     */
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrackSum(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private void backtrackSum(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain < 0)
            return;
        else if (remain == 0){
            list.add(new ArrayList<>(tempList));
        }
        else {
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                backtrackSum(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    //--------------------------------
    // can't reuse same element
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrackSum2(list, new ArrayList<>(), nums, target, 0);
        return list;

    }

    private void backtrackSum2(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0)
            return;
        else if(remain == 0) {
            list.add(new ArrayList<>(tempList));
        }
        else{
            for(int i = start; i < nums.length; i++){
                if(i > start && nums[i] == nums[i-1])
                    continue; // skip duplicates
                tempList.add(nums[i]);
                backtrackSum2(list, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }


}
