package com.implementation;

import java.util.HashSet;

public class Solution {
    /*
      给定一个m × n 的矩阵carrots，保证每个位置的数都是正的，其代表该位置的胡萝卜数量。
      从矩阵中心点出发（中心点的意思是正中央的行与列；如果行数列数是偶数，则取偏左或者偏上的），
      每次都朝四个方向中胡萝卜最多的方向走一步，如果四个方向都没有胡萝卜，则停止移动。
      问最后总共采了多少个胡萝卜。
      示例 1:
      输入:
      carrot =
      [
        [5, 7, 6, 3],
        [2, 4, 8, 12],
        [3, 5, 10, 7],
        [4, 16, 4, 17]
      ]
      输出:83
      解释：起点坐标是(1, 1)即4, 移动路线是：4 -> 8 -> 12 -> 7 -> 17 -> 4 -> 16 -> 5 -> 10
      示例 2:
      输入:
      carrot =
      [
        [5, 3, 7, 1, 7],
        [4, 6, 5, 2, 8],
        [2, 1, 1, 4, 6]
       ]
       输出: 30
       解释：起始点是 (1, 2)即5, 移动路线是： 5 -> 7 -> 3 -> 6 -> 4 -> 5
     */

    /**
     * 采集的萝卜总数
     *
     * @param carrots 萝卜矩阵，存放萝卜数量
     * @return 采集到的萝卜总数
     */
    public int pickCarrots(int[][] carrots) {
        int m = carrots.length, n = carrots[0].length;
        int[][] directions = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        int init_x = (m - 1) >> 1, init_y = (n - 1) >> 1;
        HashSet<Integer> visited = new HashSet<>();
        int ans = 0;
        while (true) {
            int move_max = -1;
            int next_x = -1, next_y = -1;
//            System.out.printf("[%d,%d]", init_x, init_y);
            System.out.printf("%d->", carrots[init_x][init_y]);
            ans += carrots[init_x][init_y];
            // 二维坐标转一维坐标
            visited.add(init_x * n + init_y);
            for (int[] direction : directions) {
                int temp_x = init_x + direction[0];
                int temp_y = init_y + direction[1];
                if (!isValid(carrots, temp_x, temp_y, visited)) {
                    continue;
                }
                if (carrots[temp_x][temp_y] > move_max) {
                    move_max = carrots[temp_x][temp_y];
                    next_x = temp_x;
                    next_y = temp_y;
                }
            }
            if (move_max == -1) {
                break;
            }
            init_x = next_x;
            init_y = next_y;
        }

        return ans;
    }

    public boolean isValid(int[][] carrots, int x, int y, HashSet<Integer> visited) {
        if (x < 0 || x >= carrots.length || y < 0 || y >= carrots[0].length) {
            return false;
        }
        return !visited.contains(x * carrots[0].length + y);
    }
}

