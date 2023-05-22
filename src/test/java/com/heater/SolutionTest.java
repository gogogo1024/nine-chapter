package com.heater;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    void testForkDistinctCharacters() {
        Solution solution = new Solution();
        int[] houses1 = new int[]{1, 2, 3, 4};
        int[] heaters1 = new int[]{1, 4};
        int radius1 = solution.findMinRadius(houses1, heaters1);
        assertEquals(1, radius1);
        int[] houses2 = new int[]{1, 3, 5, 6, 9};
        int[] heaters2 = new int[]{2, 8};
        int radius2 = solution.findMinRadius(houses2, heaters2);
        assertEquals(3, radius2);
        int[] houses3 = new int[]{3, 7, 50, 53, 54};
        int[] heaters3 = new int[]{4, 11, 13, 14, 51};
        int radius3 = solution.findMinRadiusDoublePoints(houses3, heaters3);
        assertEquals(3, radius3);
    }
}
