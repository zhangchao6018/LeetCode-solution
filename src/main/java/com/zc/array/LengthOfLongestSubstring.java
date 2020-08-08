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
public class LengthOfLongestSubstring {
    //滑动窗口法
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = -1;
        int[] freq =new int[256];
        int  result = 0;
        while (l<s.length() && r+1<s.length()){
            char c = s.charAt(r+1);
            if (freq[c]==0 && r<s.length()-1){
                //不存在,右边界右移
                freq[s.charAt(++r)] ++;
            }else {
                //存在
                freq[s.charAt(l++)] --;
            }
            result = Math.max(result,r-l+1);

        }

        return result;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
//        String s = "abcabcbb";
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring(s));
    }
}
