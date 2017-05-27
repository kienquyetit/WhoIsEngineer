package com.quyetdostudio.whoisengineer.entity;

/**
 * Created by QUYET on 5/27/2017.
 */

public class Question {
    private int stt;
    private String question;
    private String answerOne;
    private String answerTwo;
    private String answerThree;
    private String answerFour;

    public Question(){

    }

    public Question(int stt, String question, String answerOne, String answerTwo, String answerThree, String answerFour) {
        this.stt = stt;
        this.question = question;
        this.answerOne = answerOne;
        this.answerTwo = answerTwo;
        this.answerThree = answerThree;
        this.answerFour = answerFour;
    }

    public int getStt() {
        return stt;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswerOne() {
        return answerOne;
    }

    public String getAnswerTwo() {
        return answerTwo;
    }

    public String getAnswerThree() {
        return answerThree;
    }

    public String getAnswerFour() {
        return answerFour;
    }
}
