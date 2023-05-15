package com.substring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    void testForkDistinctCharacters() {
        Solution solution = new Solution();
        String s1 = "abcaabcabca";
        long rst1 = solution.kDistinctCharacters(s1, 4);
        String s2 = "abcaac";
        long rst2 = solution.kDistinctCharacters(s2, 2);
        assertEquals(0, rst1);
        assertEquals(14, rst2);
        String source1 = "abc", target1 = "ac";
        String source2 = "abcdadcda", target2 = "accb";
        String rst3 = solution.minWindow(source1, target1);
        assertEquals("abc", rst3);
        String rst4 = solution.minWindow(source2, target2);
        assertEquals("bcdadc", rst4);
    }
}
