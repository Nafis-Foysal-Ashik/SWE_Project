package com.example.study;

public class CorrBtnClick implements BtnClick {

    @Override
    public void onClick() {
        ScoreManager.getInstance().incrementScore();
    }

}
