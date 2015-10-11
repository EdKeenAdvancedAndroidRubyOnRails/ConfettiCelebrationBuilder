package com.keened.confetticelebrationbuilder;


import android.graphics.Color;

import java.util.Random;

/**
 * Created by Ed on 10/9/2015.
 */
public class Confetti {

    private int mPointX;
    private int mPointY;

    private int mColor;

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

    //  sets one of six colors at random
    public void setColor() {
        int color = Color.WHITE;
        //random number between 1 and 6
        Random r = new Random();
        int i = r.nextInt(7 - 1) + 1;

        switch (i) {
            case 1:
                color = Color.RED;
                break;
            case 2:
                color = Color.GREEN;
                break;
            case 3:
                color = Color.BLUE;
                break;
            case 4:
                color = Color.YELLOW;
                break;
            case 5:
                color = Color.MAGENTA;
                break;
            case 6:
                color = Color.WHITE;
                break;
        }
        this.mColor = color;
    }

    public int getmColor() {
        return mColor;
    }




}
