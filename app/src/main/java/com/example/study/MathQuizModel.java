package com.example.study;

public class MathQuizModel {
    private static MathQuizModel instance;

    private MathQuizModel() {
        // Private constructor to prevent instantiation
    }

    public static synchronized MathQuizModel getInstance() {
        if (instance == null) {
            instance = new MathQuizModel();
        }
        return instance;
    }

    // Add your model methods and fields here
}
