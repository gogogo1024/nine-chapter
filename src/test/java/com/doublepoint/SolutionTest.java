package com.doublepoint;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    void testForFindMaxWeights() {
        Solution solution = new Solution();
        int[] customers = new int[]{1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = new int[]{0, 1, 0, 1, 0, 1, 0, 1};
        int k = 3;
        int radius1 = solution.findMaxWeights(customers, grumpy, k);
        assertEquals(16, radius1);
    }
    @Test
    void testForMaxProfit() {
        Solution solution = new Solution();
        int[] stockPrice = new int[]{ 4,4,6,1,1,4,2,5};
        int maxCost = solution.maxProfit(stockPrice);
        assertEquals(6, maxCost);
    }
    @Test
    void testForPickAppleTree() {
        Solution solution = new Solution();
        int[] appleTree = new int[]{ 6,1,4,6,3,2,7,4};
        int K = 3, L =2;

        int maxAppleCount = solution.pickAppleTree(appleTree,K,L);
        assertEquals(24, maxAppleCount);
    }

}

