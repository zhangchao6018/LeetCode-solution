package com.zc;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @描述:
 * @author: zhangchao
 * @date: 4/6/20 12:38 下午
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 *
 * 输入: "()[]{}"
 * 输出: true
 * 来源：力扣（LeetCode）
 **/
public class IsValid
{
    /**
     * 1. 满足条件肯定是偶数
     * 2. 将s 分成两半 左边按照倒序,右边按照升序分别存入两个栈中 逐一比较
     * @param s
     * @return
     */
    public static boolean isValid22(String s) {
        //字典
        Map match = new HashMap();
        match.put("{", "}");
        match.put("[", "]");
        match.put("(", ")");


        if (s==null || s.length()%2!=0){
            return false;
        }

        boolean res = true;
        String[] split = s.split("");
        Stack<String> leftStack = new Stack();
        Stack<String> rightStack = new Stack();
        for (int i = split.length/2-1; i >= 0; i--) {
            leftStack.push(split[i]);
        }
        for (int i = split.length/2; i < split.length; i++) {
            rightStack.push(split[i]);
        }

        while (true){
            if (!leftStack.empty() && !rightStack.empty()){
                if ( ! match.get(leftStack.pop()).equals(rightStack.pop())) {
                    res = false;
                    break;
                }
            }else {
                break;
            }
        }
        return res;
    }

    public static boolean isValid(String s) {
        //字典
        Map<String,String> match = new HashMap(3);
        match.put("{", "}");
        match.put("[", "]");
        match.put("(", ")");
        if (s==null || s.length()%2!=0){
            return false;
        }
        boolean res = true;
        //定义左括号的栈 { [ (
        Stack<String> leftStack = new Stack();
        String[] split = s.split("");
        for (int i = 0; i < split.length; i++) {
            if ("{".equals(split[i]) ||
                    "[".equals(split[i]) ||
                    "(".equals(split[i])
            )
            {
                leftStack.push(split[i]);
            }
            else
            {
                if (!leftStack.isEmpty()){
                    if (!match.get(leftStack.pop()).equals(split[i])){
                        return false;
                    }
                }
            }
        }
        if (leftStack.isEmpty()){
            res =  true;
        }else {
            res =  false;
        }
        return res;
    }

    public static void main(String[] args) {

        String s = "()[]{}";
        boolean valid = isValid(s);
        System.out.println(valid);
    }


}

