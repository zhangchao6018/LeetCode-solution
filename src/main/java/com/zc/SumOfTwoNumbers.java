package com.zc;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * @Author: zhangchao22
 * @Date: 2020/3/18 17:30
 **/
public class SumOfTwoNumbers {
    public static void main(String[] args) {
        int [] nums = {2, 7, 11, 15};
        int target = 9;
//        int [] result =  getResult(nums,target);
        int [] result =  getResultHash(nums,target);
        
        System.out.println("result:"+result.toString());
    }

    //hash算法 key+value=target
    private static int[] getResultHash(int[] nums, int target) {
        // key + value = target ->即符合条件的结果
        int [] result = new int[2];
        Map<Integer,Integer> search = new HashMap();
        for (int i =0 ; i< nums.length ; i++){
            if (search.containsKey(nums[i])){
                result[0]=i;
                result[1]=search.get(nums[i]);
                return result;
            }
            search.put(target-nums[i],i);
        }
        return result;
    }

    //暴力法-
    private static int[] getResult(int[] nums, int target) {
        for (int i = 0 ; i <nums.length ; i++){
            for (int x = 0 ; x <nums.length ; x++){
                int a = nums[i];
                int b = nums[x];
                if (i!=x && a+b == target ){
                    return new int []{i,x};
                }
            }
        }
        return new int []{};
    }

}
