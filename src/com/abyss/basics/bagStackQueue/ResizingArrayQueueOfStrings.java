package com.abyss.basics.bagStackQueue;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author abyss
 * @date 2018/9/18
 **/
public class ResizingArrayQueueOfStrings implements Iterable {

    private String[] a = new String[1];
    private int N;

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void add(String s){
        if (N == a.length) {
            a = Arrays.copyOf(this.a, this.a.length * 2);
        }
        a[N] = s;
        N++;
    }

    public String remove(){
        String result = a[0];
        N--;
        if (N < a.length / 2) {
            a = Arrays.copyOf(this.a, a.length/2);
        }
        String[] tmp = new String[a.length];
        System.arraycopy(a,1, tmp, N-1, a.length);
        a = tmp;
        return result;
    }



    @Override
    public Iterator iterator() {
        return new Iterator() {
            int position = 0;
            @Override
            public boolean hasNext() {
                return position < N;
            }

            @Override
            public Object next() {
                return a[position++];
            }
        };
    }
}
