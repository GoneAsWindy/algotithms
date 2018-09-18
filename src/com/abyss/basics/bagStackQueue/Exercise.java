package com.abyss.basics.bagStackQueue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * @author abyss
 * @date 2018/9/13
 **/
public class Exercise {

    private boolean paretheses(String brackets) {
        String lefts = "{[(";
        HashSet<String> pairs = new HashSet<>();
        pairs.add("{}");
        pairs.add("[]");
        pairs.add("()");
        char[] chars = brackets.toCharArray();
        Stack<Character> characters = new Stack<>();
        for (Character ch : chars) {
            if (lefts.indexOf(ch) != -1) {
                characters.push(ch);
            } else {
                Character left = characters.pop();
                String pair = "" + left + ch;
                if (!pairs.contains(pair)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void testParentheses(){
        System.out.println(paretheses("{[()()]}"));
        System.out.println(paretheses("{[(()]}"));
        System.out.println(paretheses("{[)(()]}"));

    }

    @Test
    public void testExercise136(){
        Queue<String> queue = new Queue<>();
        queue.push("1");
        queue.push("2");
        queue.push("3");
        queue.push("4");
        Stack<String> stack = new Stack<>();
        while (!queue.isEmpty()) {
            stack.push(queue.pop());
        }
        while (!stack.isEmpty()) {
            queue.push(stack.pop());
        }
        for (String s : queue) {
            System.out.print(s);
        }
    }

    @Test
    public void test1(){
        Stack<String> stack = new Stack<>();  //栈存的是数字 也可以理解为运算的结果
        Stack<String> ops   = new Stack<>();  //栈存的是符号
        String str = "1+2)*3-4)*5-6)))";
        for(int i=0;i<str.length();i++){
            String temp = String.valueOf(str.charAt(i));
            if(temp.equals(")")){
                String valright = stack.pop();
                String valleft  = stack.pop();
                String temp1 = "("+valleft+ops.pop()+valright+")";
                stack.push(temp1);
            }else if("+*-%".contains(temp)){
                ops.push(temp);
            }else{
                stack.push(temp);
            }
        }
        for (String aStack : stack) {
            System.out.print(aStack);
        }
    }

    private String infixToPostfix(String infix) {
        Stack<String> nums = new Stack<>();
        Stack<String> operators = new Stack<>();
        infix = infix.replaceAll("\\(", "");
        for (int i = 0; i < infix.length(); i++) {
            String s = String.valueOf(infix.charAt(i));
            if ("+-*/".contains(s)) {
                operators.push(s);
            } else if (s.equals(")")) {
                String right = nums.pop();
                String left = nums.pop();
                String operator = operators.pop();
                nums.push(left + right + operator);
            } else {
                nums.push(s);
            }
        }
        return nums.pop();
    }

    @Test
    public void testInfixTOPostfix(){
        System.out.println(infixToPostfix("((1+2)*((3-4)*(5-6)))"));
    }

    private int evaluatePostfix(String postfix){
        Stack<Integer> eva = new Stack<>();
        for (int i = 0; i < postfix.length(); i++) {
            String s = String.valueOf(postfix.charAt(i));
            if ("+-*/".contains(s)) {
                Integer right = eva.pop();
                Integer left = eva.pop();
                if ("+".equals(s))
                    eva.push(left + right);
                else if ("-".equals(s))
                    eva.push(left - right);
                else if ("*".equals(s))
                    eva.push(left * right);
                else
                    eva.push(left / right);
            } else {
                eva.push(Integer.valueOf(s));
            }
        }
        return eva.pop();
    }

    @Test
    public void  testEvaluatePostfix(){
        System.out.println(evaluatePostfix("12+34-56-**"));
    }



}
