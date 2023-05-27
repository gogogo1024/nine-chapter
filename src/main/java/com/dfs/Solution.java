package com.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    /**
     * 判定树是否完全对称
     *
     * @param root 根节点
     * @return 是否对称
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if (leftNode == null || rightNode == null) {
            return false;
        }
        if (leftNode.val != rightNode.val) {
            return false;
        }
        boolean left = isSymmetric(leftNode.left, rightNode.right);
        boolean right = isSymmetric(leftNode.right, rightNode.left);
        return left && right;
    }

    public Map<String, List<String>> getPrefixToWords(String[] words) {
        Map<String, List<String>> prefixToWords = new HashMap<>();
        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                String prefix = word.substring(0, j + 1);
                if (!prefixToWords.containsKey(prefix)) {
                    prefixToWords.put(prefix, new ArrayList<String>());
                }
                prefixToWords.get(prefix).add(word);
            }
        }
        return prefixToWords;
    }
}
