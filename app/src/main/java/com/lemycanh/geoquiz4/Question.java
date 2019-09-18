package com.lemycanh.geoquiz4;

/**
 * Created by lemycanh on 18/9/2019.
 */

public class Question {
    String mCauHoi;
    boolean isTrue;

    public Question(String mCauHoi, boolean isTrue) {
        this.mCauHoi = mCauHoi;
        this.isTrue = isTrue;
    }

    public String getCauHoi() {
        return mCauHoi;
    }

    public boolean IsTrue() {
        return isTrue;
    }
}
