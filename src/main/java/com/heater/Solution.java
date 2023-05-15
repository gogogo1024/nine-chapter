package com.heater;

import java.util.Arrays;

public class Solution {

    /*
     给出两坐标houses,heater
     分别代表一维坐标上的房屋坐标和加热器坐标
     加热器的加热半径都相同
     找到加热器的最短加热半径使得所有房屋都能被加热
     例如：
      输入：houses = [1,2,3,4] heater = [1,4]
      输出：1
      输入：houses = [1,3,5,6,9] heater = [2,8]
      输出：3
      输入：houses = [3,7,50,53,54] heater = [4,11,13,14,51]
      输出：3
     */


    /**
     * 二分查找每个house在heater中的插入的位置
     * 比较加热器和房子的距离，选择最近的距离作为加热半径
     * 在遍历house中的选取最大的加热半径作为最终的加热器的加热半径
     * 排序 heater O(m*log(m))
     * 遍历 houses O(n)
     * 二分查找O(log(m))
     * 总时间复杂度O((n+m)*log(m))
     *
     * @param houses  房屋坐标
     * @param heaters 加热器坐标
     * @return 加热器的最短加热半径
     */
    public int findMinRadius(int[] houses, int[] heaters) {
        // 二分查找前提是数组有序
        Arrays.sort(heaters);
        int maxHeatRadius = 0;
        for (int house : houses) {
            int radius = getMinRadius(house, heaters);
            maxHeatRadius = Math.max(maxHeatRadius, radius);
        }
        return maxHeatRadius;

    }

    /**
     * 找到距离house最近的两个数，类似于插入(j,j+1)，找出house距离(j,j+1)距离最近加热器
     *
     * @param house   当前房屋坐标
     * @param heaters 加热器的所有坐标
     * @return 距离当前house最近的加热器
     */
    private int getMinRadius(int house, int[] heaters) {
        int left = 0, right = heaters.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (heaters[mid] <= house) {
                left = mid;
            } else {
                right = mid;
            }
        }
        int leftBoundaryRadius = Math.abs(heaters[left] - house);
        int rightBoundaryRadius = Math.abs(heaters[right] - house);
        return Math.min(leftBoundaryRadius, rightBoundaryRadius);

    }

    /**
     * 同向双指针
     * 两个数组最多被遍历O(n+m)
     * 数组排序O(m*log(m)+n*log(n))
     * 总时间复杂度O(n*log(n)+m*log(m))
     * 空间复杂度O(1)
     *
     * @param houses  房屋坐标
     * @param heaters 加热器坐标
     * @return 加热器的最短加热半径
     */
    public int findMinRadiusDoublePoints(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int maxHeatRadius = 0;
        int houseLen = houses.length, heaterLen = heaters.length;
        // i,j分别指向houses，heaters队首
        int i = 0, j = 0;
        // 如果当前heater[j]比heater[j+1]距离houses[i]更近
        // 移动i,否则移动j
        while (i < houseLen && j < heaterLen) {
            int currentMinRadius = Math.abs(heaters[j] - houses[i]);
            int nextMinRadidus = Integer.MAX_VALUE;
            if (j < heaterLen - 1) {
                nextMinRadidus = Math.abs(heaters[j + 1] - houses[i]);
            }
            if (currentMinRadius < nextMinRadidus) {
                maxHeatRadius = Math.max(maxHeatRadius, currentMinRadius);
                i++;
            } else {
                j++;
            }
        }
        return maxHeatRadius;
    }
}
