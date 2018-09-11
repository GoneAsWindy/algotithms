package com.abyss.basics.bagStackQueue;

/**
 * @author matth
 * @date 2018/9/11
 * 字符串定容栈
 */
public class FixedCapacityStackOfStrings {
    private String[] a;
    private int N;

    public FixedCapacityStackOfStrings(int size) {
        a = new String[size];
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    public void push(String val){
        a[N++] = val;
    }

    public String pop(){
        return a[--N];
    }
}
