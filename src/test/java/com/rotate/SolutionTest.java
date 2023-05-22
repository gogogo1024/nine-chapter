package com.rotate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    void testForFindMin() {
        Solution solution = new Solution();
        int[] rotateNums = new int[]{4, 5, 6, 7, 0, 1, 2, 3};
        int rst = solution.findMin(rotateNums);
        assertEquals(0, rst);
    }
}

