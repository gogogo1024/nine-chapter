package com.doublepoint;

public class Solution {

    /*
     爱生气的书店老板
     书店每天的顾客好评数为customers[i]
     老板的心情为grumpy[i]
     grumpy[i]为1时，顾客打差评
     grumpy[i]为0时，顾客打好评
     老板有一次机会将连续的x天中的所有grump[i]变为0
     好评数权重值result[i] = (1-grumpy[i])* customers[i]
     求可能出现的最大好评数权重值和
     */

    public int findMaxWeights(int[] customers, int[] grumpy, int k) {
        int len = customers.length, sum = 0;
        for (int i = 0; i < len; i++) {
            if (i < k) {
                sum += customers[i];
            } else {
                sum += (1 - grumpy[i]) * customers[i];
            }
        }
        int result = sum;
        // left离开窗口的指针，right进入窗口的指针，
        int left = 0, right = k;
        while (right < len) {
            if (grumpy[right] == 1) {
                sum += customers[right];
            }
            if (grumpy[left] == 1) {
                sum -= customers[left];
            }
            left++;
            right++;
            result = Math.max(result, sum);
        }
        return result;

    }

    /*
    买卖股票的最佳时机
    stockPrice[i]是第i天的股票价格，你可以选择买入或者卖出
    你最多可以有两次交易，也就是买入卖出，买入卖出（不允许买入买入卖出卖出）
    输入：stockPrice = [4,4,6,1,1,4,2,5]
    输出： 6
     */

    /**
     * 买入卖出两次的最大利润
     * 利用隔板法，隔离出两次的买入卖出
     *
     * @param stockPrice 股票价格
     * @return 最大利润
     */
    public int maxProfit(int[] stockPrice) {
        int len = stockPrice.length;
        int maxCost = 0;
        for (int i = 0; i < len; i++) {
            // 枚举隔板 [0,i),[i,len)
            int leftCost = getCost(stockPrice, 0, i);
            int rightCost = getCost(stockPrice, i, len);
            maxCost = Math.max(maxCost, leftCost + rightCost);
        }
        return maxCost;
    }

    /**
     * 买入卖出一次的最大利润
     *
     * @param stockPrice 股票价格
     * @param left       左边界
     * @param right      有边界
     * @return 最大利润
     */
    private int getCost(int[] stockPrice, int left, int right) {
        int minPrice = Integer.MAX_VALUE;
        int cost = 0;
        for (int i = left; i < right; i++) {
            // 维护到i为止的最小stockPrice
            minPrice = Math.min(minPrice, stockPrice[i]);
            cost = Math.max(cost, stockPrice[i] - minPrice);
        }
        return cost;
    }

    /*
    捡苹果
    A和B在连续标记为1~N的苹果树上分别收集连续K和L颗树上的苹果
    A和B选择的区间不重合,返回他们能收集到的最多苹果
    输入：appleTree =[6,1,4,6,3,2,7,4], K =3,L=2
    输出：24 ([4,6,4],[7,4])
     */
    public int pickAppleTree(int[] appleTree, int K, int L) {
        int len = appleTree.length;
        int maxCount = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int leftMaxL = findMax(appleTree, L, 0, i);
            int rightMaxK = findMax(appleTree, K, i, len);
            int leftMaxK = findMax(appleTree, K, 0, i);
            int rightMaxL = findMax(appleTree, L, i, len);
            if (leftMaxK != -1 && rightMaxL != -1) {
                maxCount = Math.max(maxCount, leftMaxK + rightMaxL);
            }
            if (leftMaxL != -1 && rightMaxK != -1) {
                maxCount = Math.max(maxCount, leftMaxL + rightMaxK);
            }
        }
        if (maxCount == Integer.MIN_VALUE) {
            return -1;
        }
        return maxCount;
    }

    /**
     * 采集连续k颗苹果树的最大苹果个数
     *
     * @param appleTree 苹果树上的苹果
     * @param k         连续的k颗苹果树
     * @param start     开始位置
     * @param end       结束位置
     * @return 能采集的最大苹果个数
     */
    private int findMax(int[] appleTree, int k, int start, int end) {
        if (k > end - start) {
            return -1;
        }
        int apples = 0, maxApples = 0;
        for (int i = start; i < start + k; i++) {
            apples += appleTree[i];

        }
        maxApples = apples;
        int left = start, right = start + k;
        while (right < end) {
            apples -= appleTree[left];
            apples += appleTree[right];
            maxApples = Math.max(maxApples, apples);
            left++;
            right++;
        }
        return maxApples;
    }

}
