package com.abyss.basics.bagStackQueue;

import java.util.Iterator;

/**
 * @author matth
 * @date 2018/9/11
 * 数组实现的可变长度栈
 */
public class ResizingArrayStack<T> implements Iterable<T> {

    private T[] a = (T[]) new Object[1];
    private int N;


    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void push(T t){
        if (a.length == N) {
            this.resize(a.length * 2);
        }
        a[N++] = t;
    }

    public T pop(){
        T t = a[--N];
        a[N] = null;
        if (N>0 && N - 1 < a.length / 4) {
            this.resize(a.length/2);
        }
        return t;
    }

    private void resize(int max){
        T[] tmp = (T[]) new Object[max];
        System.arraycopy(a, 0, tmp, 0, a.length);
        a = tmp;
    }
    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<T>{

        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            return a[--i];
        }

    }
}
