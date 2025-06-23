package cn.algorithm.leetcode.hot100;

/**
 * 136. 只出现一次的数字
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 *
 *
 *
 * 示例 1 ：
 *
 * 输入：nums = [2,2,1]
 *
 * 输出：1
 *
 * 示例 2 ：
 *
 * 输入：nums = [4,1,2,1,2]
 *
 * 输出：4
 *
 * 示例 3 ：
 *
 * 输入：nums = [1]
 *
 * 输出：1
 *
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 3 * 104
 * -3 * 104 <= nums[i] <= 3 * 104
 * 除了某个元素只出现一次以外，其余每个元素均出现两次。
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        int result = singleNumber(nums);
        System.out.println("只出现一次的数字是: " + result); // 输出: 1
    }

    /**
     * 异或 ： 同为0，异为1
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // 使用异或操作，重复的数字会被抵消
        }
        return result; // 返回只出现一次的数字
    }
}
