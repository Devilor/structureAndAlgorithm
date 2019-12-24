package com.ernesto.binarySearch;

import java.util.Arrays;

/**
 * @author Ernesto
 * @date 2019/12/24
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[30];
        int target = 13;
        for (int i = 0, length = nums.length; i < length; i++) {
            nums[i] = i + 1;
        }
        try {
            System.out.println("nums :" + Arrays.toString(nums));
            System.out.println(target + " 在 nums 中的位置是：" + binarySearch(nums, target));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final static int binarySearch(int[] nums, int target) throws Exception {
        int low = 0;
        int high = nums.length - 1;
        if (target < nums[low] || target > nums[high]) {
            return -1;
        }
        while (low <= high) {
            // int middle = low + (high - low) / 2;
            /**
             * 避开 int 类型的最大值，因为 low + high 可能会很大
             * 但是 low + (high - low) >> 1 == (low + high) >> 1
             * 就是通过对 (low + high) >> 1 等价变形有意避开 low + high
             */
            // int middle = low + (high - low) >> 2;
            int middle = (low + high) >> 1;
            if (target == nums[middle]) {
                return middle;
            }
            if (target > nums[middle]) {
                low = middle + 1;
            }
            if (target < nums[middle]) {
                // 1,2,3
                high = middle - 1;
            }
        }
        return -1;
    }
}
