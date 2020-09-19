package com.zc.stackandqueue;

import java.util.*;

/**
 * 描述:
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 *     左括号必须用相同类型的右括号闭合。
 *     左括号必须以正确的顺序闭合。
 *
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 *
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 *
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 *
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 *
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * todo 150     71
 * @Author: zhangchao
 **/
public class IsValid20 {
    public boolean isValid(String s) {
        return f2(s);
    }
    private boolean f2(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (c=='{' || c=='[' || c=='('){
                stack.push(c);
            }else {
                if (stack.isEmpty())
                    return false;

                Character pop = stack.pop();
                Character match;
                if (c == '}') {
                    match = '{';
                } else if (c == ']') {
                    match = '[';
                } else {
                    assert c == ')';
                    match = '(';
                }
                if (pop != match)
                    return false;
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean f1(String s) {
        List<String> key = Arrays.asList("{","[","(");
        List<String> matcher = Arrays.asList("}","]",")");

        Stack<String> stack = new Stack<>();

        String[] split = s.split("");
        for (String s1 : split) {
            if (key.contains(s1)){
                stack.push(s1);
            }else {
                if (stack.isEmpty()){
                    return false;
                }
                if(key.indexOf(stack.pop()) != matcher.indexOf(s1)){
                    return false;
                }
            }
        }
        if (stack.isEmpty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(new IsValid20().isValid(s));

    }
}
