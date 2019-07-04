package algorithm.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by shimmer on 07/02/2019
 */

/*
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class lengthOfLongestSubstring_0003 {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int count = 1;
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    break;
                }
                set.add(s.charAt(j));
                count++;
            }
            if (count > result) {
                result = count;
            }
        }
        return result;
    }

    /*
    去除一些不必要的循环,提升效果一般
     */
    public int lengthOfLongestSubstring2(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (result >= s.length() - i) {
                return result;
            }
            int count = 1;
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    break;
                }
                set.add(s.charAt(j));
                count++;
            }
            if (count > result) {
                result = count;
            }
        }
        return result;
    }

    public int lengthOfLongestSubstring3(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0, i = 0, j = 0;
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                maxLength = Math.max(maxLength, j - i);
            } else {
                /*
                当出现重复元素时，就一直删除，直到不出现重复为止
                比如bacad baca出现了重复，如果有比bac更长的，只可能从c开始，所以删除b a，从c继续
                 */
                set.remove(s.charAt(i++));
            }
        }
        return maxLength;
    }
}
