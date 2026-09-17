package cn.algorithm.leetcode.hot100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 128. 最长连续序列
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 *
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * 示例 3：
 *
 * 输入：nums = [1,0,1,2]
 * 输出：3
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class LongestConsecutive {

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums)); // 输出: 4

        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutive(nums2)); // 输出: 9

        int[] nums3 = {1, 0, 1, 2};
        System.out.println(longestConsecutive(nums3)); // 输出: 3
    }

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            set.add(num);
        }

        int maxLength = 0;

        // 遍历每个数字，只有当它是序列的起始数字时才开始计算
        for (int num : set) {
            // 如果 num-1 存在，说明 num 不是序列的起始数字，跳过
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                // 从当前数字开始，向后查找连续的数字
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                // 更新最大长度
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }
}
