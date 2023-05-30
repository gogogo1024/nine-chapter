package com.implementation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    void testForPickCarrots() {
        Solution solution = new Solution();
//        int[][] carrots1 = new int[][]{
//                {5, 7, 6, 3},
//                {2, 4, 8, 12},
//                {3, 5, 10, 7},
//                {4, 16, 4, 17}
//        };
//        int carrotCount1 = solution.pickCarrots(carrots1);
//        assertEquals(83, carrotCount1);
        int[][] carrots2 = new int[][]{
                {5, 3, 7, 1, 7},
                {4, 6, 5, 2, 8},
                {2, 1, 1, 4, 6}
        };
        int carrotCount2 = solution.pickCarrots(carrots2);
        assertEquals(30, carrotCount2);
    }
}
