package cn.algorithm.leetcode.hot100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。注意 "bca" 和 "cab" 也是正确答案。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 * @author July
 * @description
 * @create 2025-10-13 22:31
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "abcabcbb";
        String s1 = " ";
        System.out.println(lengthOfLongestSubstring2(s));


    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        int max = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            List<String> strList = new ArrayList<>();
            strList.add(s.charAt(i) + "");
            for (int j = i + 1; j < s.length(); j++) {
                if (strList.contains(s.charAt(j) + "")) {
                    break;
                }
                strList.add(s.charAt(j) + "");
            }
            max = Math.max(max, strList.size());
        }
        return max;
    }

    public static int lengthOfLongestSubstring2(String s) {
        Set<Character> set = new HashSet<Character>();
        int n = s.length();
        int t = 0, max = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (t < n && !set.contains(s.charAt(t))) {
                set.add(s.charAt(t));
                t++;
            }
            max = Math.max(max, t - i);
        }
        return max;
    }
}
