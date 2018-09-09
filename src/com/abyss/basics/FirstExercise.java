package com.abyss.basics;

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

    private static void fibonacci(int n){
        int f = 0;
        int g = 1;
        for (int i = 0; i <= n; i++) {
            System.out.println(f);
            f = f + g;
            g = f - g;
        }
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
        boolean[][] arr = new boolean[5][6];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = (i + j) % 2 == 0;
            }
        }
        printArr(arr);
    }


}
