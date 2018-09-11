package com.abyss.basics.bagStackQueue;

/**
 * @author matth
 * @date 2018/9/11
 * 定容栈
 */
public class FixedCapacityStack<T> {
    private T[] a;
    private int N;

    public FixedCapacityStack(int size){
        a = (T[]) new Object[size];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void push(T t){
        a[N++] = t;
    }

    public T pop(){
        return a[--N];
    }
}
