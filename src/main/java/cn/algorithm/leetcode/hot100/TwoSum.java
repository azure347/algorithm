package cn.algorithm.leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 * <p>
 * 你可以按任意顺序返回答案。
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    /**
     * 暴力破解法
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     *
     * @param nums   数组
     * @param target 目标值
     * @return 返回两个数的下标
     */
    public static int[] twoSum(int[] nums, int target) {
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

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1}; // 如果没有找到，返回一个无效的结果
    }


}
