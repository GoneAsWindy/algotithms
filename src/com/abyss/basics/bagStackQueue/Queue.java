package com.abyss.basics.bagStackQueue;

import java.util.Iterator;

/**
 * @author abyss
 * @date 2018/9/12
 **/
public class Queue<T> implements Iterable<T> {

    private class Node{
        T t;
        Node next;
    }

    private Node first;
    private Node last;
    private int N;

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void push(T t){
        if (first == null) {
            first = new Node();
            first.t = t;
            last = first;
        }else {
            Node node = new Node();
            node.t = t;
            last.next = node;
            last = node;
        }
        N++;
    }

    public T pop(){
        if (N == 0) {
            return null;
        }
        Node oldFirst = this.first;
        first = first.next;
        N--;
        return oldFirst.t;
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
                Node oldPointer = this.pointer;
                pointer = pointer.next;
                return oldPointer.t;
            }
        };
    }
}
