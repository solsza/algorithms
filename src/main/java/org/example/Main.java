package org.example;

import org.example.solutions.DefaultSolution;
import org.example.solutions.dynamic.Tribonacci;

public class Main {
    public static void main(String[] args) {
        DefaultSolution defaultSolution = new Tribonacci();
        defaultSolution.runDefaultExample();
    }
}