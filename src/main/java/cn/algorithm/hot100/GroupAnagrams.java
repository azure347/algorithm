package cn.algorithm.hot100;

import com.alibaba.fastjson2.JSON;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 49. 字母异位词分组
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 *
 *
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 *
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * 解释：
 *
 * 在 strs 中没有字符串可以通过重新排列来形成 "bat"。
 * 字符串 "nat" 和 "tan" 是字母异位词，因为它们可以重新排列以形成彼此。
 * 字符串 "ate" ，"eat" 和 "tea" 是字母异位词，因为它们可以重新排列以形成彼此。
 * 示例 2:
 *
 * 输入: strs = [""]
 *
 * 输出: [[""]]
 *
 * 示例 3:
 *
 * 输入: strs = ["a"]
 *
 * 输出: [["a"]]
 *
 *
 *
 * 提示：
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 */
public class GroupAnagrams {

    public static void main(String[] args) {
//        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        String[] strs = {"a"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String strSort = Arrays.toString(charArray);
            if (map.containsKey(strSort)) {
                map.get(strSort).add(str);
            } else {
                map.put(strSort, new ArrayList<String>(){{
                    add(str);
                }});
            }
        }
        return new ArrayList<>(map.values());
    }

    public static List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            /**
             * map.computeIfAbsent(key, mappingFunction) 方法的作用是：
             * 检查 map 中是否存在指定的 key
             * 如果 key 不存在，则使用 mappingFunction 计算一个新值并将其添加到 map 中
             * 最后返回与 key 关联的当前值（无论是已存在的还是新计算的）
             * 具体到这行代码：
             * Arrays.toString(charArray) 作为 key
             * k -> new ArrayList<>() 是 mappingFunction，创建一个新的空 ArrayList
             * .add(str) 将当前字符串添加到返回的 List 中
             */
            map.computeIfAbsent(Arrays.toString(charArray), k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
