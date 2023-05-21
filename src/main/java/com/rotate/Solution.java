package com.rotate;

public class Solution {

    /*
     寻找旋转排序数组中的最小值
     例如：
      输入：[4,5,6,7,0,1,2,3]
      输出：0
     */

    /**
     * 数字0左边的所有数字都比数字0右边的数字大
     *
     * @param nums 以数组任意位置旋转后的数组
     * @return 数组最小值
     */
    public int findMin(int[] nums) {
        // start指向比nums[0]大的，end指向比nums[0]小的
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[0]) {
                start = mid;
            } else if (nums[mid] < nums[0]) {
                end = mid;
            } else {
                break;
            }
        }
        return Math.min(Math.min(nums[start], nums[end]), nums[0]);
    }
}
