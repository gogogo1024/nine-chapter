package com.woodcut;

public class Solution {

    /*
     一堆长短不一的木头，需要切割出相同长度的最少k段，计算切得的木头最长长度
     例如：
      输入： L = [232,124,456]，k = 7
      输出：114
     */

    /**
     * @param nums 木头长度数组
     * @param k    k段
     * @return 每段木头的最长长度
     */
    public int findMax(int[] nums, int k) {
        int left = 1, right = maxNum(nums);
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (isValid(nums, mid, k)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (isValid(nums, left, k)) {
            return left;
        }
        return right;
    }

    /**
     * 求和
     *
     * @param nums 数字数组
     * @return 和
     */
    public int maxNum(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (max < num) {
                max = num;
            }
        }
        return max;
    }

    /**
     * 判定nums满足以mid长度能否划分出k段
     *
     * @param nums 数字数组
     * @param mid  每段长度
     * @param k    段数
     * @return 是否满足
     */
    public boolean isValid(int[] nums, int mid, int k) {
        int count = 0;
        for (int num : nums) {
            count += num / mid;
        }
        return count >= k;
    }
}
