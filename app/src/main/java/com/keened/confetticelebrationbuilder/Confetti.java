package com.keened.confetticelebrationbuilder;


import android.widget.Toast;

/**
 * Created by Ed on 10/9/2015.
 */
public class Confetti {

    private int mPointX;
    private int mPointY;

    public Confetti(int pointX, int pointY) {
        mPointX = pointX;
        mPointY = pointY;
    }

    public int getmPointX() {
        return mPointX;
    }

    public void setmPointX(int mPointX) {
        this.mPointX = mPointX;
    }

    public int getmPointY() {
        return mPointY;
    }

    public void setmPointY(int mPointY) {
        this.mPointY = mPointY;
    }


}
