package com.abyss.basics.bagStackQueue;

import com.sun.tools.corba.se.idl.constExpr.Or;

import java.util.Iterator;

/**
 * @author abyss
 * @date 2018/9/12
 **/
public class Stack<T> implements Iterable<T> {

    private Node first;
    private int N;

    private class Node {
        Node next;
        T t;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(T t) {
        Node oldFirst = first;
        first = new Node();
        first.t = t;
        first.next = oldFirst;
        N++;
    }

    public T pop() {
        if (first == null) {
            return null;
        }
        Node oldFirst = this.first;
        first = first.next;
        N--;
        return oldFirst.t;
    }

    public T peek(){
        if (first == null) {
            return null;
        }
        return first.t;
    }

    public static Stack<String> copy(Stack<String> stack){
        Stack<String> tmp = new Stack<>();
        for (String s : stack) {
            tmp.push(s);
        }
        Stack<String> rst = new Stack<>();
        for (String s : tmp) {
            rst.push(s);
        }
        return rst;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int i = N;
            Node pointer = first;
            @Override
            public boolean hasNext() {
                return i > 0;
            }

            @Override
            public T next() {
                i--;
                Node now = pointer;
                pointer = pointer.next;
                return now.t;
            }
        };
    }
}
