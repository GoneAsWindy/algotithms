package com.abyss.basics.bagStackQueue;

import java.util.ArrayList;

/**
 * @author matth
 * @date 2018/9/11
 */
public class ArrayStack<T> {

    private T[] a;
    private int N;

    public ArrayStack(int size){
        a = (T[]) new Object[size];
    }

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
        for (int i = 0; i < a.length; i++) {
            tmp[i] = a[i];
        }
        a = tmp;
    }
}
