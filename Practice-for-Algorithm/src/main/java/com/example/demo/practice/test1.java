package com.example.demo.practice;

import java.util.Arrays;

/**
 * @author gaozijian
 * @date 2019/8/16 9:37
 */
public class test1 {

    /**
     * 3. 数组中重复的数字
     */
    public void run() {
        int[] nums = {2, 3, 4, 0, 5, 1, 3};
        int[] duplication = {0};
        duplicate(nums, nums.length, duplication);
        System.out.println(duplication[0]);
        System.out.println(Arrays.toString(nums));
    }

    private boolean duplicate(int[] nums, int length, int[] duplication) {
        if (nums == null || length <= 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    duplication[0] = nums[i];
                    return true;
                }
                swap(nums, i, nums[i]);
            }
        }
        return false;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
