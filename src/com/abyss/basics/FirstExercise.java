package com.abyss.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author abyss
 * @date 2018/9/8
 **/
public class FirstExercise {
    private static void isEqual(){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        if (a == b && b == c)
            System.out.println("equal");
        else
            System.out.println("not equal");
    }

    private static boolean compare01(double v){
        return 0 < v && v < 1;
    }

    private static boolean between01(double x, double y){
        return compare01(x) && compare01(y);
    }

    private static long fibonacci(int n){
        long f = 0;
        long g = 1;
        for (int i = 0; i <= n; i++) {
            f = f + g;
            g = f - g;
        }
        return g;
    }

    private static void calculateA(){
        double t =9.0;
        while (Math.abs(t - 9.0/t) > .001)
            t = (9.0/t + t)/2.0;
        System.out.printf("%.5f\n", t);
    }

    private static void calculateB(){
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            for (int j = 0; j < i; j++) {
                sum ++;
            }
        }
        System.out.println(sum);
    }

    private static String toBinaryString(int n){
        StringBuilder s = new StringBuilder();
        for (int m = n; m > 0; m /= 2)
            s.insert(0, (m % 2));
        return s.toString();
    }

    private static void printArr(boolean[][] b){
        System.out.print("\t");
        for (int i = 1; i <= b[0].length; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();
        for (int i = 0; i < b.length; i++) {
            System.out.print(i + 1 + "\t");
            for (int j = 0; j < b[i].length; j++) {
                if (b[i][j])
                    System.out.print("*\t");
                else
                    System.out.print(" \t");
            }
            System.out.println();
        }

    }

    private static void changeArr(){
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = 9 - i;
        }
        for (int i = 0; i < 10; i++) {
            a[i] = a[a[i]];
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(a[i]);
        }
    }

    private static Object[][] exchangeArr(Object[][] arr){
        if (arr.length == 0) {
            return new Object[0][0];
        }
        Object[][] objects = new Object[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                objects[j][i] = arr[i][j];
            }
        }
        return objects;
    }

    private static int log2(int N){
        int count = 0;
        while (N/2 > 0){
            count ++;
            N = N/2;
        }
        return count;
    }

    private static String exR1(int n){
        if (n <= 0)
            return "";
        return exR1(n - 3) + n + exR1(n-2) + n;
    }

    public static void main(String[] args) {
//        1.1.3
//        isEqual();
//        1.1.5
//        System.out.println(between01(0.12, 1.0));
//        1.1.6
//        fibonacci(15);
//        1.1.7.a
//        calculateA();
//        1.1.7.b
//        calculateB();
//        System.out.println('b');
//        System.out.println('b');
//        System.out.println(toBinaryString(4));
////
////        System.out.println(Integer.toOctalString(456));
////        System.out.println(toBinaryString(456));
//        1.1.11
//        Boolean[][] arr = new Boolean[5][6];
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 6; j++) {
//                arr[i][j] = (i + j) % 2 == 0;
//            }
//        }
//        printArr(arr);
//        1.1.12
//        changeArr();
//        1.1.13
//        exchangeArr(arr);
//        1.1.14
//        System.out.println(log2(64));

//        System.out.println(exR1(6));
//        System.out.println(mystery(2, 3));
//        System.out.println(mystery(3, 3));
//        long startTime = System.currentTimeMillis();
//        System.out.println(startTime);
//        for (int i = 0; i < 100; i++) {
//            // fib 是通过递归的方式计算的斐波那契数列， fibonacci 是通过累加循环的方式计算，试验表明，循环的方式效率高很多，计算时间1ms都不到，但是递归深度到40左右就非常慢了
//            // 因此通过递归方式计算必须做相关的优化
//            System.out.println(i + " : " + fibonacci(i));
//            System.out.println(i + " : " + fib(i, 1, 1));
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println(endTime);
//        System.out.println(endTime - startTime);
//        System.out.println(lnFactorial(20));
//        int[] arr = {1,4,5,6,8,0,2,11,43,23};
//        Arrays.sort(arr);
//        System.out.println(binarySearch(0, 10, arr, 43, 0));
//        System.out.println(euclid(1111111, 1234567));
        printArr(euclidArr(6, 7));
    }

    private static int mystery(int a, int b) {
        if (b == 0)
            return 1;
        if (b % 2 == 0)
            return mystery(a * a, b / 2);
        return mystery(a * a, b / 2) * a;
    }

    // 尾递归
    private static long fib(int N, long a, long b) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return a;
        }
        return fib(N - 1, b, a + b);
    }

    private static long factorial(long n){
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    private static double lnFactorial(long n) {
        return Math.log(factorial(n));
    }

    private static int binarySearch(int lo, int hi, int[] arr, int n, int height) {
        height ++;
        for (int i = 0; i < height; i++) {
            System.out.print("\t");
        }
        System.out.println("lo:"+lo + ", hi:"+ hi);
        if (lo > hi) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if (arr[mid] > n) {

            return binarySearch(lo, mid, arr, n, height);
        } else if (arr[mid] < n) {

            return binarySearch(mid, hi, arr, n, height);
        } else {
            return mid;
        }
    }

    private static int euclid(int a, int b){
        System.out.println("a:" + a + ", b:" + b);
        if (b == 0) {
            return a;
        }
        int r = a % b;
        return euclid(b, r);
    }

    private static boolean[][] euclidArr(int x, int y) {
        boolean[][] booleans = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                booleans[i][j] = euclid(i + 1, j + 1) == 1;
            }
        }
        return booleans;
    }


}
