package com.zc.array;

/**
 * 描述:
 *给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 *
 *
 * 示例：
 *
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: zhangchao
 * @Date: 8/7/20 10:53 下午
 **/
public class MinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        return timeOut(s, nums);
//        return rightWay(s, nums);
    }

    private int timeOut(int s, int[] nums) {
        int l = 0 , r = -1; // nums[l...r]为滑动窗口
        int sum = 0;
        int res = nums.length + 1;

        while (l< nums.length-1 ){
            if (  r+1<nums.length && sum<s) {
                sum += nums[++r];
            }
            else if(sum>=s ) {
                res = Math.min(res, r - l + 1);
                sum -= nums[l++];
            }
        }
        if(res == nums.length + 1)
            return 0;
        return res;
    }

    private int rightWay(int s, int[] nums) {
        int l = 0 , r = -1; // nums[l...r]为滑动窗口
        int sum = 0;
        int res = nums.length + 1;

        while (l< nums.length-1 ){
            if ( r+1<nums.length && sum<s) {
                sum += nums[++r];
            }
            else {
                sum -= nums[l++];
            }
            if (sum>=s){
                res = Math.min(res, r - l + 1);
            }
        }
        if(res == nums.length + 1)
            return 0;
        return res;
    }

    public static void main(String[] args) {
        int s = 11;
//        int [] nums = new int []{2,3,1,2,4,3};
//        int [] nums = new int []{1,4,4};
        int [] nums = new int []{1,2,3,4,5};
        int i = new MinSubArrayLen().minSubArrayLen(s, nums);
        System.out.println(i);
    }
}
