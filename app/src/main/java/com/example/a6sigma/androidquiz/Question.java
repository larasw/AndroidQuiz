package com.example.a6sigma.androidquiz;

/**
 * Created by lenovo on 14/02/2017.
 */

public class Question {
    private int mTextRestId;

    private int mButton1;
    private int mButton2;
    private int mButton3;
    private int mButton4;

    private int mAnswer;


    public Question(int mTextRestId, int mButton1, int mButton2, int mButton3, int mButton4, int mAnswer) {
        this.mTextRestId = mTextRestId;
        this.mButton1 = mButton1;
        this.mButton2 = mButton2;
        this.mButton3 = mButton3;
        this.mButton4 = mButton4;
        this.mAnswer = mAnswer;
    }

    public int getmTextRestId() {
        return mTextRestId;
    }

    public void setmTextRestId(int mTextRestId) {
        this.mTextRestId = mTextRestId;
    }

    public int getmButton1() {
        return mButton1;
    }

    public void setmButton1(int mButton1) {
        this.mButton1 = mButton1;
    }

    public int getmButton2() {
        return mButton2;
    }

    public void setmButton2(int mButton2) {
        this.mButton2 = mButton2;
    }

    public int getmButton3() {
        return mButton3;
    }

    public void setmButton3(int mButton3) {
        this.mButton3 = mButton3;
    }

    public int getmButton4() {
        return mButton4;
    }

    public void setmButton4(int mButton4) {
        this.mButton4 = mButton4;
    }

    public int getmAnswer() {
        return mAnswer;
    }

    public void setmAnswer(int mAnswer) {
        this.mAnswer = mAnswer;
    }

   }
