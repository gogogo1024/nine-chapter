package com.subarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    void testForGetPrefixSum() {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        int[] prefixSum = solution.getPrefixSum(nums);
        assertArrayEquals(prefixSum, new int[]{0, 2, 5, 6, 8, 12, 15});
    }

    @Test
    void testForSubarraySumEqualsK() {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        int minLen = solution.subarraySumEqualsK(nums, 6);
        assertEquals(2, minLen);
    }

    @Test
    void testForSubarraySumBigK() {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        int minLen = solution.subarraySumBigKI(nums, 6);
        assertEquals(2, minLen);
    }

    @Test
    void testForSubarraySumBigKII() {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        int minLen = solution.subarraySumBigKII(nums, 6);
        assertEquals(2, minLen);
    }

}
