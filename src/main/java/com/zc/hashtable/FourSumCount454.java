package com.zc.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 *给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 *
 * 例如:
 *
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 49
 * @Author: zhangchao
 **/
public class FourSumCount454 {
    //思路 Map保存前两个数组两元素的和,以及其组合的次数  ((a+b),count)
    //后两个数组两元素的和满足条件的结果:0-(a+b) = c+d
    // 时间复杂度: O(n^2)
    // 空间复杂度: O(n^2)
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                if (!map.containsKey(a+b)){
                    map.put(a+b,1);
                }else{
                    map.put(a+b,map.get(a+b)+1);
                }

            }
        }

        int res = 0;
        for (int c : C) {
            for (int d : D) {
                if (map.containsKey(-(c+d))){
                    res+=map.get(-(c+d));
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int [] A = {1,2};
        int [] B = {-2,-1};
        int [] C = {-1,2};
        int [] D = {0,2};
        System.out.println(new FourSumCount454().fourSumCount(A, B, C, D));

    }
}
