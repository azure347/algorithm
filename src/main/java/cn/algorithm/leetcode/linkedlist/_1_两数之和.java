package cn.algorithm.leetcode.linkedlist;

/**
 * https://leetcode.cn/problems/two-sum/
 *
 * @author wanghao
 * @date 2022/8/22 12:24
 */
public class _1_两数之和 {

    public int[] twoSum(int[] nums, int target) {
        int[] numbers = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    numbers[0] = i;
                    numbers[1] = j;
                    break;
                }
            }
        }
        return numbers;
    }
}
