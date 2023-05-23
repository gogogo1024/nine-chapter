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

}
