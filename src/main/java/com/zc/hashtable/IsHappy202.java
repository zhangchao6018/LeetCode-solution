package com.zc.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * 描述:
 *编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 *
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 *
 *
 *
 * 示例：
 *
 * 输入：19
 * 输出：true
 * 解释：
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: zhangchao
 * @Date: 8/8/20 8:41 下午
 **/
public class IsHappy202 {
    public boolean isHappy(int n) {

        return r2(n);
        //todo 快慢指针法
    }

    private boolean r2(int n) {
        int sum  = getSum(n);
        Set record = new HashSet();
        while (true){
            if (sum == 1){
                return true;
            }
            if (record.contains(sum)) {
                return false;
            }else {
                record.add(sum);
            }
            sum = getSum(sum);
        }
    }

    /**
     * 核心方法--求和
     * @param n
     * @return
     */
    private int getSum(int n) {
        int sum = 0;
        int cur = n;
        while (cur>0){
            sum+= (cur%10) * (cur%10);
            cur = cur/10;
        }
        return sum;
    }

    private boolean r1(int n) {
        //转化为String[]
        String[] split = String.valueOf(n).split("");

        Set<Integer> set = new HashSet();
        int sum = 0;
        while (true){
            for (String s : split) {
                double pow = Math.pow(Double.parseDouble(s), 2);
                sum+=pow;
            }
            //存在则一定不是
            if (set.contains(sum)){
                return false;
            }
            if (sum == 1){
                return true;
            }
            set.add(sum);
            //得到新的各位数上的数组
            split = (sum+"").split("");
            //求和器置零
            sum = 0;
        }
    }
    //测试案例: 7   10   3
    public static void main(String[] args) {
        boolean happy = new IsHappy202().isHappy(7);
        System.out.println("result:"+happy);
        int sum = new IsHappy202().getSum(101);
        System.out.println(sum);
    }

}
