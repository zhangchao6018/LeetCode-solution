package com.zc.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 *
 * 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
 *
 * 示例:
 *
 * 输入:
 * [[0,0],[1,0],[2,0]]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-boomerangs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: zhangchao
 **/
public class NumberOfBoomerangs447 {
    public int numberOfBoomerangs(int[][] points) {
        //思路 每个元素都可以作为起始点 计算每种元素作为起始点的回旋镖数量之和
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            //key:距离i点的距离   value:距离i点为key距离的个数
            Map<Integer,Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (j!=i){
                    //距离(key)
                    int dis = dis(points[i], points[j]);
                    HashMap hashMap = new HashMap();
                    if (!map.containsKey(dis)){
                        map.put(dis,1);
                    }else {
                        map.put(dis,map.get(dis)+1);
                    }
                }
            }
            //统计i元素的回旋镖数量
            for (Integer key : map.keySet()) {
                Integer dis = map.get(key);
                count += dis*(dis-1);
            }
        }
        return count;
    }
    //计算距离的平方
    private int dis(int[] pa, int pb[]){
        return (pa[0] - pb[0]) * (pa[0] - pb[0]) +
                (pa[1] - pb[1]) * (pa[1] - pb[1]);
    }
    public static void main(String[] args) {

    }
}
