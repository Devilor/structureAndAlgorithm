package com.ernesto.binarySearch;

import java.util.Arrays;

/**
 * @author Ernesto
 * @date 2019/12/24
 */
public class BinarySearch {
    public static void main(String[] args) {
        // int[] nums = new int[30];

        int[] nums = new int[] {1, 1, 2, 2, 3};
        // int[] nums = new int[] {3, 2, 2, 2, 1};
        int target = 2;
        /*for (int i = 0, length = nums.length; i < length; i++) {
            nums[i] = i + 1;
        }*/
        try {
            // System.out.println("nums :" + Arrays.toString(nums));
            // System.out.println(target + " 在 nums 中的位置是：" + binarySearch(nums, target));
            System.out.println(target + " 在 nums 中的最左侧位置是：" + binarySearchOfLeftFirst(nums, target));
            // System.out.println(target + " 在 nums 中的最左侧位置是：" + binarySearchOfLeftOther(nums, target));
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

    public final static int binarySearchOfLeftFirst(int[] nums, int target) {
        /**因为需要找到最左侧符合要求的数字索引，所以我们的思路是尽可能的使 high 指针往左移
         * 当 high = nums.length 的时候 二分查找的区间总会是：[low,high)
         * 由基本的二分查找分析可以知悉：第一个找到的值总回事 middle 索引位置处的数字，所以
         * 当 middle 位置的数字检测之后，总会在 [low,middle) 或者 [middle + 1,high)
         * 区间内查找，之所以能够找到最左侧符合条件的索引，是因为当检测到 middle 位置的数字符合
         * 条件的时候不要马上返回，而是继续缩小查找区间，确切的说是 high 往 low 方向移动，直到
         * high == low 即 查找到最左边符合条件的一个元素。（如果数组中存在需要查找的元素，那么
         * high 最后停留的位置的数字一定是最后要找的数字，因为数组是有序-升序排好的）
         * [3,2,2,2,1]
         *  l h
         */
        int low = 0;
        int high = nums.length;
        // int high = nums.length - 1;
        if (target > nums[high - 1] || target < nums[low]) {
            return -1;
        }
        while (low < high) {
            // while (low < high - 1) {
            int middle = (low + high) / 2;
            if (nums[middle] == target) {
                high = middle;
            } else if (nums[middle] < target) {
                low = middle + 1;
            } else if (nums[middle] > target) {
                high = middle; // 注意
            }
        }
        return low;
    }

    /**
     * 二分查找方法 Java 实现
     * ①假定目标数组中含有不唯一的 target 目标值
     * ②查找区间为闭区间 [low,high] 错误的方案，查找区间为 [low,high]，那么在判定
     * 跳出死循环的条件是：low = high + 1,由于查找最左侧的目标数值，则查找过程是 high
     * 在 nums[middle] = target 的时候一直往 low 方向移动，导致 high = low -1 low
     * 最小是 0 则 high = -1
     * ③查找最左侧的符合条件的目标值
     *
     * @param nums
     * @param target
     * @return
     */
    // public static final int binarySearchOfLeftOther(int[] nums, int target) {
    //     if (nums == null || nums.length == 0) {
    //         return -1;
    //     }
    //     int low = 0;
    //     int high = nums.length - 1;
    //     while (low <= high) {
    //         int middle = low + (high - low) >> 1;
    //         if (target < nums[middle]) {
    //             high = middle - 1;
    //         } else if (target > nums[middle]) {
    //             low = middle + 1;
    //         } else {
    //             high = middle - 1;
    //         }
    //     }
    //     return low;
    // }
}
