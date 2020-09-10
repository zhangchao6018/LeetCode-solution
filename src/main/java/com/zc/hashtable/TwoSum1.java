package com.zc.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 15   18  16
 * @Author: zhangchao
 **/
public class TwoSum1 {
    public int[] twoSum(int[] nums, int target) {
        return f1(nums, target);
    }


    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    private int[] f1(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap();

        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int temp = target-num;
            if (map.containsKey(temp) && map.get(temp)!=i){
                res[0] = i;
                res[1] = map.get(temp);
                return res;
            }
            map.put(num,i);
        }
        return  res;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{2,8,11,15,2,1,3};
//        int target = 4;
        int[] nums = new int[]{3,3};
        int target = 6;
        int[] ints = new TwoSum1().twoSum(nums, target);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
