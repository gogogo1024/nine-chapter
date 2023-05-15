package com.subarray;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * 获取最短子串长度，使其和等于k
     * 前缀和 + HashMap
     *
     * @param nums 数组
     * @param k    k值
     * @return 最短子串长度
     */
    public int subarraySumEqualsK(int[] nums, int k) {
        int[] prefixSum = getPrefixSum(nums);
        int minLen = Integer.MAX_VALUE;
        // { prefixSum[i+1]-k:minLen }
        Map<Integer, Integer> sum2index = new HashMap<>();
        sum2index.put(0, 0);
        for (int i = 0; i < nums.length; i++) {
            if (sum2index.containsKey(prefixSum[i + 1] - k)) {
                int len = i + 1 - sum2index.get(prefixSum[i + 1] - k);
                minLen = Math.min(minLen, len);
            }
            sum2index.put(prefixSum[i + 1], i + 1);
        }
        return minLen;
    }

    /**
     * 获取最短子串长度，使其和大于等于k
     * 前缀和 + 二分查找
     * 时间复杂度 nlog(n)，空间复杂度O(n)
     *
     * @param nums 数组
     * @param k    k值
     * @return 最短子串长度
     */
    public int subarraySumBigKI(int[] nums, int k) {
        int[] prefixSum = getPrefixSum(nums);
        int len = nums.length;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int end = getEndOfSubarray(prefixSum, i, k);
            if (prefixSum[end + 1] - prefixSum[i + 1] >= k) {
                minLen = Math.min(minLen, end - i);
            }
        }
        if (minLen == Integer.MAX_VALUE) {
            return -1;
        }
        return minLen;
    }

    /**
     * 二分法查询
     *
     * @param prefixSum 数组前缀和
     * @param start     开始位置
     * @param s         判定值
     * @return 大于等于s的最小右边界
     */
    public int getEndOfSubarray(int[] prefixSum, int start, int s) {
        int left = start, right = prefixSum.length - 2;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (prefixSum[mid + 1] - prefixSum[start] >= s) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (prefixSum[left + 1] - prefixSum[start] >= s) {
            return left;
        }
        return right;

    }


    /**
     * bidirectionalPointer 同向双指针处理，不需要去计算prefixSum
     * 时间复杂度 O(n)，空间复杂度O(1)，因为没有prefixSum
     *
     * @param nums 数组
     * @param k    k值
     * @return 最短子串长度
     */
    public int subarraySumBigKII(int[] nums, int k) {
        int len = nums.length;
        int minLen = Integer.MAX_VALUE;
        int sumOfSubarray = 0;
        int j = 0;
        for (int i = 0; i < len; i++) {
            while (j < len && sumOfSubarray < k) {
                sumOfSubarray += nums[j];
                j++;
            }
            if (sumOfSubarray >= k) {
                minLen = Math.min(minLen, j - i);
            }
            // 移除i位置的数
            sumOfSubarray -= nums[i];

        }
        if (minLen == Integer.MAX_VALUE) {
            return -1;
        }
        return minLen;
    }

    public int[] getPrefixSum(int[] nums) {
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        return prefixSum;
    }
}
