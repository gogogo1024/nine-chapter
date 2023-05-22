package com.woodcut;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    void testForkDistinctCharacters() {
        Solution solution = new Solution();
        int[] num1 = new int[]{232, 124, 456};
        int k1 = 7;
        int rst1 = solution.findMax(num1, k1);
        assertEquals(114, rst1);
    }
}
