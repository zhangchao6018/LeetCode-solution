package com.zc.stackandqueue;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 描述:
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 *
 *
 * 提示：
 *
 *     你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 *     你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 *     题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 *     你可以按任意顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: zhangchao
 **/
public class TopKFrequent347 {
    private class PairComparator implements Comparator<Pair<Integer, Integer>> {

        @Override
        public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2){
            if(p1.getKey() != p2.getKey())
                return p1.getKey() - p2.getKey();
            return p1.getValue() - p2.getValue();
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        if (k > nums.length){
            throw new IllegalArgumentException();
        }
        //<元素,频率>
        Map<Integer,Integer> map = new HashMap();
        for (int num : nums) {
            if (!map.containsKey(num)){
                map.put(num,1);
            }else {
                map.put(num,map.get(num)+1);
            }
        }
        if (k > map.size()){
            throw new IllegalArgumentException();
        }

        PriorityQueue<Pair<Integer,Integer>> queue = new PriorityQueue<>(new PairComparator());
        for (Integer key : map.keySet()) {
            if(queue.size() == k){
                if (queue.peek().getKey() < map.get(key)){
                    queue.poll();
                    queue.add(new Pair<>(map.get(key),key));
                }
            }else {
                queue.add(new Pair<>(map.get(key),key));
            }
        }

        int[] res = new int[queue.size()];
        int inx = 0;
        while (!queue.isEmpty()){
            res[inx++] = queue.poll().getValue();
        }
        return res;
    }
    public static void main(String[] args) {

        int[] nums = new int[]{4,1,-1,2,-1,2,3};
        int[] ints = new TopKFrequent347().topKFrequent(nums, 2);
        System.out.println(ints);
    }
}
