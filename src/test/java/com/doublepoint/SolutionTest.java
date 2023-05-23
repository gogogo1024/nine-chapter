package com.doublepoint;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    void testForkDistinctCharacters() {
        Solution solution = new Solution();
        int[] customers = new int[]{1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = new int[]{0, 1, 0, 1, 0, 1, 0, 1};
        int k = 3;
        int radius1 = solution.findMaxWeights(customers, grumpy, k);
        assertEquals(16, radius1);
    }
}
