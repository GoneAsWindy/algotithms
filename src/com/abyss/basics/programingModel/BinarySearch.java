package com.abyss.basics.programingModel;

import java.util.Scanner;

/**
 * @author abyss
 * @date 2018/9/8
 **/
public class BinarySearch {
    private static int rank(int key, int[] a){
        int low = 0;
        int high = a.length -1;
        while (low <= high){
            int mid = (low + high)/2;
            if (key < a[mid])
                high = mid - 1;
            else if (key > a[mid])
                low = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
//        for (int i = 0; i < 4; i++) {
//            Scanner scanner = new Scanner(System.in);
//            int[] arr = {12, 23, 24, 44, 66, 69, 78, 90, 122, 234, 444, 666, 777, 1000, 3432, 7983, 8747, 23421};
//            int j = scanner.nextInt();
//            System.out.println(rank(j, arr));
//        }
        // -2147483648 的绝对值为 -2147483648， 这里是因为 2147483648 已经超出了int的范围 2147483648～-2147483647， 而编译器会先讲起识别为一个超范围的long，而后再进行运算
        System.out.println(Math.abs(-2147483648));
        System.out.println(-2147483648);
        int i31 = (int) Math.pow(2, 31);
        System.out.println(Math.pow(2, 31));
        String s = Integer.toBinaryString(i31);
        System.out.println(s);
        System.out.println(s.length());
        int m31 = - (i31);
        System.out.println("-2^31 = " + m31);
        String s1 = Integer.toBinaryString(m31);
        System.out.println(s1);
        System.out.println(s1.length());
        System.out.println(Integer.toBinaryString(-1));
        double d = 89834080384303084300.12122121212121212121212121233332323234424343434433434333d;
        System.out.println(Double.toString(d));

        System.out.println(2.0e-6 * 100000000.1);

        System.out.println(true && false || true && true);
        System.out.println((1+2.236) / 2);
        System.out.println(1+2+3+4.0);
        System.out.println(1 + 2 + "3");

    }
}
