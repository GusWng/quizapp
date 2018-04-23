package com.example.augustowang.quizalmost;

import java.util.ArrayList;

public class questionSet extends ArrayList<questionSet> {
    //Variable Declaration
    private String mQuestion;
    private String mAnswerA;
    private String mAnswerB;
    private String mAnswerC;
    private String mTrue;

    //Constructor
    public questionSet(String question, String a, String b, String c, String trueAnswer){
        setmQuestion(question);
        setmAnswerA(a);
        setmAnswerB(b);
        setmAnswerC(c);
        setmTrue(trueAnswer);
    }



    //Getter and Setter

    public String getmQuestion() {
        return mQuestion;
    }

    public void setmQuestion(String mQuestion) {
        this.mQuestion = mQuestion;
    }

    public String getmAnswerA() {
        return mAnswerA;
    }

    public void setmAnswerA(String mAnswerA) {
        this.mAnswerA = mAnswerA;
    }

    public String getmAnswerB() {
        return mAnswerB;
    }

    public void setmAnswerB(String mAnswerB) {
        this.mAnswerB = mAnswerB;
    }

    public String getmAnswerC() {
        return mAnswerC;
    }

    public void setmAnswerC(String mAnswerC) {
        this.mAnswerC = mAnswerC;
    }

    public String getmTrue() {
        return mTrue;
    }

    public void setmTrue(String mTrue) {
        this.mTrue = mTrue;
    }

    public void ok(int wow){
        int i=wow;
    }
}
