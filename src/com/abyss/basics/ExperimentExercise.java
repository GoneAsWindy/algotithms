package com.abyss.basics;

import com.google.gson.Gson;

import java.util.Random;

/**
 * @author abyss
 * @date 2018/9/10
 **/
public class ExperimentExercise {
    private int SIDES = 6;

    private void rollExactlly(){

        double[] dist = new double[2 * SIDES + 1];
        for (int i = 1; i <= SIDES; i++) {
            for (int j = 1; j <= SIDES; j++) {
                dist[i + j] += 1.0;
            }
        }
        for (int k = 2; k <= 2 * SIDES; k++) {
            dist[k] /= 36.0;
        }
        Gson gson = new Gson();
        System.out.println(gson.toJson(dist));
    }

    private void rollSimulation(int n){
        double[] dist = new double[2 * SIDES + 1];
        Random r1 = new Random();
        Random r2 = new Random();
        for (int i = 0; i < n; i++) {
            int i1 = r1.nextInt(6) + 1;
            int i2 = r2.nextInt(6) + 1;
            dist[i1 + i2] += 1.0;
        }
        for (int k = 2; k <= 2 * SIDES; k++) {
            dist[k] /= n;
        }
        Gson gson = new Gson();
        System.out.println(gson.toJson(dist));
    }

    public static void main(String[] args) {
        ExperimentExercise exercise = new ExperimentExercise();
        exercise.rollExactlly();
        exercise.rollSimulation(1000000);
    }
}
