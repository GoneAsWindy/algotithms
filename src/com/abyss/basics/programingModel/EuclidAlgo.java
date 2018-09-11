package com.abyss.basics.programingModel;

/**
 * @author abyss
 * @date 2018/9/8
 **/
public class EuclidAlgo {
    public static void main(String[] args) {
        System.out.println(getGcd(9, 6));
    }

    private static int getGcd(int p, int q){
        if (q == 0)
            return p;
        int r = p % q;
        return getGcd(q, r);
    }
}
