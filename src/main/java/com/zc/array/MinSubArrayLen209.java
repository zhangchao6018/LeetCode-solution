package com.zc.array;

/**
 * <p>滑动窗口算法</p>
 *
 * 描述:
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例: 
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 进阶:
 *
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zhangchao
 * @Date: 6/7/20 11:41 下午
 **/
public class MinSubArrayLen209 {
    public int minSubArrayLen(int s, int[] nums) {

        int l = 0 , r = -1; // nums[l...r]为我们的滑动窗口
        int sum = 0;
        int res = nums.length + 1;

        while(l < nums.length){   // 窗口的左边界在数组范围内,则循环继续

            if(r + 1 < nums.length && sum < s)
                sum += nums[++r];
            else // r已经到头 或者 sum >= s
                sum -= nums[l++];

            if(sum >= s)
                res = Math.min(res, r - l + 1);
        }

        if(res == nums.length + 1)
            return 0;
        return res;

    }

    public static void main(String[] args) {
//        int [] arr = new int[]{2,3,1,2,4,3};
//        System.out.println(new MinSubArrayLen209().minSubArrayLen(7, arr));
//        int [] arr = new int[]{1,2,3,4,5};
        int [] arr = new int[]{2,3,1,2,4,3};
        System.out.println(new MinSubArrayLen209().minSubArrayLen(7, arr));
    }
}
