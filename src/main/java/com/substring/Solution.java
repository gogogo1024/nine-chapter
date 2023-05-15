package com.substring;

import java.util.HashMap;
import java.util.Map;


public class Solution {

    /*
      至少k个不同字符的子串
      给定一个仅包含小写字母的字符串S
      返回S中至少包含k个不同字符的子串的数量
      输入 S = "abcaabcabca" k=4
      返回 0
      输入 S = "abcaac" k=2
      返回 14
     */

    /**
     * 同向双指针 + HashMap
     * 时间复杂度 O(n)， 空间复杂度 O(|t|), ｜t｜ t为S中至少包含k个不同字符的子串的数量
     *
     * @param s 字符串
     * @param k k个不同字符
     * @return S中至少包含k个不同字符的子串的数量
     */
    public long kDistinctCharacters(String s, int k) {
        int len = s.length();

        if (len == 0) {
            return 0;
        }
        long numOfSubstring = 0;
        int diffCharCount = 0;
        // { char:diffCharCount }
        Map<Character, Integer> counter = new HashMap<>();
        int j = 0;
        for (int i = 0; i < len; i++) {
            while (j < len && diffCharCount < k) {
                Character temp = s.charAt(j);
                int numOfChar = counter.getOrDefault(temp, 0);
                counter.put(temp, numOfChar + 1);
                if (counter.get(temp) == 1) {
                    diffCharCount++;
                }
                j++;
            }
            if (diffCharCount == k) {
                numOfSubstring += len - j + 1;
            }
            // 移动i之前删除i位置字符
            Character startTemp = s.charAt(i);
            counter.put(startTemp, counter.get(startTemp) - 1);
            if (counter.get(startTemp) == 0) {
                diffCharCount--;
            }
        }
        return numOfSubstring;
    }

    /*
     source中包含最短target中每一个字符的子串
     输入 source = "abc"  target = "ac"
     返回 "abc"
     输入 source = "abcdadcda"  target = "accb"
     返回 "bcdadc"
    */

    /**
     * source中包含最短target中每一个字符的子串
     * 时间复杂度 O(n+m),空间复杂度 O(|target|+|source|)
     *
     * @param source 源字符
     * @param target 目标字符
     * @return 最短子串
     */
    public String minWindow(String source, String target) {
        if (source.length() == 0 || target.length() == 0) {
            return "";
        }
        int sLen = source.length(), tLen = target.length();
        if (sLen < tLen) {
            return "";
        }
        Map<Character, Integer> targetCount = new HashMap<>();
        Map<Character, Integer> sourceCount = new HashMap<>();

        // target字符串组装HashMap {char : charCount}
        for (int i = 0; i < tLen; i++) {
            int numOfChar = targetCount.getOrDefault(target.charAt(i), 0);
            targetCount.put(target.charAt(i), numOfChar + 1);
        }

        int j = 0;
        // 匹配的字符个数
        int matchedCharCount = 0;
        //  start 起始位置，substringLength匹配时的子字符的最小长度
        int start = 0, substringLength = Integer.MAX_VALUE;

        // i向右移动，要保证source包含target，j必须是右移
        for (int i = 0; i < sLen; i++) {
            while (j < sLen && matchedCharCount < targetCount.size()) {
                int numOfChar = sourceCount.getOrDefault(source.charAt(j), 0);
                sourceCount.put(source.charAt(j), numOfChar + 1);
                // Integer 比较 equals
                if (sourceCount.get(source.charAt(j)).equals(targetCount.get(source.charAt(j)))) {
                    matchedCharCount++;

                }
                j++;
            }
            // 匹配包含target所有字符的长度
            if (matchedCharCount == targetCount.size()) {
                // 每次都比较j-i的长度没，找最小，同时更新起始位置start
                // j 指向时右边界的下一个位置，
                if (substringLength > j - i) {
                    substringLength = j - i;
                    start = i;
                }
            }
            //1. 从HashMap中找到i位置的字符计数并减1
            int numOfChar = sourceCount.getOrDefault(source.charAt(i), 0);
            sourceCount.put(source.charAt(i), numOfChar - 1);
            // 2. 如果source的HashMap中找到i位置的字符计数等于target的HashMap中找到i位置的字符计数
            // 说明匹配的字符计数同样需要减1，因为操作1，进行了减1
            if (sourceCount.get(source.charAt(i)).equals(
                    targetCount.getOrDefault(source.charAt(i), 0) - 1)) {
                matchedCharCount--;
            }
        }
        if (substringLength == Integer.MAX_VALUE) {
            return "";
        }
        return source.substring(start, start + substringLength);
    }
}
