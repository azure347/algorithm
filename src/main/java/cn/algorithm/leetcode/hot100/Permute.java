package cn.algorithm.leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 46. 全排列
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 * @author July
 * @description 回溯算法实现找N个不重复数字的全排列组合
 * @create 2025-11-19 22:08
 */
public class Permute {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute2(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }

        backtrack(nums.length,output,res,0);
        return res;
    }

    private static void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output,first,i);
            // 继续递归填下一个数
            backtrack(n, output, res, first+1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack2(nums, used, new ArrayList<>(), res);
        return res;
    }

    private static void backtrack2(int[] nums, boolean[] used, List<Integer> path,
                                   List<List<Integer>> res) {
        // 当path的长度 == n，就是一条完整的排列
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 遍历每个数字尝试加入path
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;  // 已经用过的跳过

            used[i] = true;
            path.add(nums[i]);

            backtrack2(nums,used,path,res);  // 递归进入下一层

            // 回溯 撤销选择
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
