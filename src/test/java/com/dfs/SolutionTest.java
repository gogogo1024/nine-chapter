package com.dfs;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
    @Test
    void testForIsSymmetric() {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode.left =treeNode1;
        treeNode.right =treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.right = treeNode3;
        treeNode2.left = treeNode4;
        boolean flag1 = solution.isSymmetric(treeNode);
        assertTrue(flag1);
    }
    @Test
    void testForGetPrefixToWords() {
        Solution solution = new Solution();
        String [] words = new String[]{"abc","abcd","bcde","cdef"};
        Map<String, List<String>> prefixToWords  =  solution.getPrefixToWords(words);
    }

}
