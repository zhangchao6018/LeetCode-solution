package com.zc.array;

/**
 * todo 438,76
 * <p>滑动窗口算法</p>
 * 描述:
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zhangchao
 * @Date: 6/8/20 10:56 下午
 **/
public class LengthOfLongestSubstring3 {
    //滑动窗口法
    public int lengthOfLongestSubstring(String s) {
        int lIdx=0;
        int rIdx=-1;
        int res = 0;
        int[] freq =new int[256];
        while (rIdx+1<s.length()){
            char c = s.charAt(rIdx + 1);
            int i = freq[c];

            if (freq[s.charAt(rIdx+1)]==0)
                //未重复
                freq[s.charAt(++rIdx)]=1;
            else
                //重复了 向右移动指针,直到不包含重复元素
                freq[s.charAt(lIdx++)]=0;

            res=Math.max(rIdx-lIdx+1,res);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring3().lengthOfLongestSubstring("pwwkew"));
    }
}
