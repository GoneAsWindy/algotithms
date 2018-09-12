package com.abyss.basics.bagStackQueue;

import org.junit.Test;

/**
 * @author abyss
 * @date 2018/9/12
 **/
public class TestExample {
    public static void main(String[] args) {
        Stack<String> strings = new Stack<>();
        strings.pop();
        System.out.println(strings.isEmpty());
        strings.push("to");
        System.out.println(strings.pop());
        strings.push("to be, that is a question.");
        strings.push("or not ");
        strings.push("be ");
        strings.push("to ");
        System.out.println(strings.isEmpty());
        System.out.println(strings.size());

        System.out.println("===========================");
        for (String string : strings) {
            System.out.print(string);
        }


    }

    @Test
    public void testQueue(){
        Queue<String> strings = new Queue<>();
        strings.pop();
        System.out.println(strings.isEmpty());
        strings.push("to");
        System.out.println(strings.pop());
        strings.push("to ");
        strings.push("be ");
        strings.push("or not ");
        strings.push("to be, that is a question.");
        System.out.println(strings.isEmpty());
        System.out.println(strings.size());

        System.out.println("===========================");
        for (String string : strings) {
            System.out.print(string);
        }
    }


}
