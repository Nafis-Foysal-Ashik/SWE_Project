package com.example.study;

import com.google.android.material.color.utilities.Score;

public class ScoreManager {
    private static ScoreManager instance ;
    private int score;

    private ScoreManager(){
        score=0;
    }
    public static ScoreManager getInstance(){
        if(instance==null){
            instance=new ScoreManager();
        }
        return instance;
    }

    public void incrementScore()
    {
        score++;
    }
    public int getScore(){
        return score;
    }
}
