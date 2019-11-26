package com.mk.demos.leet;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * valid-parentheses 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 *      1.左括号必须用相同类型的右括号闭合。
 *      2.左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 示例 1:
 *      输入: "()"
 *      输出: true
 * 示例 2:
 *      输入: "()[]{}"
 *      输出: true
 *
 * @author WangChen
 * Created on 2019/11/26 11:57
 * @since 1.0
 */
public class ValidParentheses {

    Character[] rightParentheses = new Character[]{')', '}', ']'};
    Character[] leftParentheses = new Character[]{'(', '{', '['};


    public boolean isValid(String s) {
        List<Character> left = Arrays.asList(leftParentheses);
        List<Character> right = Arrays.asList(rightParentheses);
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (left.contains(c)){
                stack.push(c);
            }else if (right.contains(c)){
                if (stack.empty()){
                    return false;
                }
                Character pop = stack.pop();
                if (!match(pop, c)){
                    return false;
                }
            }else {
                throw new RuntimeException("illegal character.");
            }
        }
        if (!stack.empty()){
            return false;
        }
        return true;
    }

    private boolean match(Character leftC, Character rightC){
        if ((leftC.equals('(') && rightC.equals(')'))
            || (leftC.equals('{') && rightC.equals('}'))
                || (leftC.equals('[') && rightC.equals(']'))){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        String s = "{[]}";
        boolean valid = new ValidParentheses().isValid(s);
        System.out.println(valid);
//        boolean match = match('(', ']');
//        System.out.println(match);
    }

}
