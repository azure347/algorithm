package cn.algorithm.leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为 K 的子数组
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 *
 * 子数组是数组中元素的连续非空序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 *
 * @author July
 * @description
 * @create 2025-10-21 20:20
 */
public class SubarraySum {

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        System.out.println(subarraySum(nums,2));
    }


    /**
     * 枚举，时间复杂度O(n^2)，空间复杂度O(1)
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) count++;
            }
        }
        return count;
    }

    /**
     * 前缀和 + 哈希表优化
     * 时间复杂度：O(n) 空间复杂度：O(n)
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum2(int[] nums, int k) {
        int count = 0, pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }

            // 将当前前缀和加入哈希表，如果已存在则计数+1，否则初始化为1
            // 这样可以记录到目前为止出现该前缀和的次数
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
